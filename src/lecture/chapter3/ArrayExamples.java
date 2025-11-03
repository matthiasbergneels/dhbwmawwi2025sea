package lecture.chapter3;

public class ArrayExamples {

  public static void main(String[] args) {

    int a, b, c, d, e, f, g;

    // Arrays = field variables
    int[] numbersList= new int[5];

    numbersList[0] = 1;
    numbersList[1] = 56;
    numbersList[2] = 78;
    numbersList[3] = 123;
    numbersList[4] = 456;

    System.out.println("Wert an Index 2: " + numbersList[2]);

    char[] halloArray = {'H', 97, 'l', 'l', 'o'};
    System.out.println(halloArray[0]);
    System.out.println(halloArray[1]);
    System.out.println(halloArray[2]);
    System.out.println(halloArray[3]);
    System.out.println(halloArray[4]);



  }
}
