package lecture.chapter6;

public abstract class Animal {

  private float seize;
  private float weight;
  private String description;


  public Animal(float seize, float weight, String description) {
    this.setSeize(seize);
    this.setWeight(weight);
    this.setDescription(description);
  }

  public abstract void breath();

  public void eat(){
    IO.println("Das Tier " + this.description + " frisst!");
  }

  public final void move(){
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

  @Override
  public String toString() {
    return "[" + super.toString() + "] " +  description + " - Größe: " +  seize + "; Gewicht: " + weight;
  }

}
