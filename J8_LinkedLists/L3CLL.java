package J8_LinkedLists;
/*
A circular linked list is a variation of a linked list where the last node points back to the first node,
forming a circular structure. Unlike singly or doubly linked lists, there’s no null at the end.
This structure is useful for applications that require cyclic traversals, such as memory management or implementing queues.

Key Properties of Circular Linked List
The next pointer of the last node points back to the head.
In a circular singly linked list, each node has only one pointer (next) that links to the next node in the sequence.
Traversal can start at any node and continue indefinitely because of the circular nature.
No null pointer is used for the end of the list.

*/

class CircularLinkedList {
    Node head; // Head of the list

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to insert a node at the beginning..O(n)
    public void insertFront(int data) {
        Node newNode = new Node(data);

        if (head == null) { // If the list is empty
            head = newNode;
            newNode.next = head; // Circular link
            return;
        }

        Node current = head;
        while (current.next != head) { // Traverse to the last node
            current = current.next;
        }

        newNode.next = head; // Link new node to the current head
        current.next = newNode; // Link last node to the new node
        head = newNode; // Update head to the new node
    }

    // Method to insert a node at the end..O(n)
    //both insertFront and insertRear are similar but in insertFront we make newNode as head
    public void insertRear(int data) {
        Node newNode = new Node(data);

        if (head == null) { // If the list is empty
            head = newNode;
            newNode.next = head; // Circular link
            return;
        }

        Node current = head;
        while (current.next != head) { // Traverse to the last node
            current = current.next;
        }

        current.next = newNode; // Link last node to the new node
        newNode.next = head; // Make it circular
    }

    //insert at given position w.r.t head
    public void insertAtPosition(int data,int position){
        Node newNode=new Node(data);

        if(position<1){
            System.out.println("position starts from 1");
            return;
        }
        if(position==1){
            insertFront(data);
            return;
        }

        Node current=head;
        int currentPos=1;
        while(current.next!=head && currentPos<(position-1)){
            current=current.next;
            currentPos++;
        }
        //out of loop if any one condition fails
        //we're out of loop if first condition fails i.e, current.next==head but still currentPos<position-1 coz position given
        //must be >size of the list
        if(currentPos<position-1){
            System.out.println("position out of bounds..");
            return;
        }
        //or current is pointing to a node which at (position-1)th node from head_clockwise i.e, currenPos==position-1
        newNode.next=current.next;
        current.next=newNode;
    }

    // Method to delete the front node
    public void deleteFront() {
        if (head == null) { // Empty list
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) { // Single node case
            System.out.println("deleting head of the list: "+head.data);
            head = null;
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != head) {
                current = current.next;
            }
            System.out.println("deleting head of the list: "+head.data);
            current.next = head.next; // Update last node to point to the second node
            head = head.next;         // Update head to the second node
        }
    }

    // Method to delete the rear node
    public void deleteRear() {
        if (head == null) { // Empty list
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.next == head) { // Single node case
            System.out.println("deleting last node of list: "+head.next.data);
            head = null;
        } else {
            Node current = head;
            // Traverse to the second last node
            while (current.next.next != head) {
                current = current.next;
            }
            System.out.println("deleting last node of list: "+current.next.data);
            current.next = head; // Update second last node to point to head
        }
    }

    // Method to delete a node at a specific position (1-based index)
    public void deleteAtPosition(int position) {
        if (head == null) { // Empty list
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (position < 1) { // Invalid position
            System.out.println("Invalid position. Position must be >= 1.");
            return;
        }

        if (position == 1) { // Delete at the front
            deleteFront();
            return;
        }

        Node current = head;
        int count = 1;

        // Traverse to the node just before the target position
        while (count < position - 1 && current.next != head) {
            current = current.next;
            count++;
        }

        // If position is out of bounds
        if (current.next == head || count != position - 1) {
            System.out.println("Invalid position. Position is greater than the size of the list.");
            return;
        }

        // Delete the node at the position
        System.out.println("deleting node at position: "+position+" which is :"+current.next.data);
        current.next = current.next.next;
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        int size=0;
        do {
            System.out.print(current.data + "->");
            current = current.next;
            size++;
        } while (current != head);
        System.out.println("(back to head)");
        System.out.println("size of the list: "+size);
    }

    //method to find the position of the given value
    //time complexity: O(n)
    //this method can be used delete the node with given value
    public int findPosition(int data){
        Node current=head;
        int position=1;
        while(current.next!=head){
            if(current.data==data){
                return position;
            }
            current=current.next;
            position++;
        }
        //out of loop means data not found
        System.out.println("not found!");
        return -1;
    }

}

public class L3CLL {
    public static void main(String[] args) {
        CircularLinkedList cll=new CircularLinkedList();
        cll.display();
        cll.deleteFront();
        cll.deleteRear();

        cll.insertAtPosition(25,1);
        cll.deleteFront();
        cll.display();

        cll.insertFront(10);
        cll.deleteRear();
        cll.display();

        cll.insertFront(20);
        cll.insertFront(30);
        cll.insertRear(1);
        cll.insertRear(2);
        cll.insertRear(3);
        cll.insertRear(40);
        cll.display();

        cll.insertAtPosition(15,3);
        cll.display();
        cll.insertAtPosition(11,10);
        cll.display();
        cll.insertAtPosition(14,12);

        cll.deleteRear();
        cll.display();
        cll.deleteFront();
        cll.display();

        cll.deleteAtPosition(3);
        cll.display();
        cll.deleteAtPosition(5);

        System.out.println(cll.findPosition(2));
        cll.findPosition(0);

    }
}
