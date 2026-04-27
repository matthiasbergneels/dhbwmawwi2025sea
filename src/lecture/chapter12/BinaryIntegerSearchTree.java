package lecture.chapter12;

public class BinaryIntegerSearchTree {

  private Node root;
  private int size;

  private int size(){
    return size;
  }

  public boolean add(int data){
    if(root == null){
      root = new Node(data);
      size++;
      return true;
    }

    return add(data, root);
  }

  private boolean add(int data, Node currentNode){
    if(data < currentNode.getData()){
      if(currentNode.getLeftNode() != null){
        return add(data, currentNode.getLeftNode());
      }
      currentNode.setLeftNode(new Node(data));
      size++;
      return true;
    }else if (data > currentNode.getData()){
      if(currentNode.getRightNode() != null){
        return add(data, currentNode.getRightNode());
      }
      currentNode.setRightNode(new Node(data));
      size++;
      return true;
    }

    return false;
  }

  private class Node{

    private int data;
    private Node leftNode;
    private Node rightNode;

    Node(int data){
      this.data = data;
    }

    int getData(){
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
