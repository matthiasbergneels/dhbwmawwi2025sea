package excersises.exam;

public class Vogel extends Tier {
  private String federFarbe;

  public Vogel(char geschlecht, int gewicht, int groesse, String federFarbe) {
    super(geschlecht, gewicht, groesse);
    this.federFarbe = federFarbe;
  }

  @Override
  public String getArt(){
    return "Vogel";
  }
}