package lecture.chapter12;

public class LinkedList {

  private Node firstNode;

  public void add(int data){
    Node newNode = new Node(data);

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
    // TODO gib die größe der Liste aus
    return 0;
  }

  public void add(int data, int index){
    // TODO füge Datenelement an index ein
  }

  public void printList(){
    // TODO vollständige Liste ausgeben
  }

  public boolean remove(int data){
    // TODO lösche erste gefunden Element dieser Daten
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
