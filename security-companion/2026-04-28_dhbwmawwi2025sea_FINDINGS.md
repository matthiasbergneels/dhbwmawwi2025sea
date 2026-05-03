# Security Findings Report

**Project:** dhbwmawwi2025sea
**Date:** 2026-04-28
**Analyst:** Security Companion

---

## Executive Summary

This report contains **6 findings** across the following criticality levels:
- **Critical:** 0
- **High:** 0
- **Medium:** 3
- **Low:** 3

The analyzed project is a **standalone, local Java educational codebase** — a university lecture repository with no network services, no database, no authentication backend, and no external communication. Its attack surface is correspondingly narrow. The findings are real code-level observations but must be understood in context: most PSS/OWASP/STRIDE threats that would be critical in a SaaS product are simply not present here because the attack surface does not exist.

The three medium findings are:
- **Unguarded integer parsing** from GUI/dialog user input (crash vulnerability)
- **Sensitive UI values printed to unprotected stdout** (information disclosure)
- **No structured security logging** anywhere in the codebase (repudiation/forensics gap)

The three low findings concern dead code patterns, a `Serializable` implementation, and the absence of dependency pinning — all minor in a local educational context.

> **Key risk areas:** Input validation (crash on invalid input), information disclosure via stdout, and logging deficiency. No injection, authentication, authorization, or network channel threats are applicable given the deployment context.

---

## Findings Table

| # | Threat | Threat Narrative | Attack Precondition | Component | Ease of Attack | Impact | Criticality | Source |
|---|--------|-----------------|---------------------|-----------|---------------|--------|-------------|--------|
| 1 | Unguarded Integer Parsing — Application Crash | `Integer.parseInt(userInput)` in `UserInput.java:9` is called directly on `JOptionPane` dialog input without any try/catch. A non-integer string (e.g., `"abc"`, empty string) throws an uncaught `NumberFormatException` that crashes the calling program. Same pattern exists in `Ungerade.java:10` and `SiebDesEratosthenes.java:10` for command-line args. | User enters non-integer text in a Swing dialog or passes non-integer command-line argument. Requires local machine access (already trusted). | Exercise Solutions (`src/excersises/chapter4/UserInput.java`) | Easy | Minor | medium | PSS-IO-14, OWASP-A03, STRIDE-DoS, SEC-100 |
| 2 | Sensitive UI Fields Printed to Stdout Without Sanitization | `Logon.java:192` prints the selected protocol and port value directly to stdout: `System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText())`. While no real credentials are transmitted, the design pattern teaches the practice of echoing form values (including the nearby password field) to stdout, and the port text could include injected CRLF characters. | User interacts with the Logon UI and clicks Login. No privilege required. | Swing GUI Demo (`src/lecture/chapter10/Logon.java`) | Easy | Minor | medium | PSS-IO-15, PSS-Log-01, STRIDE-I, OWASP-A09, SEC-215 |
| 3 | No Security Logging Infrastructure | The codebase contains no structured security logging. All output is via `System.out.println()` or `IO.println()` to stdout with no timestamps, no log levels, no structured format, and no centralized log management. Any security-relevant event (e.g., a login attempt in `Logon.java`) cannot be audited, replicated, or monitored. | An attacker or misbehaving user performs any action — no audit trail exists to detect or reconstruct it. | All components | Easy | Minor | medium | PSS-Log-01, PSS-Log-02, OWASP-A09, STRIDE-R, SEC-215 |
| 4 | `Hotel` Implements `Serializable` Without `serialVersionUID` | `src/lecture/chapter7/Hotel.java:7` declares `implements Serializable` without defining `private static final long serialVersionUID`. This means Java generates an implicit UID from class structure. Any refactoring breaks deserialization of previously serialized objects, and deserialization of untrusted data (if Hotel objects were ever persisted/received externally) could enable gadget-chain attacks. In the current educational context there is no external deserialization path. | Serialized `Hotel` objects must be received from an untrusted source. Not present in current codebase. | Lecture Examples (`src/lecture/chapter7/Hotel.java`) | Complex | Minor | low | PSS-IO-17, OWASP-A08 |
| 5 | Commented-Out Dead Code and Replaced Logic Left in Production Source | Multiple files contain extensive blocks of commented-out code (e.g., `Logon.java` contains 20+ lines of commented-out ItemListener and control flow; `RuntimeExceptionExamples.java` contains commented-out try/catch blocks). Per PSS-Prev-04, shipping code containing unused/dead sections increases the attack surface as it may reveal implementation details or contain insecure patterns. | Source code is accessible (e.g., repository is public). | All lecture example source files | Easy | Minor | low | PSS-Prev-04, SEC-246 |
| 6 | No Dependency Manifest — Unverifiable Supply Chain | The project has no Maven `pom.xml`, no Gradle build file, and no lock file. JUnit 5 and the JDK (`sap-25`) are consumed via IntelliJ IDEA module configuration (`.idea/dhbwmawwi2025sea.iml`) without version pinning or integrity verification. There is no Software Composition Analysis (SCA) possible. | Attacker would need to compromise the JetBrains dependency cache or the JDK distribution. Requires elevated access. | Build toolchain / Supply chain | Complex | Minor | low | PSS-Prev-23, PSS-Prev-24, OWASP-A06 |

---

## Detailed Findings

---

#### Finding #1: Unguarded Integer Parsing — Application Crash

**Source:** PSS-IO-14 (Invalid input), OWASP A03 (Injection / input handling), STRIDE-DoS, SEC-100
**Component:** Exercise Solutions (`src/excersises/chapter4/UserInput.java`, `src/excersises/chapter4/Ungerade.java`, `src/excersises/chapter4/SiebDesEratosthenes.java`)
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
`UserInput.java:9` calls `Integer.parseInt(userInput)` on the raw string returned by `JOptionPane.showInputDialog()` without any surrounding try/catch block. If the user enters a non-integer value (empty string, letters, floats, null on dialog cancel), a `NumberFormatException` is thrown and propagates uncaught to the caller, crashing the program. The same pattern exists for command-line arguments in `Ungerade.java:10` (`Integer.parseInt(args[0])`) and `SiebDesEratosthenes.java:10`. While the impact is limited to a crash on a local educational tool, this is a direct violation of SEC-100 (input validation) and an exploitable denial-of-service at the local process level.

**Evidence:**
- File: `src/excersises/chapter4/UserInput.java`, line 9 — `return Integer.parseInt(userInput);` — no try/catch, no null check
- File: `src/excersises/chapter4/Ungerade.java`, line 10 — `og = Integer.parseInt(args[0]);` — no bounds check on `args.length`, no exception handling
- File: `src/excersises/chapter4/SiebDesEratosthenes.java`, line 10 — `int og = Integer.parseInt(s);` — no exception handling

**Attack Precondition:**
User has local access to the running application and enters non-integer input in a Swing dialog or provides a non-integer command-line argument.

**Recommendation:**
Wrap `Integer.parseInt()` calls in try/catch blocks catching `NumberFormatException`. For the dialog variant, also null-check the return value (dialog cancel returns `null`). Example: `try { return Integer.parseInt(userInput); } catch (NumberFormatException e) { /* show error dialog */ }`. For command-line args, validate `args.length > 0` before accessing `args[0]`.

---

#### Finding #2: Sensitive UI Fields Printed to Stdout Without Sanitization

**Source:** PSS-IO-15 (CRLF injection), PSS-Log-01 (logging), STRIDE-I (Information Disclosure), OWASP A09, SEC-215
**Component:** Swing GUI Demo (`src/lecture/chapter10/Logon.java`)
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
`Logon.java:192` outputs the selected protocol and port text directly to stdout via `System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText())`. Although `portField` uses a `MaskFormatter("#####")` limiting it to 5 digits, the general pattern demonstrates echoing UI form values to an unprotected output stream. More significantly, the `JPasswordField userPasswordField` is declared at line 122 but its value is never read — however the pedagogical pattern shown suggests that in an extension or copy of this code, a developer could easily add `userPasswordField.getPassword()` to the same println statement, disclosing credentials. Additionally, the port value could in theory contain CRLF characters if the formatter is bypassed. The code also performs extensive debug-quality logging of event metadata (modifier keys, timestamps, parameter strings) to stdout at lines 164–191, without any log level control.

**Evidence:**
- File: `src/lecture/chapter10/Logon.java`, line 192 — `System.out.println("Login mit Protokoll: " + myComboBox.getSelectedItem() + " auf Port: " + portField.getText())`
- File: `src/lecture/chapter10/Logon.java`, lines 164–191 — extensive `System.out.println` of ActionEvent metadata including modifier bit masks
- File: `src/lecture/chapter10/Logon.java`, lines 122–123 — `JPasswordField` declared but `.getPassword()` never called (correct), but proximity to println creates pedagogical risk

**Attack Precondition:**
User interacts with the Logon Swing UI on a shared machine where stdout is captured by another process, or where this code pattern is copied into a real application.

**Recommendation:**
Replace `System.out.println` with a structured logging framework (e.g., SLF4J/Logback). Never echo form field values (especially password fields) to logs. Apply log-level controls so debug output is disabled by default. Sanitize any user-controlled string before logging to prevent CRLF injection into log streams.

---

#### Finding #3: No Security Logging Infrastructure

**Source:** PSS-Log-01, PSS-Log-02, OWASP A09 (Security Logging and Monitoring Failures), STRIDE-R (Repudiation), SEC-215
**Component:** All components
**Criticality:** medium (Impact: Minor, Ease: Easy)

**Description:**
The entire codebase uses only `System.out.println()` / `IO.println()` for output. There is no logging framework, no log levels, no timestamps, no structured event format, and no concept of security-relevant events vs. debug output. SEC-215 requires that security-relevant events be logged with timestamp, user identity, event type, and outcome. In the `Logon.java` GUI demo, a simulated login event at line 192 produces a plaintext stdout line with no timestamp, no user identity capture, and no audit trail. This means no forensic reconstruction of events is possible and repudiation attacks cannot be detected.

**Evidence:**
- File: `src/lecture/chapter10/Logon.java`, line 192 — login event logged only as `System.out.println("Login mit Protokoll: ...")` — no timestamp, no structured format
- All `src/lecture/` and `src/excersises/` files — grep for `import java.util.logging\|import org.slf4j\|import org.apache.log4j` returns zero matches
- No `log4j.properties`, `logback.xml`, `logging.properties`, or equivalent configuration file found anywhere in the project

**Attack Precondition:**
Any user or attacker performs actions. Without logging, no audit trail exists to detect, attribute, or reconstruct them.

**Recommendation:**
Adopt Java's built-in `java.util.logging` or a standard framework (SLF4J + Logback) as a teaching example. Log security-relevant events (login attempts, errors, configuration changes) with at minimum: timestamp, event type, user identity, and outcome. This is particularly important to teach correct patterns to students who will apply them in production systems.

---

#### Finding #4: `Hotel` Implements `Serializable` Without `serialVersionUID`

**Source:** PSS-IO-17 (Deserialization tampering), OWASP A08 (Software and Data Integrity Failures)
**Component:** Lecture Examples (`src/lecture/chapter7/Hotel.java`)
**Criticality:** low (Impact: Minor, Ease: Complex)

**Description:**
`Hotel.java` implements `java.io.Serializable` (line 7) without declaring `private static final long serialVersionUID`. Java will auto-generate an implicit UID from the class structure at compile time. If the class structure changes (e.g., fields added), previously serialized `Hotel` instances cannot be deserialized — causing silent data corruption or runtime errors. More critically, if `Hotel` objects were ever serialized and later received from an untrusted source, they could serve as a gadget in a Java deserialization chain attack. In the current codebase, no serialization/deserialization of `Hotel` objects actually occurs — the threat is theoretical — but the pattern is unsafe.

**Evidence:**
- File: `src/lecture/chapter7/Hotel.java`, line 5-7 — `import java.io.Serializable; ... public class Hotel implements PriorityBookable, Serializable, Comparable`
- No `ObjectInputStream` or `ObjectOutputStream` usage found anywhere in the project (no actual serialization occurs)

**Attack Precondition:**
Serialized `Hotel` objects must be persisted and later deserialized from an untrusted source. This does not happen in the current codebase.

**Recommendation:**
Add `private static final long serialVersionUID = 1L;` to `Hotel.java`. Consider whether `Serializable` is actually needed — if the intent was only to demonstrate the interface, it should be noted in a comment that production use requires careful handling of deserialization from untrusted sources.

---

#### Finding #5: Commented-Out Dead Code Left in Source Files

**Source:** PSS-Prev-04 (Unused coding), SEC-246
**Component:** All lecture example source files
**Criticality:** low (Impact: Minor, Ease: Easy)

**Description:**
Multiple source files contain large blocks of commented-out code. `Logon.java` contains over 20 lines of commented-out `ItemListener` anonymous class and conditional if/else protocol logic (lines ~50–80 and ~160–165). `RuntimeExceptionExamples.java` contains commented-out try/catch blocks (lines ~17–27, ~34–40). `TravelAgency.java` contains a commented-out `printStackTrace()` call. Per PSS-Prev-04, dead or unused code increases attack surface by: (a) revealing internal implementation details if source is public, (b) creating confusion about intended behavior, and (c) potentially being reactivated accidentally.

**Evidence:**
- File: `src/lecture/chapter10/Logon.java`, lines ~50–82 — commented-out ItemListener anonymous class and if/else protocol logic
- File: `src/lecture/chapter8/RuntimeExceptionExamples.java`, lines ~17–27, ~34–40 — commented-out try/catch blocks
- File: `src/lecture/chapter7/TravelAgency.java`, line 39 — `//notEnoughFreeSlotsException.printStackTrace();`

**Attack Precondition:**
Source code is accessible (public repository). Attacker analyzes commented-out code to understand system internals or exploit any accidentally re-enabled logic.

**Recommendation:**
Remove commented-out code rather than leaving it in source files. Use version control history (`git log`) to recover prior implementations if needed. This is especially important to teach students good hygiene before they enter production environments.

---

#### Finding #6: No Dependency Manifest — Unverifiable Supply Chain

**Source:** PSS-Prev-23 (OSS selection), PSS-Prev-24 (Vulnerable/outdated OSS), OWASP A06 (Vulnerable and Outdated Components)
**Component:** Build toolchain / Supply chain
**Criticality:** low (Impact: Minor, Ease: Complex)

**Description:**
The project has no Maven `pom.xml`, no Gradle `build.gradle`, and no lock file. JUnit 5 and the JDK are consumed implicitly through IntelliJ IDEA's module configuration (`.idea/dhbwmawwi2025sea.iml`). No library versions are pinned. No Software Composition Analysis (SCA) scan is possible because there is no dependency manifest. This means: (a) it is unknown whether the JUnit version in use has known CVEs, (b) a malicious actor with access to the IntelliJ cache or the `sap-25` JDK distribution could introduce vulnerable versions without detection.

**Evidence:**
- File: `dhbwmawwi2025sea.iml` — module config references `inheritedJdk` with name `sap-25`; no explicit version
- Zero files matching `pom.xml`, `build.gradle`, `requirements.txt`, `go.mod` found in the project
- JUnit 5 usage confirmed via `src/test/lecture/excursion/junit/CalculatorTest.java` and `test/lecture/chapter7/HotelTest.java` but no version declaration anywhere

**Attack Precondition:**
Attacker would need to compromise the IntelliJ dependency cache or the `sap-25` JDK distribution to substitute a vulnerable library. Requires significant access.

**Recommendation:**
Migrate to a standard build tool (Maven or Gradle) with explicit dependency versions and a lock file. This enables SCA scanning and reproducible builds. Even for an educational project, demonstrating dependency management is good pedagogical practice.
