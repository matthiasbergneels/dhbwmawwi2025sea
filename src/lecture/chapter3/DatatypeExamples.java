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
    final double PI_VALUE;
    // Initialize the constant PI
    PI_VALUE = 3.14159;

    System.out.println("The value of PI is: " + PI_VALUE);

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

    // float / double literal examples
    double mySecondDoubleVariable = 1.5;
    mySecondDoubleVariable = .5;
    mySecondDoubleVariable = 1.;
    mySecondDoubleVariable = 1.5d;
    mySecondDoubleVariable = 1.5e2;

    System.out.println("Double Variable: " + mySecondDoubleVariable);

    mySecondDoubleVariable = 1.5e-2;

    System.out.println("Double Variable: " + mySecondDoubleVariable);

    float myThirdFloatVariable = 1.5f;

    // Alpha Numeric literals

    boolean isTired = true; // false

    char myFirstChar = 'a';
    System.out.println("Char variable: " + myFirstChar);
    myFirstChar = '!';
    System.out.println("Char variable: " + myFirstChar);
    myFirstChar = '\u2764';
    System.out.println("Char variable: " + myFirstChar + "!");
    myFirstChar = '\n';
    System.out.println("Char variable: " + myFirstChar + "!");


    String mySecondString = "Hello";
    System.out.println("Sring variable: " + mySecondString);
    mySecondString = "Hello Welt!\nHier geht \tes weiter! \\ Backslash - hier steht etwas ganz \"wichtiges\" \u2764";
    System.out.println("Sring variable: " + mySecondString);

    String html = "<html>\n" +
      "\t<body>\n" +
      "\t\t<p>Hello, world</p>\n" +
      "\t</body>\n" +
      "</html>";

    System.out.println(html);

    String html_block = """
      <html>
        <body>
          <h1>Hello "World" \u2764</h1>
        </body>
      </html>
      """;
    System.out.println(html_block);
  }
}
