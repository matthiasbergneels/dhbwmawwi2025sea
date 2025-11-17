package lecture.chapter5;

public class CarRun{

  public static void main(String[] args) {

    String newColor = "Orange";
    int standardHp = 250;

    Car myCar = new Car(newColor, standardHp, "HD-CC 1234");
    Car yourCar = new Car("Blau", 500, "MA-ZZ 9876");
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

    System.out.println("Mein Auto hat die Farbe: " + myCar.getColor());
    System.out.println("Dein Auto hat die Farbe: " + yourCar.getColor());

    System.out.println("Mein Auto hat die Farbe: " + secondKeyToCar.getColor());

    //myCar.hp = 999;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS.");

    //secondKeyToCar.hp = -150;

    //myCar.currentSpeed = -9000;

    System.out.println("Mein Auto hat " + myCar.getHp() + " PS.");

    Double currentSpeedOfMyCar = myCar.accelerate(10);
    System.out.println("Mein Auto hat die Geschwindigkeit " + currentSpeedOfMyCar + " km/h");

    System.out.println("Mein Auto hat die Geschwindigkeit " + myCar.brake() + " km/h");
    myCar.brake();
    System.out.println("Mein Auto hat die Geschwindigkeit " + myCar.getCurrentSpeed() + " km/h");



  }


}
