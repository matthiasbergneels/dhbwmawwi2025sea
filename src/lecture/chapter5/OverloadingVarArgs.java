package lecture.chapter5;

public class OverloadingVarArgs {


  public static void main(String[] args) {
    int sum = sum(5, 6, 67);
    IO.println("Summe: " + sum(1, 2, 3));
    IO.println("Summe: " + sum(5));
    IO.println("Summe: " + sum(5, 10, 100, 32, 42));


    sum("Bananen", 5, 3, 7, 9);
    sum("Äpfel", 5, 9, 1, 8, 42);
  }

  public static int sum(int... numbers){
    int sum = 0;
    for(int i = 0; i < numbers.length; i++){
      sum += numbers[i];
    }
    /*
    for(int number : numbers){
      sum += number;
    }

     */
    return sum;
  }

  public static void sum(String type, int... numbers){
    int sum = 0;
    for(int i = 0; i < numbers.length; i++){
      sum += numbers[i];
    }
    /*
    for(int number : numbers){
      sum += number;
    }

     */
    IO.println("Summe von " + type  + ": " + sum);
  }


  /*
  public static int sum(int a){
    return a;
  }

  public static int sum(int a, int b){
    return a + b;
  }

  public static int sum(int a, int b, int c){
    return a + b + c;
  }

   */


}
