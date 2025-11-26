package lecture.chapter5;

public enum CarBrand {
  KIA("$"),
  MERCEDES("$$$"),
  BMW("$$$"),
  OPEL("$$"),
  FIAT("$"),
  VOLKSWAGEN("$$"),
  AUDI("$$$");

  private String priceClass;

  CarBrand(String priceClass){
    this.priceClass = priceClass;
  }

  public String getPriceClass() {
    return priceClass;
  }
}
