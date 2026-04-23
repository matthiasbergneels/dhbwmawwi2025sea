package lecture.chapter12;

public class Stack<E> {

  private Node topNode;
  private int size;

  public void push(E data){
    topNode = new Node(data, topNode);
    size++;
  }

  public E peek(){
    if(topNode != null){
      return topNode.getData();
    }

    return null;
  }

  public E pop(){
    if(topNode != null){
      E data = topNode.getData();
      topNode = topNode.getPrevNode();
      size--;
      return data;
    }

    return null;
  }

  public int size(){
    return size;
  }


  private class Node{
    private E data;
    private Node prevNode;

    Node(E data, Node prevNode){
      this.data = data;
      this.prevNode = prevNode;
    }

    E getData(){
      return data;
    }

    Node getPrevNode(){
      return prevNode;
    }
  }

}
