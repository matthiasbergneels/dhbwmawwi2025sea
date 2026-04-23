package lecture.chapter12;

public class LinkedList {

  private Node firstNode;
  private Node lastNode;

  private int size;

  public void add(int data){
    Node newNode = new Node(data);
    size++;

    if(firstNode == null){
      firstNode = newNode;
      return;
    }

    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){
      currentNode = currentNode.getNextNode();
    }

    currentNode.setNext(newNode);
  }

  public int size(){
    return size;
  }

  public int sizeCounting(){

    if (firstNode == null){
      return 0;
    }

    Node currentNode = firstNode;
    int counter = 1;
    while(currentNode.getNextNode() != null){
      currentNode = currentNode.getNextNode();
      counter++;
    }
    return counter;
  }

  public void add(int data, int index){
    Node newNode = new Node(data);
    size++;

    if(index == 0){
      newNode.setNext(firstNode);
      firstNode = newNode;
      return;
    }

    Node currentNode = firstNode;
    while(index-- > 1){
      currentNode = currentNode.getNextNode();
      if(currentNode == null){
        size--;
        throw new IndexOutOfBoundsException();
      }
    }

    newNode.setNext(currentNode.getNextNode());
    currentNode.setNext(newNode);
  }

  public boolean contains(int data){
    if(firstNode == null){
      return false;
    }

    Node currentNode = firstNode;
    if(currentNode.getData() == data){
      return true;
    }
    while(currentNode.getNextNode() != null){
      if(currentNode.getNextNode().getData() == data){
        return true;
      }
      currentNode = currentNode.getNextNode();
    }

    return false;
  }


  public void printList(){
    if(firstNode == null){
      System.out.println("Liste ist leer!");
      return;
    }

    System.out.println("Listen Inhalt:");
    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){
      System.out.print(currentNode.data + " ");
      currentNode = currentNode.getNextNode();
    }

    System.out.println(currentNode.getData());

  }

  public boolean remove(int data){

    if(firstNode != null && firstNode.getData() == data){
      firstNode = firstNode.getNextNode();
      size--;
      return true;
    }

    Node currentNode = firstNode;
    while(currentNode.getNextNode() != null){

      if(currentNode.getNextNode().getData() == data){
        currentNode.setNext(currentNode.getNextNode().getNextNode());
        size--;
        return true;
      }

      currentNode = currentNode.getNextNode();
    }


    return false;
  }


  private class Node{
    private int data;
    private Node nextNode;

    Node(int data){
      this.data = data;
    }

    void setNext(Node nextNode){
      this.nextNode = nextNode;
    }

    Node getNextNode(){
      return nextNode;
    }

    int getData(){
      return data;
    }
  }

}
