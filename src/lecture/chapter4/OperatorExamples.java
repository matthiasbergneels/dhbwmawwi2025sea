package lecture.chapter4;

public class OperatorExamples {

  public static void main(String[] args) {

    int valueA = 5;
    int valueB = 13;
    int result;

    // Modulo operator --> Restwert-Operator
    result = valueB % valueA;

    System.out.println("Restwert (Modulo) 13 % 5: " + result);

    // Increment / Decrement

    System.out.println("Vorher: " + valueA);
    valueA++; // valueA = valueA + 1; --> Post-increment
    System.out.println("Nachher: " + valueA);

    System.out.println("Vorher: " + valueA);
    ++valueA; // valueA = valueA + 1; --> pre-increment
    System.out.println("Nachher: " + valueA);


    valueA = 5;
    valueB = 2;
    System.out.println("Vorher: " + valueA + " - "  + valueB);
    result = valueB++ + valueA + valueB;
    System.out.println("Vorher: " + valueA + " - "  + valueB + " - " + result);

    // relational operators
    System.out.println(valueA + " gleich " + valueB + "? " + (valueA == valueB));
    System.out.println(valueA + " ungleich " + valueB + "? " + (valueA != valueB));
    System.out.println(valueA + " größer-gleich " + valueB + "? " + (valueA >= valueB));
    System.out.println(valueA + " kleiner " + valueB + "? " + (valueA < valueB));
    valueB = 5;
    System.out.println(valueA + " gleich " + valueB + "? " + (valueA == valueB));
    System.out.println(valueA + " ungleich " + valueB + "? " + (valueA != valueB));

    // logical operators

    boolean isRaining = false;
    boolean mustLeaveHome = true;

    System.out.println("Brauche ich einen Regenschirm? " + (isRaining && mustLeaveHome));


    // && - with short curcuit evaluation
    String myText = null;

    if(myText != null && myText.length() > 5) {
      System.out.println(myText.length());
    } else {
      System.out.println("Text existiert nicht!");
    }


    // Zuweisungs-Operatoren
    valueA += valueB; // => valueA = valueA + valueB;
    valueA *= valueB; // => valueA = valueA * valueB;


  }
}
