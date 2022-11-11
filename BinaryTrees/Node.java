package BinaryTrees;
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data){        
        this.data = data;
        this.right = null;
        this.left = null;
    }

    public int getData(){
        return data;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node left){
        this.left = left;        
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public void printData(){
        System.out.println(this.getData());
    }    
}