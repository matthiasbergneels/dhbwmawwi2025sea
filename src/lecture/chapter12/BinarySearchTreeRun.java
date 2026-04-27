package lecture.chapter12;

public class BinarySearchTreeRun {

  static void main() {

    BinarySearchTree<Integer> numbers = new BinarySearchTree<>();

    numbers.add(5);
    numbers.add(3);
    numbers.add(2);
    numbers.add(4);
    numbers.add(7);
    numbers.add(6);

    System.out.println("In-Order:   ");
    numbers.printInOrder();

    System.out.println("Pre-Order:  ");
    numbers.printPreOrder();

    System.out.println("Post-Order: ");
    numbers.printPostOrder();

    System.out.println("Fertig!");


    BinarySearchTree<String> fruits = new BinarySearchTree<>();

    // Balancierter Baum: Mango als Wurzel, je 3 Elemente links/rechts
    fruits.add("Mango");
    fruits.add("Erdbeere");
    fruits.add("Orange");
    fruits.add("Banane");
    fruits.add("Kirsche");
    fruits.add("Melone");
    fruits.add("Pflaume");

    System.out.println("In-Order:   ");
    fruits.printInOrder();

    System.out.println("Pre-Order:  ");
    fruits.printPreOrder();

    System.out.println("Post-Order: ");
    fruits.printPostOrder();
  }
}
