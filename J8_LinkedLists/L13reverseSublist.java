package J8_LinkedLists;
/*
leetcode 92
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Input: head = [5], left = 1, right = 1
Output: [5]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L13reverseSublist {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head; // No need to reverse if the list is empty or left == right
        }
        // Step 1: Initialize dummy node(to return at last) and pointers
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // Step 2: Move `prev` to the node just before `left`
        for (int i = 1; i < left; i++) {//notice i=1 not 0 coz head's position is 1 or you can do i=0;i<left-1
            prev = prev.next;
        }
        // Step 3: Start reversing the sublist
        ListNode current = prev.next; // The `left`-th node
        ListNode nextNode;
        // Reverse nodes from `left` to `right`
        for (int i = 0; i < right - left; i++) {
            nextNode = current.next;
            current.next = nextNode.next; // Detach `nextNode`
            nextNode.next = prev.next; // Insert `nextNode` at the front of the reversed section
            prev.next = nextNode; // Update the new head of the reversed section
        }
        // Step 4: Return the new head of the list
        return dummy.next;
    }

    /*
    Initial State:
    dummy->1 -> 2 -> 3 -> 4 -> 5
    Before Reversing:
    prev=dummy.next; i.e, prev points to 1.

    start of the loop
    current=prev.next; i.e,current points to 2.

    Reversal Iteration 1:
    nextNode=current.next; nextNode points to 3
    current.next=nextNode.next; 2.next=3.next=4 i.e, 2->4
    nextNode.next=prev.next; 3.next=1.next=2 i.e, 3->2 ..Detach 3 and insert it before 2:
    prev.next=nextNode; 1.next=3 i.e, 1->3
    1 -> 3 -> 2 -> 4 -> 5

    Reversal Iteration 2:
    nextNode=current.next; nextNode points to 4 coz current is 2 and 2.next is 4
    current.next=nextNode.next; 2.next=4.next=5 i.e, 2->5
    nextNode.next=prev.next; 4.next=1.next=3 i.e, 4->3  ..Detach 4 and insert it before 3:
    prev.next=nextNode; 1.next=4 i.e, 1->4
    1 -> 4 -> 3 -> 2 -> 5

    Iteration 3: End of Loop
    after right−left=2 iterations, the sublist [2, 3, 4] has been fully reversed.
    */

    public static void main(String[] args) {
        // Example 1: head = [1,2,3,4,5], left = 2, right = 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = reverseBetween(head, 2, 4);

        // Print the result
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println("null");
    }
}
