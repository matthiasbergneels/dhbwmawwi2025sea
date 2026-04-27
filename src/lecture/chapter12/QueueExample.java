package lecture.chapter12;

public class QueueExample {

  static void main() {
    Queue<String> workLoad = new Queue<>();

    workLoad.enqueue("chillen");
    workLoad.enqueue("Programmieren lernen");
    workLoad.enqueue("Programmieren lernen");
    workLoad.enqueue("Programmieren lernen");
    workLoad.enqueue("Programmieren lernen");
    workLoad.enqueue("Mathe lernen");

    String nextWork = workLoad.dequeue();
    while(nextWork != null){
      System.out.println("Was mache ich als nächstes? " + nextWork);
      nextWork = workLoad.dequeue();
    }

    System.out.println("Fertig!");
  }

}
