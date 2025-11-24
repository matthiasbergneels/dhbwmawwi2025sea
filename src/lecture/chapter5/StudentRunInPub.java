package lecture.chapter5;

public class StudentRunInPub {

  public static void main(String[] args) {

    Student karl = new Student(1, "Karl", "Karlson");

    // stay hydrated
    karl.drink(1.5f);
    karl.drink(1.5f, 115);
    karl.drink(1.5f, 10.0);
    karl.drink(0.2f, 45.5, 60);

  }
}
