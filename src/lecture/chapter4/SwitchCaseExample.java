void main(){

  // Note
  byte grade = 3;

  // altes Switch-Case-Statement - Grade Beispiel
  switch(grade) {
    case 1:
      IO.println("Sehr gut");
      IO.println("Klausur bestanden.");
      break;
    case 2:
      IO.println("Gut");
      IO.println("Klausur bestanden.");
      break;
    case 3:
      IO.println("Befriedigend");
      IO.println("Klausur bestanden.");
      break;
    case 4:
      IO.println("Ausreichend");
      IO.println("Klausur bestanden.");
      break;
    case 5:
      IO.println("Mangelhaft");
      IO.println("Klausur NICHT bestanden.");
      break;
    default:
      IO.println("Ungültige Note");
  }

  // neues Switch Statement - Grade Beispiel
  IO.println("Neues Switchstatement - Grade");
  switch(grade) {
    case 1 -> {
      IO.println("Sehr gut");
      IO.println("Klausur bestanden.");
    }
    case 2 -> {
      IO.println("Gut");
      IO.println("Klausur bestanden.");
    }
    case 3 -> {
      IO.println("Befriedigend");
      IO.println("Klausur bestanden.");
    }
    case 4 -> {
      IO.println("Ausreichend");
      IO.println("Klausur bestanden.");
    }
    case 5 -> {
      IO.println("Mangelhaft");
      IO.println("Klausur NICHT bestanden.");
    }
    default -> IO.println("Ungültige Note");
  }


  String currentWeekday = "Mittwoch";

  switch(currentWeekday) {
    case "Montag":
      IO.println("Anfang der Woche - wir haben Vorlesung");
      break;
    case "Dienstag":
      IO.println("erst der zweite Tag - nur noch langweilige Vorlesungen");
      break;
    case "Mittwoch":
      IO.println("erst der zweite Tag - nur noch langweilige Vorlesungen");
      break;
  }

  switch(currentWeekday) {
    case "Montag":
      IO.println("Montags ist echt hart!");
    case "Dienstag":
    case "Mittwoch":
    case "Donnerstag":
    case "Freitag":
      IO.println("Werktag");
      break;
    case "Samstag":
    case "Sonntag":
      IO.println("Wochenende!");
  }

  // neues Switch Statement - Weekday Beispiel
  switch(currentWeekday) {
    case "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" ->
      IO.println("Werktag");
    case "Samstag", "Sonntag" ->
      IO.println("Wochenende!");
  }

  // neues Switch Statement - Weekday Beispiel als Rückgabe
  String weekDayEvaluation = switch(currentWeekday) {
    case "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag" -> "Werktag";
    case "Samstag", "Sonntag" -> "Wochenende!";
    default -> "Kein Wochentag";
  };

  System.out.println("Was für ein Wochentag ist " + currentWeekday + "? " + weekDayEvaluation );



  currentWeekday = "TUESDAY";

  int numLetters = switch (currentWeekday) {
    case "MONDAY", "FRIDAY", "SUNDAY" -> {
      yield 6;
    }
    case "TUESDAY" -> 7;
    default -> {
      int result = currentWeekday.length();
      yield result;
    }
  };

  System.out.println("Anzahl Buchstaben: " + numLetters);


  switch (currentWeekday) {
    case "MONDAY": case "FRIDAY": case "SUNDAY":
      numLetters = 6;
      break;
    case "TUESDAY":
      numLetters = 7;
      break;
    default:
      int result = currentWeekday.length();
      numLetters = result;

  }

  System.out.println("Anzahl Buchstaben: " + numLetters);

IO.println("Ende");
}