# Reviewed Security Findings Report

**Project:** dhbwmawwi2025sea
**Date:** 2026-04-28
**Reviewer:** Security Companion

---

## Review Summary

- **Original findings count:** 6
- **Findings kept (unchanged):** 2 (#1, #3)
- **Findings modified:** 1 (#2 → scoped to information disclosure / bad logging pattern; CRLF stretch removed)
- **Findings removed:** 3 (#4 low criticality; #5 low criticality; #6 low criticality)
- **Duplicates merged:** 0
- **Final findings count:** 3

The original report was accurate and evidence-backed with correct file paths and line numbers. All six claims were verified against the codebase. Criticality ratings were correctly derived from the matrix given the local-desktop deployment context. Three low-criticality findings were removed per workshop filter criteria — all three represent real issues but do not justify threat modeling discussion time. The three surviving findings share a common root: the codebase teaches unsafe patterns (no input validation, no structured logging, sensitive output to stdout) that students will carry into production systems — this pedagogical risk is the primary workshop-worthy concern.

---

## Findings Table

| # | Threat | Threat Narrative | Attack Precondition | Component | Ease of Attack | Impact | Criticality | Source |
|---|--------|-----------------|---------------------|-----------|---------------|--------|-------------|--------|
| 1 | Unguarded Integer Parsing — Application Crash | `Integer.parseInt(userInput)` at `UserInput.java:9` is called directly on `JOptionPane` dialog input without try/catch or null guard. Entering a non-integer string or cancelling the dialog throws an uncaught `NumberFormatException` crashing the program. Same pattern in `Ungerade.java:10` and `SiebDesEratosthenes.java:10`. | User enters non-integer text in a Swing dialog or passes a non-integer command-line argument on a local machine. | Exercise Solutions (`src/excersises/chapter4/`) | Easy | Minor | medium | PSS-IO-14, OWASP-A03, STRIDE-DoS, SEC-100 |
| 2 | Sensitive UI State Logged to Unprotected Stdout | `Logon.java:192` echoes the selected protocol and port directly to stdout with no timestamp, no log level, and no sanitization. The surrounding code also logs ActionEvent metadata (modifier masks, timestamps, parameter strings) at debug verbosity without any log level control, teaching students a pattern of exposing internal state to unprotected output streams. | User clicks Login in the local Swing UI. No privilege required. | Swing GUI Demo (`src/lecture/chapter10/Logon.java`) | Easy | Minor | medium | PSS-Log-01, STRIDE-I, OWASP-A09, SEC-215 |
| 3 | No Security Logging Infrastructure | The entire codebase uses only `System.out.println()` / `IO.println()`. No logging framework, no log levels, no timestamps, no structured event format. Any security-relevant event (e.g., login attempt in `Logon.java:192`) leaves no audit trail, making repudiation undetectable and forensic reconstruction impossible. | Any user performs any action — no audit trail exists. | All components | Easy | Minor | medium | PSS-Log-01, PSS-Log-02, OWASP-A09, STRIDE-R, SEC-215 |

---

## Detailed Findings

---

#### Finding #1: Unguarded Integer Parsing — Application Crash

**Source:** PSS-IO-14 (Invalid input), OWASP A03, STRIDE-DoS, SEC-100
**Component:** Exercise Solutions (`src/excersises/chapter4/UserInput.java`, `src/excersises/chapter4/Ungerade.java`, `src/excersises/chapter4/SiebDesEratosthenes.java`)
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
`UserInput.java:9` calls `Integer.parseInt(userInput)` on the raw string returned by `JOptionPane.showInputDialog()` with no surrounding try/catch and no null check. If the user enters a non-integer string (e.g., `"abc"`, an empty string) or dismisses the dialog (which returns `null`), a `NumberFormatException` or `NullPointerException` propagates uncaught and crashes the application. The same anti-pattern appears in `Ungerade.java:10` for command-line argument parsing (no `args.length` check, no exception handling) and `SiebDesEratosthenes.java:10`. While the impact in this local educational context is limited to a crashed JVM process, this pattern is directly teaching SEC-100 non-compliance and will be replicated in production code by students.

**Evidence:**
- File: `src/excersises/chapter4/UserInput.java`, line 9 — `return Integer.parseInt(userInput);` — no try/catch, no null check on `userInput`
- File: `src/excersises/chapter4/Ungerade.java`, line 10 — `og = Integer.parseInt(args[0]);` — no `args.length` guard, no exception handling
- File: `src/excersises/chapter4/SiebDesEratosthenes.java`, line 10 — `int og = Integer.parseInt(s);` — no exception handling

**Attack Precondition:**
User has local access to the running application and enters non-integer input in a Swing dialog or provides a non-integer / missing command-line argument.

**Recommendation:**
Wrap `Integer.parseInt()` in a try/catch for `NumberFormatException`. For dialog input, also null-check before parsing (dialog cancel returns `null`). Use this as a teaching opportunity for SEC-100 input validation:
```java
String userInput = JOptionPane.showInputDialog(inputExplanation);
if (userInput == null) { /* user cancelled */ return 0; }
try {
    return Integer.parseInt(userInput);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Please enter a valid integer.");
    return 0;
}
```

---

#### Finding #2: Sensitive UI State Logged to Unprotected Stdout

**Source:** PSS-Log-01 (Correct logging events), STRIDE-I (Information Disclosure), OWASP A09, SEC-215
**Component:** Swing GUI Demo (`src/lecture/chapter10/Logon.java`)
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
`Logon.java:192` echoes the selected protocol and port value directly to stdout: `System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText())`. The value is UI state (not a real credential), but the pattern demonstrates logging form field values to an uncontrolled output stream with no timestamp, no log level, and no sanitization. The surrounding ActionListener (lines 164–191) also logs extensive ActionEvent metadata (modifier key bit masks, timestamps, parameter strings) at undifferentiated verbosity, conflating debug output with security-relevant events. In a production system copying this pattern, this would constitute information disclosure (internal state exposed) and failure to distinguish security-relevant events from noise. Note: the CRLF injection risk via `portField` is not credible because `MaskFormatter("#####")` restricts the field to 5 digits.

**Evidence:**
- File: `src/lecture/chapter10/Logon.java`, line 192 — `System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText())`
- File: `src/lecture/chapter10/Logon.java`, lines 164–191 — `System.out.println` of ActionEvent metadata including modifier bitmasks and parameter strings
- `portField` uses `MaskFormatter("#####")` (line ~40) — limits to 5 digits, ruling out CRLF injection via that field

**Attack Precondition:**
User clicks Login in the local Swing UI. On a shared machine, another process capturing stdout could read the output. More practically: a developer copies this pattern into a production application where form field values (including passwords) are echoed to logs.

**Recommendation:**
Use a structured logging framework (e.g., `java.util.logging.Logger` or SLF4J) with appropriate log levels. Never echo form field values to logs — log only sanitized, non-sensitive event identifiers. Distinguish between debug output (log level FINE/DEBUG) and security events (log level INFO/WARNING with structured fields: timestamp, user, event type, outcome). This finding is primarily pedagogical: the code should model correct logging behavior.

---

#### Finding #3: No Security Logging Infrastructure

**Source:** PSS-Log-01, PSS-Log-02, OWASP A09 (Security Logging and Monitoring Failures), STRIDE-R (Repudiation), SEC-215
**Component:** All components
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
The entire codebase uses only `System.out.println()` / `IO.println()` for all output. No logging framework is imported anywhere (confirmed: zero occurrences of `java.util.logging`, `org.slf4j`, `log4j`, or similar). There are no log levels, no timestamps, no event types, no user identifiers, and no structured log format. The simulated login event in `Logon.java:192` is the closest thing to a security-relevant event in the codebase, yet it produces only a plaintext stdout line with no timestamp and no user identity capture. SEC-215 requires that security-relevant events be logged with timestamp, user identity, event type, and outcome. Without this, no audit trail exists: actions cannot be attributed, reconstructed, or used for incident response.

**Evidence:**
- Grep for `import java.util.logging`, `import org.slf4j`, `import org.apache.log4j`, `import ch.qos` across all `.java` files returns zero matches
- File: `src/lecture/chapter10/Logon.java`, line 192 — only security-relevant event in the codebase; logged as unstructured `System.out.println` with no timestamp or user identity
- No `log4j.properties`, `logback.xml`, `logging.properties`, or equivalent configuration file found in the project

**Attack Precondition:**
Any user performs any security-relevant action (login attempt, configuration change, data access). Without structured logging, no audit trail exists to detect, attribute, or reconstruct the action.

**Recommendation:**
Introduce `java.util.logging.Logger` (available in the JDK, no external dependency needed) as the logging mechanism in lecture examples. Demonstrate logging a security event with the required fields per SEC-215: timestamp, user identity, event type, outcome. This converts an anti-pattern into a teaching opportunity:
```java
private static final Logger LOG = Logger.getLogger(Logon.class.getName());
// on login attempt:
LOG.log(Level.INFO, "LOGIN_ATTEMPT user={0} protocol={1} port={2}",
    new Object[]{userNameField.getText(), myComboBox.getSelectedItem(), portField.getText()});
```
Never log password values. For production guidance, use SLF4J + Logback with a structured JSON appender and forward to a centralized log management system per SEC-215.

---

## Review Log

| Original # | Original Threat | Disposition | Reason |
|------------|----------------|-------------|--------|
| 1 | Unguarded Integer Parsing — Application Crash | **KEPT** → Finding #1 | Evidence verified at `UserInput.java:9`, `Ungerade.java:10`, `SiebDesEratosthenes.java:10`. Criticality medium confirmed (Minor × Easy). Relevant workshop discussion: teaching safe input validation patterns. |
| 2 | Sensitive UI Fields Printed to Stdout Without Sanitization | **MODIFIED** → Finding #2 | Evidence verified at `Logon.java:192`. Removed the CRLF injection stretch (MaskFormatter limits port to digits). Refocused finding on information disclosure via uncontrolled stdout and bad logging patterns rather than injection. Criticality remains medium. |
| 3 | No Security Logging Infrastructure | **KEPT** → Finding #3 | Evidence verified: zero logging framework imports across all Java source files. Criticality medium confirmed (Minor × Easy). Core pedagogical finding. |
| 4 | `Hotel` Implements `Serializable` Without `serialVersionUID` | **REMOVED: Low criticality** | Evidence verified at `Hotel.java:7`. Criticality is low (Minor × Complex). No actual serialization/deserialization occurs in the codebase — threat is purely theoretical. Not worth workshop time. |
| 5 | Commented-Out Dead Code Left in Source Files | **REMOVED: Low criticality** | Evidence verified in `Logon.java`, `RuntimeExceptionExamples.java`, `TravelAgency.java`. Criticality is low (Minor × Easy). A style concern for this educational codebase, not a threat modeling discussion item. |
| 6 | No Dependency Manifest — Unverifiable Supply Chain | **REMOVED: Low criticality** | Evidence verified: no `pom.xml` / `build.gradle` found. Criticality is low (Minor × Complex). Valid finding but not a threat modeling workshop item for a local educational JVM project with no external consumers. |
