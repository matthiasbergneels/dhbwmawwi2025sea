package lecture.chapter9;

import lecture.chapter5.Car;
import lecture.chapter5.CarBrand;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

  public static void main(String[] args) {

    List<String> fruits = new ArrayList<String>(10);

    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Chicken");
    //fruits.add(new Car(Car.COLOR_ORANGE, 155, "HD-CC 1234", CarBrand.MERCEDES));

    String fruit = fruits.get(0);

    IO.println("Erste Iteration mit for:");
    for(int i = 0; i < fruits.size(); i++) {
      IO.println(fruits.get(i));
    }

    fruits.add("Orange");
    fruits.add(0, "Watermelon");
    fruits.add("Grapefruit");
    fruits.set(0, "Raspberry");
    fruits.add("Raspberry");
    fruits.add("Orange");

    IO.println("Zweite Iteration mit for-each:");

    for(String currentFruit : fruits) {

      /*
      if(currentFruit.equals("Orange")) {
        int currentIndex = fruits.indexOf(currentFruit);
        //fruits.remove(currentFruit);
        fruits.add(currentIndex, "Blau");
      }

       */


      /*
      if(currentFruit.equals("Orange")){
        fruits.set(fruits.indexOf(currentFruit), "Blau");
        currentFruit = "Blau";
      }

       */
      IO.println(currentFruit);
    }

    // Inkonsistentes Auslesen mit Zählerschleife beim Löschen von Elementen
    IO.println("Iteration mit for-Zählerschleife (mit remove - INKONSISTENT):");
    List<String> fruitsForLoop = new ArrayList<>(fruits);
    fruitsForLoop.add("Orange");
    fruitsForLoop.add("Orange");
    IO.println("Liste vor der Schleife: " + fruitsForLoop);
    for (int i = 0; i < fruitsForLoop.size(); i++) {
      String currentFruit = fruitsForLoop.get(i);
      IO.println("Index " + i + ": " + currentFruit);
      if (currentFruit.equals("Orange")) {
        fruitsForLoop.remove(i); // Index verschiebt sich! Nächstes Element wird übersprungen
      }
    }
    IO.println("Liste nach der Schleife: " + fruitsForLoop);
    IO.println("-> 'Orange'-Einträge wurden nicht vollständig entfernt (Index-Verschiebung!)");

    String removedFruit = fruits.remove(0);
    IO.println("Gelöscht: " + removedFruit);
    boolean hasRemoved = fruits.remove("Orange");
    IO.println("Orange removed? " + hasRemoved);

    IO.println("Zweite Iteration mit Iterator:");
    Iterator<String> iterator = fruits.iterator();
    while(iterator.hasNext()) {
      String currentFruit = iterator.next();
      if(currentFruit.equals("Orange")) {
        iterator.remove();
      }
      IO.println(currentFruit);
    }

  }
}
