package BinaryTrees;
import java.util.Queue;
import java.util.LinkedList;

public class Tree {
    Node root;

    public Tree(){

    }

    public boolean exists(int search){
        return exists(this.root, search);
    }

    
    private boolean exists(Node n, int search){
        if(n == null){
            return false;
        }
        if(n.getData() == search){
            return true;
        } else if(search < n.getData()){
            return exists(n.getLeft(), search);
        } else {
            return exists(n.getRight(), search);
        }
    }

    public void insert(int data){
        if(this.root == null){
            this.root = new Node(data);
        } else {
            this.insert(this.root, data);
        }
    }
    //inserta un nodo en el arbol
    private void insert(Node dad, int data){
        if(data > dad.getData()){
            if(dad.getRight() == null){
                dad.setRight(new Node(data));
            } else {
                this.insert(dad.getRight(), data);
            }
        } else {
            if(dad.getLeft() == null){
                dad.setLeft(new Node(data));
            } else {
                this.insert(dad.getRight(), data);
            }
        }
    }
    //Imprime un arbol en preorden
    private void preorder(Node n){
        if(n != null){
            n.printData();
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }
    //Imprime un arbol en inorden
    private void inorder(Node n){
        if(n != null){
            inorder(n.getLeft());
            n.printData();
            inorder(n.getRight());
        }
    }
    //Imprime un arbol en postorden
    private void postorder(Node n){
        if(n != null){
            postorder(n.getLeft());
            postorder(n.getRight());
            n.printData();
        }
    }

    public void preorder(){
        this.preorder(this.root);
    }

    public void inorder(){
        this.inorder(this.root);
    }

    public void postorder(){
        this.postorder(this.root);
    }
    //Imprime un arbol por niveles
    public void level_traversal(Node root){
        if (root == null){
            return; // El arbol esta vacio
        }
        // Vamos a crear nuestra cola (Paso 1)
        Queue<Node> q = new LinkedList<Node>(); 
        // Agregamos el nodo actual (que para la primera vez es la raiz) (Paso 2)
        q.add(root);
        // Mientras que la cola sea distinto de vacio
        // es decir mientras tengamos objetos de tipo Nodo HAGA
        while(q.size() > 0){
            // Paso 2.1
            Node current = q.poll();
            System.out.print(current.data + " ");
            // Paso 3 Check if current.left is diff from null
            if (current.left != null) q.add(current.left);
            // Paso 4 Check if current.right is diff from null
            if (current.right != null) q.add(current.right);
        }
    }
    //Consigue el padre de un nodo dado
    public Node getDad(Node root, int search){
        if(root == null){
            return null;
        }

        Queue<Node> que = new LinkedList<Node>();
        que.add(root);

        while(que.size() > 0){
            Node aux = que.poll();
            if(aux.left != null && aux.left.data == search){
                return aux;
            } else if (aux.right != null && aux.right.data == search){
                return aux;
            } else {
                if(aux.left != null) que.add(aux.left);            
                if(aux.right != null) que.add(aux.right);                
            }
        }
        return null;
    }
    //Consigue el abuelo de un nodo dado
    public Node getGrandpa(Node root, int search){
        if(root == null) return null;

        Node BeforeGrandpa = getDad(root, search);

        if(BeforeGrandpa != null){
            Node grandpa = getDad(root, BeforeGrandpa.data);
            if(grandpa != null){
                return grandpa;
            } else {
                return null;
            }
        }
        return null;
    }
    //Consigue el tio de un nodo dado
    public void getUncle(Node root, int search){
        if(root == null) return;
        Node granpa = getGrandpa(root, search);
        Node dad = getDad(root, search);       
        if(granpa != null && dad != null){
            if(granpa.left != null && granpa.left == dad){
                System.out.println("Uncle of " + search + " is " + granpa.right.data);
            } else if (granpa.right != null && granpa.right == dad){
                System.out.println("Uncle of " + search + " is " + granpa.left.data);
            }
        } else {
            System.out.println("Node " + search + " has no uncle");
        }
    }
    //Retorna el valor mínimo que hay en el arbol 
    public static int getMin(Node root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int min = root.data;
		int leftMin = getMin(root.left);
		int rightMin = getMin(root.right);
		if (leftMin < min) {
			min = leftMin;
		}
		if (rightMin < min) {
			min = rightMin;
		}

		return min;
	}

    //Retorna el valor máximo que hay en el arbol
    public static int getMax(Node root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int max = root.data;
		int leftMax = getMax(root.left);
		int rightMax = getMax(root.right);
		if (leftMax > max) {
			max = leftMax;
		}
		if (rightMax > max) {
			max = rightMax;
		}
		return max;
	}
    //Retorna la altura del nodo ingresado
    public int get_height(Node node){
        if(node == null){
            return 0;
        } else {
            int left = get_height(node.left);
            int right = get_height(node.right);
            if(left > right){
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }


}


