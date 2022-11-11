package Lists;
import java.util.Scanner;

class DLL{
    Scanner read = new Scanner(System.in);
    class Node{
            int data;
            Node next;
            Node prev;
            public Node(int d){
                this.data = d;
                this.next = null;
                this.prev = null;
            }
        }
  
      //Represent the head and tail of the singly linked list
      Node head = null;
      Node tail = null;
  
      //addNode() will add a new node to the singly linked list
      public void addNode(int data, boolean sw){
          Node P = new Node(data);
          if (sw == true){
            if(head == null){
                head = P;
                tail = P;
            }else{
                tail.next = P;
                P.prev = tail;
                tail = P;
            }
          }else{
               if(head == null){
                head = P;
                tail = P;
                }else{
                    head.prev = P;
                    P.next = head;
                    head = P;
                }
  
          }
      }
      // display() will display all the nodes in the singly linked list
      public void display(){
          Node current = head;
  
          if(current == null){
              System.out.println("Lista vacía");
              return;
          }
          System.out.println("Nodos de la lista doble enlazada: ");
          System.out.print("null <- ");
          while(current != null){
              if (current.next != null){
                System.out.print(current.data +" <-> ");
              }else{
                System.out.print(current.data +" -> ");
              }
              current = current.next;
          }
          if(current == null)
              System.out.print("null\n");
      }

    public void delete(int x){
        Node t = head;
        boolean encontrado = false;
        while(!encontrado && t != null){
            if(t.data == x){
                encontrado = true;
                if(t == head){
                    head.next.prev = null;
                    head = head.next;
                } else if (t == tail){
                    tail.prev.next = null;
                    tail = t.prev;
                } else {
                    t.prev.next = t.next;
                    t.next.prev = t.prev;
                }            
            }
            t = t.next;
        }
    }

    public void search(int t){
        Node nn;
        System.out.println("1 para head \n2 para tail");
        int op = read.nextInt();

        switch(op){
            case 1:
            nn = head;
            boolean found = false;
            while(nn != null && !found){
                if (nn.data == t){
                    System.out.println("Encontrado: "+nn.data);
                    found = true;                       
                }
            }
        }
    }
      public static void main(String[] args) throws Exception {
          DLL sList = new DLL();
          sList.addNode(1,true);
          sList.addNode(2,false);
          sList.addNode(3,false);
          sList.addNode(4,true);          
          sList.display();
          sList.delete(2);
          sList.display();
      }
  }
