package J8_LinkedLists;

class RecursiveInsert {
    //structure of a node
    class Node {
        int data;//data part i.e, value of node
        Node next;//pointer pointing to next node

        //constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insertAtPosition(int data,int position){
        if(position<1){
            System.out.println("position starts from 1..");
            return;
        }

        head=recursion(head,data,position);//send head to search for position and receive head to display
    }

    private Node recursion(Node current,int data,int position){
        // Base case: Position becomes or is 1, insert the new node here
        if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = current; // Link new node to the current node
            return newNode;         // Return the new node as the new head of this sublist
        }

        // If the list is empty and position is not 1, position is invalid
        if (current == null) {
            System.out.println("Invalid position. Position is greater than the size of the list.");
            return null;
        }

        // Recursive call to the next node, reducing position by 1 so that it becomes 1 and matches base case
        current.next = recursion(current.next, data, position - 1);
        return current; // Return the current node to maintain the link
    }

    // Method to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class L4RecursiveInsertion {
    public static void main(String[] args) {
        RecursiveInsert ri=new RecursiveInsert();
        ri.display();

        ri.insertAtPosition(38,0);
        ri.insertAtPosition(10,1);
        ri.insertAtPosition(20,2);
        ri.insertAtPosition(30,3);
        ri.insertAtPosition(50,4);
        ri.insertAtPosition(60,8);//position out of bounds
        ri.display();

        ri.insertAtPosition(40,4);
        ri.display();
    }
}
