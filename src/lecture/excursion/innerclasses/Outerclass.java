package lecture.excursion.innerclasses;

public class Outerclass {

  private static final String STATIC_ID = "OuterClass ID 42";

  private final String INSTANZ_ID;

  static interface Printable {
    void printMessage(String message);
  }

  // static nested class
  public static class StaticNestedClass {
    public void printMessage(String message){
      System.out.println("Message from Static nested class: " + message + " - " + STATIC_ID  + " - ClassContext: " + this.getClass().getName());
    }
  }

  // Inner Element Class
  public class InnerElementClass {
    public void printMessage(String message){
      System.out.println("Message from Inner Element class: " + message + " - " + STATIC_ID + " - " + INSTANZ_ID + " - ClassContext: " + this.getClass().getName());
    }
  }

  public Outerclass(String INSTANZ_ID) {
    this.INSTANZ_ID = INSTANZ_ID;
  }

  public void printMessageFromInnerLocalClass(String messageText){
    class InnerLocalClass {
      public void printMessage(String message){
        System.out.println("Message from Inner local class: " + message + " - " + STATIC_ID + " - " + INSTANZ_ID + " - ClassContext: " + this.getClass().getName());
      }
    }
    InnerLocalClass innerLocalClass = new InnerLocalClass();


    innerLocalClass.printMessage(messageText);
  }

  public void printSecondMessageFromInnerLocalClass(String messageText){
    class InnerLocalClass {
      public void printMessage(String message){
        System.out.println("Message from Inner local class: " + message + " - " + STATIC_ID + " - " + INSTANZ_ID + " - ClassContext: " + this.getClass().getName());
      }
    }
    InnerLocalClass innerLocalClass = new InnerLocalClass();
    innerLocalClass.printMessage(messageText);
  }

  public void printMessageFromInnerAnonymousClass(String messageText){
    Printable anonymousObject = new Printable() {
      public void printMessage(String message){
        System.out.println("Message from Anonymous class: " + message + " - " + STATIC_ID + " - " + INSTANZ_ID + " - ClassContext: " + this.getClass().getName());
      }
    };

    anonymousObject.printMessage(messageText);
  }


  public static void main() {
    String messageText = "Unsere Nachricht aus verschiedenen Klassen heraus.";
    StaticNestedClass nestedClass = new StaticNestedClass();
    nestedClass.printMessage(messageText);

    Outerclass firstOuterClass = new Outerclass("INSTANZ ID FIRST CLASS 63");
    InnerElementClass innerElementClassWithFirstOuterClass = firstOuterClass.new InnerElementClass();
    innerElementClassWithFirstOuterClass.printMessage(messageText);

    Outerclass secondOuterClass = new Outerclass("INSTANZ ID FIRST CLASS 67");
    InnerElementClass innerElementClassWithSecondOuterClass = secondOuterClass.new InnerElementClass();
    innerElementClassWithSecondOuterClass.printMessage(messageText);

    firstOuterClass.printMessageFromInnerLocalClass(messageText);
    firstOuterClass.printMessageFromInnerLocalClass(messageText);
    firstOuterClass.printSecondMessageFromInnerLocalClass(messageText);

    secondOuterClass.printMessageFromInnerAnonymousClass(messageText);
  }
}
