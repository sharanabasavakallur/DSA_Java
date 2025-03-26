package J8_LinkedLists;
/*
leetcode 206
Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L12reverseList {
    //iterative approach
    //make two pointers prev and current and keep one doing current.next=prev and keep moving both prev and current
    //one step forward till prev reaches last node and current moves out of list and return prev which is now head of reversed list
    public ListNode reverse(ListNode head){
        ListNode prev=null;//to mark the end of reversed list
        ListNode current=head;//start from first node

        while(current!=null){//traverse through full list
            ListNode nextNode=current.next;//save the next node
            current.next=prev;//reverse the current node's pointer i.e, reverse direction of current node
            prev=current;//now move prev to one step forward i.e, move prev to current node
            current=nextNode;//also move current to one step forward i.e, move current node to next node
        }
        return prev;//after end of loop prev becomes new head
    }

    //recursive approach
    public ListNode reverseList(ListNode head) {
        // Base case: If the list is empty or has one node, it is already reversed
        if (head == null || head.next == null) {
            return head;
        }
        // Reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        // Adjust pointers to reverse the link
        head.next.next = head; // Make the next node point back to the current node
        head.next = null; // Disconnect the current node from the rest

        return newHead; // Return the new head of the reversed list
    }
    /*
    Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
    Initial Call: reverseList(1)
    head = 1, call reverseList(2).
    Recursive Call 1: reverseList(2)
    head = 2, call reverseList(3).
    Recursive Call 2: reverseList(3)
    head = 3, call reverseList(4).
    Recursive Call 3: reverseList(4)
    head = 4, call reverseList(5).
    Recursive Call 4: reverseList(5)
    head = 5.
    Base Case Reached: Return 5

    Reversing the Links:
    Returning to Call 3:
    head = 4, newHead = 5.
    Reverse: 4.next.next = 4 (make 5 -> 4). i.e, head is 4 so head.next==5 so (head.next).next=5.next=4 => 5->4
    Disconnect: 4.next = null.
    Return newHead = 5.

    Returning to Call 2:
    head = 3, newHead = 5.
    Reverse: 3.next.next = 3 (make 4 -> 3).
    Disconnect: 3.next = null.
    Return newHead = 5.

    Returning to Call 1:
    head = 2, newHead = 5.
    Reverse: 2.next.next = 2 (make 3 -> 2).
    Disconnect: 2.next = null.
    Return newHead = 5.

    Returning to Initial Call:
    head = 1, newHead = 5.
    Reverse: 1.next.next = 1 (make 2 -> 1).
    Disconnect: 1.next = null.
    Return newHead = 5.

    Final Reversed List: 5 -> 4 -> 3 -> 2 -> 1 -> null
    */

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(5);

        L12reverseList ans=new L12reverseList();
        ListNode reversedHead=ans.reverse(head);
        //display
        while(reversedHead!=null){
            System.out.print(reversedHead.val+"->");
            reversedHead=reversedHead.next;
        }
        System.out.println("null");

        ListNode head1=new ListNode(10);
        head1.next=new ListNode(20);
        head1.next.next=new ListNode(30);
        head1.next.next.next=new ListNode(50);
        head1.next.next.next.next=new ListNode(2);
        ListNode reversedHead1=ans.reverseList(head1);
        //display
        while(reversedHead1!=null){
            System.out.print(reversedHead1.val+"->");
            reversedHead1=reversedHead1.next;
        }
        System.out.println("null");
    }
}
