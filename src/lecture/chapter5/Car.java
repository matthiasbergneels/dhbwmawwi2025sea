package lecture.chapter5;

public class Car {

  // Attribute
  private String color;
  private int hp = 0;
  private double currentSpeed;
  private String licensePlate;
  protected String attribute;

  // Konstruktoren
  public Car(String color, int hp, String licensePlate) {
    this.color = color;
    this.hp = hp;
    this.licensePlate = licensePlate;

    this.currentSpeed = 0;
  }

  public Car(){
    this("Schwarz", 150, "XX-YY 1234");

    this.currentSpeed = 10;
  }

  public Car(int hp, String licensePlate) {
    this("Schwarz",  hp, licensePlate);

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
    if(color.equals("Blau") || color.equals("Lila") || color.equals("Orange")){
      this.color = color;
    } else {
      if(this.color == null) {
        this.color = "Schwarz";
      }
    }

  }

}
