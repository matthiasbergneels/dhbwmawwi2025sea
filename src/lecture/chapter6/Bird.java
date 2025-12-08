package lecture.chapter6;

public final class Bird extends Animal {

  private boolean canFly;

  public Bird(float seize, float weight, String description, boolean canFly) {
    super(seize, weight, description);
    this.setCanFly(canFly);
  }

  public void tweet(){
    IO.println("Der Vogel " + this.getDescription() + " zwitschert! *pieppiep*");
  }

  @Override
  public void breath() {
    IO.println("Der Vogel " + this.getDescription() + " atmet! *quietsch*");
  }

  public boolean isCanFly() {
    return canFly;
  }

  public void setCanFly(boolean canFly) {
    this.canFly = canFly;
  }
}
