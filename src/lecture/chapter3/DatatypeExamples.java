package lecture.chapter3;

public class DatatypeExamples {

  public static void main(String[] args) {

    // Declare an integer variable
    int myInt;

    // initialize the integer variable
    myInt = 42;
    System.out.println("My integer value is: " + myInt);

    // Declare and initialize another integer variable in one line
    int mySecondInt = 100;
    System.out.println("My second integer value is: " + mySecondInt);
    mySecondInt = 55;
    System.out.println("My second integer value is: " + mySecondInt);

    int myThirdInt = 10, myFourthInt = myThirdInt, myFifthInt;

    // Declare a double constant PI
    final double PI;
    // Initialize the constant PI
    PI = 3.14159;

    System.out.println("The value of PI is: " + PI);

    // Declare and initialize a character constant
    final char MY_CONSTANT_CHAR = '!';

    // integer literals
    myInt = 10; // --> value 10
    System.out.println("Decimal 10: " + myInt);
    myInt = 0157;
    System.out.println("Octal 10: " + myInt);
    myInt = 0x10EB;
    System.out.println("Hex 10: " + myInt);
    myInt = 0b10;

    System.out.println("Binär 10: " + myInt);

    final int COLOR_RED = 0xFF0000;
    System.out.println("Color Red: " + COLOR_RED);
    final int COLOR_GREEN = 0x00FF00;
    final int COLOR_BLUE = 0x0000FF;

    System.out.println("Farbe Rot binary: " + Integer.toBinaryString(COLOR_RED));

    long myFirstLongVariable = 2_240_000_000l;
    myFirstLongVariable = 3L;

    byte myFirstShortVariable = 5;
    // myFirstShortVariable = 128; --> value to big for byte

    

  }
}
