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

  @Override
  public String toString() {
    return switch(this){
      case   KIA  -> "Kia (" +  priceClass + ")" ;
      case   MERCEDES -> "Mercedes (" +  priceClass + ")";
      case   BMW  -> "BMW";
      case   OPEL  -> "Opel";
      case   FIAT  -> "Fiat";
      case   VOLKSWAGEN -> "Volkswagen";
      case   AUDI  -> "Audi";
    };
  }
}
