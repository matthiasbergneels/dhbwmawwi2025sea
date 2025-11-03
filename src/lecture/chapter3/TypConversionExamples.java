package lecture.chapter3;

public class TypConversionExamples {

  public static void main(String[] args) {

    short myFirstShort = 50;
    int myFirstInt;

    myFirstInt = myFirstShort;
    System.out.println("Int variable: " + myFirstInt);

    myFirstInt = 25;
    myFirstShort = (short)myFirstInt;
    System.out.println("Short variable: " + myFirstShort);


    double myFirstDouble = 127.7723824981349768134;
    byte myFirstByte = (byte)myFirstDouble;
    System.out.println("Double variable: " + myFirstDouble);
    System.out.println("Byte variable: " + myFirstByte);

    // (!Klausurrelevant)
    myFirstByte = (byte)(Math.round(myFirstDouble));
    System.out.println("Double variable: " + myFirstDouble);
    System.out.println("Byte variable gerundet Konvertiert: " + myFirstByte);
    // (/!Klausurrelevant)

    myFirstInt = 129;
    myFirstByte = (byte)myFirstInt;
    System.out.println("Byte variable: " + myFirstByte);


    char myFirstChar = 'a';

    myFirstInt = myFirstChar;
    System.out.println(myFirstChar + " entspricht " +  myFirstInt);
    myFirstInt = 98;
    myFirstChar = (char)myFirstInt;
    System.out.println(myFirstChar + " entspricht " +  myFirstInt);

    myFirstChar = '\u2764';
    myFirstInt = myFirstChar;
    System.out.println(myFirstChar + " entspricht " +  myFirstInt);


    // (!Klausurrelevant)
    String myIntValue = "1700";
    myFirstInt = Integer.parseInt(myIntValue);
    System.out.println(myFirstInt + " entspricht " +  myIntValue);

    String myDoubleValue = "3.14159e2";
    myFirstDouble = Double.parseDouble(myDoubleValue);
    System.out.println(myFirstDouble + " entspricht " +  myDoubleValue);
    // (/!Klausurrelevant)

  }

}
