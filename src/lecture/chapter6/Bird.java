package lecture.chapter6;

public class Bird extends Animal {

  private boolean canFly;

  public Bird(float seize, float weight, String description, boolean canFly) {
    super(seize, weight, description);
    this.setCanFly(canFly);
  }

  public void tweet(){
    IO.println("Der Vogel " + this.getDescription() + " zwitschert! *pieppiep*");
  }

  public boolean isCanFly() {
    return canFly;
  }

  public void setCanFly(boolean canFly) {
    this.canFly = canFly;
  }
}
