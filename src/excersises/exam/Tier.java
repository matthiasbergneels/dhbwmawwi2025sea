package excersises.exam;

class Tier {
  protected char geschlecht;
  protected int gewicht;
  protected int groesse;

  public Tier(char geschlecht, int gewicht, int groesse) {
    this.geschlecht=geschlecht;
    this.gewicht=gewicht;
    this.groesse=groesse;
  }

  public String getArt(){
    return "Tier";
  }
}