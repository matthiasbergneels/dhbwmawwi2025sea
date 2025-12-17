package excersises.exam;

public class Hase extends Tier{

  private String fellFarbe;


  public Hase(String fellFarbe) {
    super('w', 10, 20);
    this.fellFarbe = fellFarbe;
  }

  @Override
  public String getArt(){
    return "Hase";
  }

}
