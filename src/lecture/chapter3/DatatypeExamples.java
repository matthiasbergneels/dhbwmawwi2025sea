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

  }
}
