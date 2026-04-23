package lecture.chapter12;

public class StackExample {

  static void main() {
    Stack<String> workLoad = new Stack();

    workLoad.push("chillen");
    workLoad.push("Programmieren lernen");
    workLoad.push("Programmieren lernen");
    workLoad.push("Programmieren lernen");
    workLoad.push("Programmieren lernen");
    workLoad.push("Mathe lernen");

    System.out.println("Was soll ich als nächstes tun? " + workLoad.peek());

    while(workLoad.peek() != null){
      System.out.println("Jetzt werde ich: " + workLoad.pop());
    }

    System.out.println("Fertig!");

  }
}
