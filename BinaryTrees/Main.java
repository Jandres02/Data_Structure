package BinaryTrees;

public class Main {
    public static void main(String[] arguments){
        //int search = 7;
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.left = new Node(8);
        tree.root.right.left.right = new Node(9);
        tree.level_traversal(tree.root);        
        
    }
}
