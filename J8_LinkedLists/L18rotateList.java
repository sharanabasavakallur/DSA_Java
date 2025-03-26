package J8_LinkedLists;
/*
leetcode 61
Given the head of a linked list, rotate the list to the right by k places.
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Input: head = [0,1,2], k = 4
Output: [2,0,1]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L18rotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed
        }

        // Step 1: Find the length of the list
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Make the list circular
        current.next = head;

        // Step 3: Find the new head and tail
        k = k % length; // Optimize k if greater than length to avoid redundant rotations.
        int stepsToNewHead = length - k; // Position of the new head
        ListNode newTail = current;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;

        // Step 4: Break the circular list
        newTail.next = null;

        return newHead;
    }
    /*
    Input: head = [1, 2, 3, 4, 5], k = 2
    List Length: n=5
    Effective Rotation: k=k%n=2
    Make Circular:
    Connect 5 (tail) to 1 (head): 1 -> 2 -> 3 -> 4 -> 5 -> 1.
    New Tail:
    Traverse n−k=5−2=3 steps → New Tail = 3.
    Break Circular:
    New Head = 4.
    Break the connection after 3.
    Output: [4, 5, 1, 2, 3]
    */

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example 1: Input: head = [1,2,3,4,5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        head = rotateRight(head, 2);

        System.out.println("Rotated List:");
        printList(head);

        // Example 2: Input: head = [0,1,2], k = 4
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);

        System.out.println("Original List:");
        printList(head2);

        head2 = rotateRight(head2, 4);

        System.out.println("Rotated List:");
        printList(head2);
    }
}
