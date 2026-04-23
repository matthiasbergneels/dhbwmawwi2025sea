package lecture.chapter12;

public class LinkedListExample {

  static void main() {

    LinkedList numberList = new LinkedList();

    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    numberList.add(45);
    numberList.add(25);
    numberList.add(83);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.add(45);
    numberList.add(67);

    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    numberList.add(1, 0);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    numberList.add(2, 1);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    numberList.add(3, 2);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    numberList.add(99, 8);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    /*
    numberList.add(1000, 15);
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();
     */

    System.out.println("Enthält 1? " + numberList.contains(1));       // --> Best-Case    O(1)
    System.out.println("Enthält 83? " + numberList.contains(83));     // --> Average-Case O(n/2)  --> O(n) --> Lineare Laufzeit
    System.out.println("Enthält 99? " + numberList.contains(99));     // --> Worst-Case   O(n)
    System.out.println("Enthält 1000? " + numberList.contains(1000)); // --> Worst-Case   O(n)


    System.out.println("Lösche 2? " + numberList.remove(2));
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    System.out.println("Lösche 1? " + numberList.remove(1));
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    System.out.println("Lösche 45? " + numberList.remove(45));
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    System.out.println("Lösche 100? " + numberList.remove(100));
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();

    System.out.println("Lösche 99? " + numberList.remove(99));
    System.out.println("Anzahl Elemente: " + numberList.size());
    numberList.printList();



    System.out.println("Fertig!");

  }
}
