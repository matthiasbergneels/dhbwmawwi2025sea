package lecture.chapter5;

public class CarRun{


  public static void main(String[] args){

    IO.println("Aktuelle Anzahl an Autos: " + Car.getCarCount());

    String newColor = "Orange";
    int standardHp = 250;

    Car myCar = new Car(Car.COLOR_ORANGE, standardHp, "HD-CC 1234", CarBrand.MERCEDES);
    Car yourCar = new Car("Kackbraun", 500, "MA-ZZ 9876",  CarBrand.AUDI);
    // Car hisCar = new Car("Blau", 500, "MA-ZZ 9876",  CarBrand.MITSUBISHI);

    Car racingCar = new Car(999, "HD-RR 9876");

    IO.println("Aktuelle Anzahl an Autos: " + Car.getCarCount());

    // call by Reference
    Car secondKeyToCar = myCar;

    // Zugriff auf Protected Attribute
    myCar.attribute = "JAJA";

    newColor = "Rot";

    System.out.println("Mein Auto hat die Farbe: " + myCar.getColor());
    System.out.println("Dein Auto hat die Farbe: " + yourCar.getColor());

    //myCar.color = "kackbraun";
    //yourCar.color = "Blau";

    //myCar.hp = 250;
    //yourCar.hp = 500;

    System.out.println("Mein Auto hat die Farbe: " + myCar.getColor() + " von der Marke " + myCar.brand + "(Preisklasse " + myCar.brand.getPriceClass()+")");
    System.out.println("Dein Auto hat die Farbe: " + yourCar.getColor() + " von der Marke " + yourCar.brand + "(Preisklasse " + yourCar.brand.getPriceClass()+")");

    System.out.println("Mein Auto hat die Farbe: " + secondKeyToCar.getColor());

    //myCar.hp = 999;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS.");

    //secondKeyToCar.hp = -150;

    //myCar.currentSpeed = -9000;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS.");

    Double currentSpeedOfMyCar = myCar.accelerate(45);
    System.out.println("Mein Auto hat die Geschwindigkeit " + currentSpeedOfMyCar + " km/h");

    System.out.println("Mein Auto hat die Geschwindigkeit " + myCar.brake() + " km/h");
    myCar.brake();
    System.out.println("Mein Auto hat die Geschwindigkeit " + myCar.getCurrentSpeed() + " km/h");


    Car.printCarInformation(myCar);
    Car.printCarInformation(yourCar);


    new Car();
    new Car();
    new Car();

    myCar = null;
    secondKeyToCar = null;

    // Aufräumen

    IO.println("Aktuelle Anzahl an Autos: " + Car.getCarCount());
  }


}
