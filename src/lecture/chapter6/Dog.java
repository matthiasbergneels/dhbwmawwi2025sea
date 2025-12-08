package lecture.chapter6;

public class Dog extends Animal{

  private String breed;

  public Dog(float seize, float weight, String description,  String breed) {
    super(seize, weight, description);
    this.setBreed(breed);
  }

  public void bark(){
    IO.println("Der Hund " + this.getDescription() + " bellt! *wauwau*");
  }

  @Override
  public void breath() {
    IO.println("Der Hund " + this.getDescription() + " atmet! *hechel*");
  }

  @Override
  public void eat(){
    super.eat();
    IO.println("Hunde fressen Fleisch");
  }

  // Überladene Fressen-Methode
  public void eat(float amount){
    this.eat();
    IO.println(amount + " kg.");
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }


  @Override
  public String toString() {
    return super.toString() + "; Rasse: " +  breed;

  }

  /*
  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
   */




}
