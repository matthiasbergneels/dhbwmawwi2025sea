package excersises.exam;

public class Käfig {

  private double ccm;
  private Tier bewohner;

  public Käfig(double ccm) {
    this.ccm = ccm;
  }

  public void setBewohner(Tier bewohner) {
    this.bewohner = bewohner;
  }

  // Variante 1 (einfach)
  public String getArtBewohner(){
    if(bewohner instanceof Vogel){
      return "Vogel";
    } else if (bewohner instanceof Hase){
      return "Hase";
    } else {
      return "Tier";
    }
  }

  public String getArtBewohnerV2(){
    return bewohner.getArt();
  }


}
