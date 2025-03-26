package J8_LinkedLists;

/*
leetcode..21..easy
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted(non-decreasing) list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Input: list1 = [], list2 = []
Output: []
Input: list1 = [], list2 = [0]
Output: [0]
*/

class Node1{
    int value;
    Node1 next;

    public Node1(){}//default constructor

    public Node1(int value){//constructor
        this.value=value;
    }
    public Node1(int value, Node1 next){//constructor
        this.value=value;
        this.next=next;
    }

    Node1 head;
    public void insertRear(int data){
        Node1 newNode=new Node1(data);
        if(head==null){//if the list is empty
            head=newNode;
            return;
        }
        Node1 current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }

    // Method to display the list
    public void display() {
        Node1 current = head;
        while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

    public Node1 merge(Node1 first,Node1 second){
        Node1 current1=first;//first is the head of list1
        Node1 current2=second;//second is the head of list2
        Node1 newList=new Node1();//make a new list store the nodes

        while(current1!=null && current2!=null){//loop ends any one condition false
            if(current1.value < current2.value){
                newList.insertRear(current1.value);
                current1=current1.next;
            }
            else{
                newList.insertRear(current2.value);
                current2=current2.next;
            }
        }
        //if we're out of loop then 2 possibilities
        //1.current1==null i.e, list1 is traversed completely till last node then we add all remaining nodes of list2
        //as it is(coz both lists are already sorted)to the newList
        //2.current2==null i.e, list2 is traversed completely till last node..vice versa of previous possibility..
        while(current1!=null){//if there are some nodes left in list1 (possibility 2)
            newList.insertRear(current1.value);
            current1=current1.next;
        }
        while(current2!=null){//if there are some nodes left in list2 (possibility 1)
            newList.insertRear(current2.value);
            current2=current2.next;
        }
        //btw any one of above 2 while loops will be executed

        return newList;
    }

}

public class L6mergeList {

    public static void main(String[] args) {
        Node1 first=new Node1();
        first.insertRear(1);
        first.insertRear(2);
        first.insertRear(4);
        first.display();

        Node1 second=new Node1();
        second.insertRear(1);
        second.insertRear(3);
        second.insertRear(5);
        second.display();


        Node1 m=new Node1();
        Node1 newlist=m.merge(first.head,second.head);
        newlist.display();

    }
}
/*
public LinkedList mergeSorted(LinkedList list1, LinkedList list2) {
        Node head1 = list1.head; // Head of the first list
        Node head2 = list2.head; // Head of the second list

        LinkedList result = new LinkedList();
        Node dummy = result.new Node(-1); // Temporary dummy node to simplify merging logic
        //dummy: A temporary "dummy" node is created to simplify the merging process.
        //This node serves as the starting point of the merged linked list,
        //and its next pointer will eventually point to the head of the merged list.
        Node tail = dummy;

        // Merge the two lists
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        //Initially, dummy and tail both point to the dummy node.
        //In the merging loop:
        //tail.next is updated to point to the smaller of the two current nodes (head1 or head2).
        //Then, tail is advanced to point to the node it just added (tail = tail.next).
        //This process repeats until all nodes from both lists are added to the result list.

        // Append the remaining nodes note that no while loops are used here..if else is used
        if (head1 != null) {
            tail.next = head1;
        } else if (head2 != null) {
            tail.next = head2;
        }
        //After the main loop ends (while (head1 != null && head2 != null)), one of the lists (head1 or head2) still has remaining elements.
        //Instead of processing those remaining nodes one-by-one, the entire remainder of the list is directly appended to tail.next.
        //doesn’t iterate through the remaining nodes but rather appends them all at once.
        //This works because the remaining nodes are already in sorted order and connected.
        //if you're using loops than you have to move head1,head2 and tail otherwise infinite loop will run

        result.head = dummy.next; //Assign the head of the merged list to result.head so that we can return result to method
        //dummy.next points to the actual head of the merged list.
        //dummy itself is ignored (it's only a helper node).
        return result;
    }

    //When dummy is assigned to tail and tail undergo changes in loop does that affect dummy.. ??
    //No, changes to tail do not affect dummy, even though dummy and tail initially point to the same object. Let’s explore why this is the case.
    //when tail is assigned with dummy, dummy and tail are pointing to the same linked list..
    //Key Concept: References and Objects in Java
    //In Java:
    //dummy and tail are references to the same object initially.
    //If you change the object that dummy or tail points to, then all references pointing to that same object will see the changes.
    //Example: If you modify dummy.next, tail.next will also see the change because they both point to the same object.
    //However, if you reassign tail to another object (e.g., tail = tail.next), it does not affect dummy.
    //The reassignment only changes what tail points to.

    //difference between first and first.head??
    //1. first
    //first is a reference to a linked list object (usually an instance of a LinkedList class).
    //It represents the entire linked list, including all its methods and fields.
    //Think of first as a container or blueprint for managing the linked list, which may include:
    //The head node (the starting point of the list).
    //Helper methods like add, delete, display, etc.
    //Example:
    //LinkedList first = new LinkedList();
    //Here:
    //
    //first is the linked list object.
    //You use methods like first.add() or first.display() to manipulate or view the list.
    //2. first.head
    //first.head is a reference to the first node in the linked list.
    //It directly points to the starting node (Node object) in the linked list.
    //You can access node-specific information like data and next through first.head.
    //Example:
    //Node headNode = first.head;
    //Here:
    //
    //first.head retrieves the Node object at the start of the list.
    //If head is null, it means the linked list is empty.
    //Why is This Important?
    //You use first to manage the list as a whole (adding, deleting, or displaying nodes).
    //You use first.head to work directly with the first node or traverse the list node-by-node.

    //at the end tail is not pointing to last node of the merged list??
    //You are correct in pointing out that at the end of the loop,
    //the tail reference is not guaranteed to be pointing to the last node of the merged list unless all merging is done through the loop.
    //modifications..
    //if (head1 != null) {
    //    tail.next = head1;
    //    while (tail.next != null) {
    //        tail = tail.next;
    //    }
    //} else if (head2 != null) {
    //    tail.next = head2;
    //    while (tail.next != null) {
    //        tail = tail.next;
    //    }
    //}

*/

//the solution submitted to leetcode
/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newlist=new ListNode(-1);//newlist is same as dummy in above method
        ListNode tail=newlist;//assigning it to tail to traverse and not traversing newlist itself coz have to
         //return it(newlist.next) i.e head of merged list to the method

        ListNode current1=list1,current2=list2;
        while(current1!=null && current2!=null){
            if(current1.val<current2.val){
                tail.next=current1;
                current1=current1.next;
            }
            else{
                tail.next=current2;
                current2=current2.next;
            }
            tail=tail.next;
        }
        while(current1!=null){
            tail.next=current1;
            current1=current1.next;
            tail=tail.next;
        }
        while(current2!=null){
            tail.next=current2;
            current2=current2.next;
            tail=tail.next;
        }

        //after ending all loops tail will be pointing to last node of merged list
        //and newlist.next will be pointing head of the merged list

        return newlist.next;
    }
}

//Initial State:
//
//Both newlist and tail reference the same object: the newlist node.

//newlist → (-1)
//tail → (-1)
//First Iteration:
//
//tail.next is updated to point to a node (e.g., head1).
//tail is then moved forward (tail = tail.next).
//At this point:
//
//tail points to the newly added node.
//newlist is unaffected because it still references the original dummy node.

//newlist → (-1) → [merged list starts here]
//tail → [last node in merged list]
//Subsequent Iterations:

//tail continues to move forward, appending new nodes to the merged list.
//newlist remains stationary, always pointing to the start of the merged list.
*/
