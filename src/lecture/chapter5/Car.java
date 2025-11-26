package lecture.chapter5;

public class Car {

  // Instanz-Attribute
  private String color;
  private int hp = 0;
  private double currentSpeed;
  private String licensePlate;
  public final CarBrand brand;
  protected String attribute;

  // Klassen-Attribute
  private static int carCount;

  public static final String COLOR_RED = "ROT";
  public static final String COLOR_BLUE = "Blau";
  public static final String COLOR_BLACK = "Schwarz";
  public static final String COLOR_PINK = "Pink";
  public static final String COLOR_ORANGE = "Orange";


  // Konstruktoren
  public Car(String color, int hp, String licensePlate, CarBrand brand) {
    this.setColor(color);
    this.hp = hp;
    this.licensePlate = licensePlate;
    this.brand = brand;

    this.currentSpeed = 0;
    carCount++;
  }

  public Car(){
    this("Schwarz", 150, "XX-YY 1234", CarBrand.KIA);

    this.currentSpeed = 10;
  }

  public Car(int hp, String licensePlate) {
    this("Schwarz",  hp, licensePlate, CarBrand.KIA);

    /*this.hp = hp;
    this.licensePlate = licensePlate;

    this.color = "Schwarz";
    this.currentSpeed = 0;

     */
  }


  // Methoden

  // return value - name - (parameter,...)
  double accelerate(double deltaSpeed){
    if(deltaSpeed > 0 && deltaSpeed < 50.0){
      currentSpeed = currentSpeed + deltaSpeed;
    } else {
      currentSpeed = currentSpeed - 5;
    }
    return currentSpeed;
  }

  double brake(){
    currentSpeed = currentSpeed - 5;
    if(currentSpeed < 0){
      currentSpeed = 0;
    }
    return currentSpeed;
  }

  double fullBrake(){
    currentSpeed = 0;
    return currentSpeed;
  }

  // Methoden Getter- / Setter-Methoden

  public String getColor(){
    return this.color;
  }

  public int getHp(){
    return this.hp;
  }

  public double getCurrentSpeed(){
    return this.currentSpeed;
  }

  public void setColor(String color){
    // Plausibilitätsprüfungen
    if(color.equals(COLOR_BLUE) || color.equals(COLOR_BLACK) || color.equals(COLOR_ORANGE) || color.equals(COLOR_PINK) || color.equals(COLOR_RED)){
      this.color = color;
    } else {
      if(this.color == null) {
        this.color = COLOR_BLACK;
      }
    }

  }

  /* --> Aufräumen mit der Finalize Methode depricated und gelöscht!
  @Override
  protected void finalize() {
    System.out.println("Auto der Marke " + this.brand  + " wird verschrottet!");
    carCount--;
  }
   */

  // Klassen-Methoden
  public static int getCarCount() {
    // IO.println("Car Count: " + color); --> Kein Zugriff aus dem Klassenkontext auf Instanzkontext
    return carCount;
  }

  public static void printCarInformation(Car currentCar){
    IO.println("Marke: " + currentCar.brand);
    IO.println("Farbe: " + currentCar.color);
    IO.println("Leistung: " + currentCar.hp);
    IO.println("Nummernschild: " + currentCar.licensePlate);

  }
}
