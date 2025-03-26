package J8_LinkedLists;
/*
Linked Lists in Java
A linked list is a linear data structure where elements (called nodes) are connected using pointers. Each node contains two parts:

Data: The value stored in the node.
Next: A reference (or pointer) to the next node in the sequence.
Linked lists are dynamic in nature and allow for efficient insertions and deletions.

Types of Linked Lists
Singly Linked List:

Each node points to the next node in the sequence.
The last node points to null.
Doubly Linked List:

Each node points to both its previous and next node.
Allows traversal in both directions.
Circular Linked List:

The last node points back to the first node, forming a circle.
Advantages of Linked Lists
Dynamic Size: Unlike arrays, linked lists can grow or shrink dynamically.
Efficient Insertions/Deletions: Insertions and deletions are faster as they involve only pointer updates (no need to shift elements like in arrays).
Memory Utilization: No need to allocate a fixed size in advance.
Disadvantages of Linked Lists
Sequential Access: Linked lists do not allow direct access to elements (unlike arrays). You must traverse the list.
Memory Overhead: Each node requires extra memory for the pointer(s).
Performance: Traversal and search operations can be slower due to sequential access.

*/

//structure of a node
class Node{
    int data;//data part i.e, value of node
    Node next;//pointer pointing to next node

    //constructor to create a new node
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

//linkedlist class to perform operations
class LinkedList{
    Node head;//head always first elt of the list

    //method to insert new node at front of the list i.e, before head
    //time complexity is O(1) ..no loop involved
    public void insertFront(int data){
        Node newNode=new Node(data);//new node is created with data provided as argument

        newNode.next=head;//current head is pointed by newNode
        head=newNode;//newNode becomes new head of the list
    }

    //method to insert new node at rear end i.e, to the tail of the list
    //time complexity O(n) coz has to traverse till end(loop involved) to add new node
    public void insertRear(int data){
        Node newNode=new Node(data);//new node is created with data passed as argument

        if(head==null){//if the list is empty
            head=newNode;
            return;
        }

        Node current=head;//current is temp. Node which is now pointing to head
        while(current.next!=null){//traverse until last node of the list
            //why not current!=null coz after loop ends the link would break so we cant link the newNode to last node
            current=current.next;//current keeps on moving until it finds last node of the list
        }
        //loop ends i.e, current.next==null so replace that null by the newNode(like the newNode to the tail of existing list)
        current.next=newNode;
    }

    //method to insert the node at given position
    //time complexity:O(n)
    public void insertAtPosition(int data,int position){
        Node newNode=new Node(data);//create a new node of given data

        if(position<1){
            System.out.println("position cant be less then 1, starting position is 1");
            return;
        }
        if(position==1){//lets assume that head is at position:1
            //make it as head of the list i.e, simply call insertFront method
            insertFront(data);
            return;
        }

        Node current=head;
        int currentPosition=1;
        while(current!=null && currentPosition<(position-1)){//traverse until current is pointing to node at position-1
            //current!=null coz to take care if position given exceeds size of the list
            current=current.next;
            currentPosition++;
        }
        //there are two reasons to be here(out of loop)
        //i)current==null
        if(current==null){
            System.out.println("position out of bounds..");
            return;
        }
        //not using else coz return is used in the if condition
        //second reason being outside the loop is currentPosition has reached position-1 i.e, now current node is pointing to
        //the node to which newNode has to be attached
        newNode.next=current.next;//newNode is linked to next element of current node i.e, the node at position+1
        current.next=newNode;//next element of current node is linked to newNode

    }

    //method to delete the first node of the list
    //time complexity O(1)
    public void deleteFront(){
        if(head==null){
            System.out.println("can't delete!, list empty..");
        }
        else{
            System.out.println("deleting...the first element of the list: "+head.data);
            head=head.next;//just point the current head to the next of current head so the link between first & second node is broken
        }//the deleted element is deleted or collected by the garbage collectors
    }

    //method to delete the last node of the list
    //time complexity O(n)
    public void deleteRear(){
        if(head==null){
            System.out.println("cant delete, list empty!");
            return;
        }
        if(head.next==null){//list has only one node..and also in line 147 we print prev.next.data when prev.next is null so it given error
            System.out.println("deleting..last element of the list: "+head.data);
            head=null;
            return;
        }

        Node current=head;
        Node prev=null;//to point to last second element of the list coz current reaches to last element
        while(current.next!=null){
            prev=current;
            current=current.next;
        }
        //prev is pointing to the last second element of the list
        //now the current i.e, prev.next is pointing to the last element of the list to delete it make it(prev.next) null
        //breaking the link between last and last second element
        System.out.println("deleting...the last element of the list: "+prev.next.data);
        prev.next=null;

        //or if you dont want to use prev variable
        /*
         // Traverse to the second-to-last node
        while (current.next.next != null) {
            current = current.next;
        }

        // Update the second-to-last node's next to null, removing the last node
        current.next = null;
        */
    }

    //method to delete at given position
    //time complexity O(n)
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

        Node current=head;
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
            System.out.println("position out of bounds..cant delete!");
            return;
        }

        //ii)the position given is correct and now current is pointing to node which is at (position-1) i.e,
        //currentPosition==(position-1)
        System.out.println("deleting..the element at position "+position+": "+current.next.data);
        current.next=current.next.next;//current.next is replaced by current.next.next skipping one element between (pos-1) & (pos+1)
    }

    //method to display the list
    //time complexity O(n)
    public void display(){
        Node current=head;
        int size=0;
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
            size++;
        }
        System.out.println("null");
        System.out.println("size of the list: "+size);
    }

    //method to find the position of the given value
    //time complexity: O(n)
    //this method can be used delete the node with given value
    public int findPosition(int data){
        Node current=head;
        int position=1;
        while(current!=null){
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

public class L1SLL {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.deleteFront();
        ll.deleteRear();
        ll.deleteAtPosition(3);
        ll.insertRear(8);
        ll.deleteFront();
        ll.insertFront(10);
        ll.deleteRear();
        ll.insertFront(15);
        ll.insertRear(40);
        ll.insertFront(18);
        ll.insertRear(88);
        ll.insertAtPosition(12,3);
        ll.insertAtPosition(122,8);
        ll.insertAtPosition(10,1);
        ll.display();
        ll.deleteFront();
        ll.display();
        ll.deleteRear();
        ll.display();
        ll.deleteAtPosition(8);
        ll.deleteAtPosition(11);
        ll.deleteAtPosition(4);
        ll.display();

        if(ll.findPosition(18)!=-1) System.out.println("found at position: "+ll.findPosition(18));
        if(ll.findPosition(0)!=-1) System.out.println("found at position: "+ll.findPosition(0));

        //deleting 15 from node
        ll.deleteAtPosition(ll.findPosition(15));
        ll.display();
    }
}
