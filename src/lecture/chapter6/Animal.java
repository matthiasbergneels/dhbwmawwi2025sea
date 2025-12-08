package lecture.chapter6;

public class Animal {

  private float seize;
  private float weight;
  private String description;


  public Animal(float seize, float weight, String description) {
    this.setSeize(seize);
    this.setWeight(weight);
    this.setDescription(description);
  }

  public void breath(){
    IO.println("Das Tier " + this.description + " atmet!");
  }

  public void eat(){
    IO.println("Das Tier " + this.description + " frisst!");
  }

  public void move(){
    IO.println("Das Tier " + this.description + " bewegt sich!");
  }

  public float getSeize() {
    return seize;
  }

  public void setSeize(float seize) {
    this.seize = seize;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
