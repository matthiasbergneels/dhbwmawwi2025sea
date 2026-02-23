package lecture.chapter8;

import lecture.chapter5.Car;
import lecture.chapter5.CarBrand;

public class RuntimeExceptionExamples {

  public static void main(String[] args) {


    Car[] cars = {
      new Car(Car.COLOR_ORANGE, 150, "HD-CC 1234", CarBrand.MERCEDES),
      new Car(Car.COLOR_ORANGE, 150, "HD-CC 1234", CarBrand.MERCEDES),
      new Car(Car.COLOR_ORANGE, 150, "HD-CC 1234", CarBrand.MERCEDES)
    };

    /*
    try {
      for (int i = 0; i <= cars.length; i++) {
        IO.println(cars[i]);
      }
    }catch(IndexOutOfBoundsException e) {
      IO.println(e.getMessage());
      IO.println("Zu viele Elemente aus dem Array versucht auszulesen");
    }

     */

    for (int i = 0; i < cars.length; i++) {
      IO.println(cars[i]);
    }

    String emptyText = null;

    /* --> möglich aber nicht schlau
    try {
      IO.println("Azahl Zeichen: " + emptyText.length());
    }catch(NullPointerException e) {
      IO.println(e.getMessage());
      IO.println("String ist null");
    }

     */

    if(emptyText != null) {
      IO.println("Azahl Zeichen: " + emptyText.length());
    } else {
      IO.println("String ist null");
    }

    IO.println("Programm Ende!");
  }
}
