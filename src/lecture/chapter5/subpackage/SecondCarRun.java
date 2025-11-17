package lecture.chapter5.subpackage;

import lecture.chapter5.Car;

public class SecondCarRun {

  public static void main(String[] args) {

    Car myCar = new Car("Blau", 500, "MA-ZZ 9876");

    myCar.getColor();

    // Kein Zugriff --> package-Private
    //myCar.accelerate(10);

    // Kein Zugriff --> protected
    // myCar.Attribute = "Nein-Nein";

  }
}
