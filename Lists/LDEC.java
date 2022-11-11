package Lists;

public  class LDEC {
    class Node{
        int data;
        Node next, prev;
        public Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }
    Node first = null;
    Node last = null;

    public void addNode(int data){
        Node x = new Node(data);
        if (first == null){
            first = x; 
            last = x;
        } else {
            last.next = x;
            first.prev = x;
            x.prev = last;
            x.next = first;
            last = x;
        }
    }

    public void delete(int data){
        Node x = first;
        do {
            if(x.data == data){
                x.prev.next = x.next;
                x.next.prev = x.prev;                                
            }
            x = x.next;
        } while (x != first);        
    }

    public void parcial(LDEC lista) {
        Node P = first, Q = lista.first, A, u = first;
        boolean c1, c2;
        if (Q != null) {
            do {
                c1 = true; c2 = false;                
                A = P.prev;
                do {
                    if (P.data != Q.data) {
                        c1 = false;
                        P = A.next.next;
                        Q = lista.first;
                    } else {
                        P = P.next;
                        Q = Q.next;
                    }
                } while (Q != lista.first);
                if (c1) {
                    if (A.next == P) {
                        first = null;
                    } else {
                        A.next = P;
                        P.prev = A;
                        u = P;
                        c2 = true;
                    }
                }
            } while (c2 | P != u & first != null);
            if (first != null) {
                first = P;
            }
        }
    }
        
    public  void display(){
        Node actual = first;
        System.out.println("Nodos de las LDEC: ");
        System.out.print("<> ");
        do{
            System.out.print(actual.data + " <> ");
            actual = actual.next;
        } while (actual != first);
        System.out.println("\n");
    }    

    public static void main(String[] args) throws Exception {
        LDEC thisList = new LDEC();
        thisList.addNode(50);
        thisList.addNode(20);
        thisList.addNode(40);
        thisList.addNode(50);
        thisList.addNode(20);
        thisList.addNode(20);
        thisList.addNode(40);
        thisList.addNode(50);
        thisList.addNode(40);
        thisList.addNode(50);
        thisList.addNode(20);
        thisList.addNode(40);
        thisList.addNode(50);
        thisList.addNode(6);
        thisList.addNode(12);
        thisList.addNode(20);
        thisList.addNode(40);

        LDEC thisList2 = new LDEC();
        thisList2.addNode(20);
        thisList2.addNode(40);
        thisList2.addNode(50);
        thisList.display();
        thisList2.display();

        thisList.parcial(thisList2);
        thisList.display();    
    }
}



