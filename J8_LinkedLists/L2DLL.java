package J8_LinkedLists;
/*
A doubly linked list (DLL) is a type of linked list in which each node contains references (or pointers) to both the next
and previous nodes. This bidirectional structure allows traversal of the list in both forward and backward directions,
unlike a singly linked list, which can only be traversed in one direction.

Structure of a Node in a Doubly Linked List
Each node in a doubly linked list typically contains:
Data: The actual value stored in the node.
Next: A reference to the next node in the list.
Prev: A reference to the previous node in the list.
*/

class dNode {
    int data;      // Data stored in the node
    dNode next;     // Reference to the next node
    dNode prev;     // Reference to the previous node

    dNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class doublyLinkedList {
    dNode head;

    // Insert at the beginning of the doubly linked list
    public void insertAtFront(int data) {
        dNode newNode = new dNode(data);
        if (head != null) {//if the list not empty
            head.prev = newNode;    // Link the current head's prev to the new node
        }
        newNode.next = head;       // Link the new node's next to the current head
        head = newNode;            // Update the head to the new node
    }

    //insert at the end of the doubly linked list
    public void insertAtRear(int data){
        dNode newNode=new dNode(data);

        if(head==null){//if the list is empty
            head=newNode;//make the newNode as head(first node of the list)
            return;
        }

        dNode current=head;
        while(current.next!=null){//traverse until last node of the list i.e, come out of loop when current is pointing to last node
            current=current.next;
        }
        current.next=newNode;//link last node(now current is pointing to last node) to newNode
        newNode.prev=current;//link newNode's prev to the last node(which is pointed by current)
    }

    //insert at given position
    public void insertAtPosition(int data,int position){
        dNode newNode=new dNode(data);

        if(position<1){
            System.out.println("position starts from 1..");
            return;
        }
        if(position==1){
            insertAtFront(data);
            return;
        }

        dNode current=head;
        int currentPos=1;
        while(current!=null && currentPos<(position-1)){//break loop when current is pointing to (position-1)th node
            current=current.next;
            currentPos++;
        }
        if(current==null){
            System.out.println("position out of bound..");
            return;
        }

        newNode.next=current.next;//link current's next node to newNode's next this breaks link between current and current's next
        current.next=newNode;//link newNode to current's next now current's next is updated
        newNode.prev=current;//link current node to newNode's prev
        if(newNode.next!=null)//if the position==size+1 then newNode.next will be null as newNode will be last node of the list
            //thats why we cant access newNode.next.prev as newNode.next is null so check if it's last element..
            newNode.next.prev=newNode;//now link the node at position+1 i.e, newNode.next to the newNode
    }

    //delete front most node i.e, head of the list
    public void deleteFront(){
        if(head==null){//if no elements in the list
            System.out.println("cant delete..list empty!");
            return;
        }
        if(head.next==null){//if only one element in the list(no need of this condition it's required in deleteRear)
            System.out.println("deleting head of the list: "+head.data);
            head=null;
            return;
        }
        System.out.println("deleting head of the list: "+head.data);
        head=head.next;//make the current head's next as new head..now head is second node of the list
        //below if condition is crucial when list has only one node as we handled above for one node so this condition
        //is optional if that condition at line:94 exists
        if(head!=null)//If the list originally had only one node, after setting head = head.next, the head becomes null.
            //Attempting to set head.prev = null would result in a NullPointerException.
            head.prev=null;//remove the link between new head and prev head
    }

    //delete last node of the list
    public void deleteRear(){
        if(head==null){
            System.out.println("cant delete..list empty!!");
            return;
        }
        if(head.next==null){//list has only one element
            System.out.println("deleting last node of the list: "+head.data);
            head=null;
            return;
        }
        dNode current=head;
        while(current.next!=null){
            current=current.next;
        }//now current is pointing to last node of the list
        System.out.println("deleting last node of the list: "+current.data);
        current.prev.next=null;//if current is last node current.prev is last second node so we want to
        // remove link between last second node(current.prev) and last node(current.prev.next which is current itself)
        //by making current null as we cant write current=null directly coz of course it makes current null but link persists
    }

    //delete at given position
    public void deleteAtPosition(int position){
        if(head==null){
            System.out.println("cant delete, list empty!");
            return;
        }
        if(position<1){
            System.out.println("position starts from 1");
            return;
        }
        if(position==1){
            //deleting head of the list i.e first element of the list
            deleteFront();
            return;
        }

        dNode current=head;
        int currentPosition=1;
        while(current!=null && currentPosition<(position-1)){//traverse until current is pointing to node at position-1
            //current!=null coz to take care if position given exceeds size of the list
            current=current.next;
            currentPosition++;
        }
        //we're out of loop for 2 possible reasons
        //i)position exceeds the size of the list
        if(current==null || current.next==null){//why current.next==null
            //coz wkt current is pointing to (position-1) node, and if position==size+1 then there's no elt at size+1 so no elt to delete
            //when position is passed as size+1... current is pointing at position==size which last elt of the list
            System.out.println("position out of bounds..cant delete!!");
            return;
        }
        //coz we want to delete node at position but current is at (position-1) so deleting current.next
        System.out.println("deleting..the element at position "+position+": "+current.next.data);
        current.next=current.next.next;
        if(current.next!=null)//if now after updating current.next in above line if current.next becomes null then
            //current is last node no need of linking it's(null's) prev i.e, dont bother about current.next.prev
            current.next.prev=current;
    }

    //if deletion by given value is there
    //public void deleteAtPosition(findPosition(int data)){}

    //display from left to right (display forward)
    public void display1(){
        dNode current=head;
        int count=0;
        System.out.print("null<-");
        while(current!=null){//come out of loop when no elements are left in the list
            System.out.print(current.data+"->");
            current=current.next;
            count++;
        }
        System.out.println("null");
        System.out.println("size :"+count);
    }

    //display from right to left (display backward)
    public void display2(){
        dNode current=head;
        int count=0;
        System.out.print("null<-");
        while(current.next!=null){//come out of loop when current is pointing last node of the list
            current=current.next;
        }
        //now current is pointing last node of the list
        while(current!=null){//now from last node keep moving towards first node when no nodes are left then break the loop
            System.out.print(current.data+"->");
            current=current.prev;
            count++;
        }
        System.out.println("null");
        System.out.println("size :"+count);
    }

    //to find the position of given node
    //this method can be used delete the node with given value
    public int findPosition(int data){
        dNode current=head;
        int position=1;
        while(current!=null){
            if(current.data==data){
                return position;
            }
            current=current.next;
            position++;
        }
        //out of loop means data not found
        System.out.println("Not found!!");
        return -1;
    }
}

public class L2DLL {
    public static void main(String[] args) {
        doublyLinkedList ll2 =new doublyLinkedList();
        ll2.display1();

        ll2.deleteFront();
        ll2.deleteRear();

        ll2.insertAtRear(2);
        ll2.deleteRear();
        ll2.insertAtRear(3);
        ll2.deleteFront();

        ll2.insertAtRear(2);
        ll2.deleteAtPosition(1);

        ll2.insertAtRear(3);
        ll2.insertAtRear(4);
        ll2.insertAtFront(10);
        ll2.insertAtFront(20);
        ll2.insertAtFront(30);
        ll2.display1();
        ll2.display2();
        ll2.insertAtPosition(33,0);
        ll2.insertAtPosition(5,3);
        ll2.display1();
        ll2.insertAtPosition(23,7);
        ll2.display1();
        ll2.insertAtPosition(17,9);
        ll2.display1();
        ll2.insertAtPosition(0,11);

        ll2.display1();
        ll2.deleteFront();
        ll2.display1();
        ll2.deleteRear();
        ll2.display1();
        ll2.deleteAtPosition(3);
        ll2.display1();

        ll2.insertAtRear(8);
        ll2.insertAtRear(12);
        ll2.insertAtFront(18);
        ll2.display2();
        ll2.display1();

        ll2.deleteAtPosition(8);
        ll2.deleteAtPosition(7);
        ll2.display1();

        if(ll2.findPosition(18)!=-1) System.out.println("found at position: "+ll2.findPosition(18));
        if(ll2.findPosition(0)!=-1) System.out.println("found at position: "+ll2.findPosition(0));

        //delete 4 from the list
        ll2.deleteAtPosition(ll2.findPosition(4));
        ll2.display1();

    }
}
