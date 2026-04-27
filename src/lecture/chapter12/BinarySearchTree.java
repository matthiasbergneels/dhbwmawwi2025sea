package lecture.chapter12;

public class BinarySearchTree <E extends Comparable<E>> {

  private Node root;
  private int size;

  private int size(){
    return size;
  }

  public boolean add(E data){
    if(root == null){
      root = new Node(data);
      size++;
      return true;
    }

    return add(data, root);
  }

  private boolean add(E data, Node currentNode){
    if(data.compareTo(currentNode.getData()) < 0){
      if(currentNode.getLeftNode() != null){
        return add(data, currentNode.getLeftNode());
      }
      currentNode.setLeftNode(new Node(data));
      size++;
      return true;
    }else if (data.compareTo(currentNode.getData()) > 0){
      if(currentNode.getRightNode() != null){
        return add(data, currentNode.getRightNode());
      }
      currentNode.setRightNode(new Node(data));
      size++;
      return true;
    }

    return false;
  }

  // Print In-Order
  public void printInOrder(){
    if(root == null){
      System.out.println("Baum ist leer!");
    }else{
      printInOrder(root);
      System.out.println();
    }
  }

  public void printInOrder(Node currentNode){
    if(currentNode.getLeftNode() != null){
      printInOrder(currentNode.getLeftNode());
    }

    System.out.print(currentNode.getData() + " ");

    if(currentNode.getRightNode() != null){
      printInOrder(currentNode.getRightNode());
    }
  }

  // Print Pre-Order
  public void printPreOrder(){
    if(root == null){
      System.out.println("Baum ist leer!");
    }else{
      printPreOrder(root);
      System.out.println();
    }
  }

  public void printPreOrder(Node currentNode){
    System.out.print(currentNode.getData() + " ");

    if(currentNode.getLeftNode() != null){
      printPreOrder(currentNode.getLeftNode());
    }

    if(currentNode.getRightNode() != null){
      printPreOrder(currentNode.getRightNode());
    }
  }

  // Print Post-Order
  public void printPostOrder(){
    if(root == null){
      System.out.println("Baum ist leer!");
    }else{
      printPostOrder(root);
      System.out.println();
    }
  }

  public void printPostOrder(Node currentNode){
    if(currentNode.getLeftNode() != null){
      printPostOrder(currentNode.getLeftNode());
    }

    if(currentNode.getRightNode() != null){
      printPostOrder(currentNode.getRightNode());
    }

    System.out.print(currentNode.getData() + " ");
  }

  private class Node{

    private E data;
    private Node leftNode;
    private Node rightNode;

    Node(E data){
      this.data = data;
    }

    E getData(){
      return data;
    }

    void setLeftNode(Node leftNode){
      this.leftNode = leftNode;
    }

    Node getLeftNode(){
      return leftNode;
    }

    void setRightNode(Node rightNode){
      this.rightNode = rightNode;
    }

    Node getRightNode(){
      return rightNode;
    }

  }

}
