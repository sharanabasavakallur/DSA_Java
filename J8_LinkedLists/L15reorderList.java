package J8_LinkedLists;
/*
leetcode 143
You are given the head of a singly linked-list. The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
Input: head = [1,2,3,4]
Output: [1,4,2,3]
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L15reorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow.next);
        slow.next = null; // Detach the first half from the second half so that Infinite loops or unintended links between the halves are avoided.
        //if head = [1, 2, 3, 4, 5] then mid=3
        //secondHalf starts from slow.next i.e, mid.next i.e, [4,5] i.e, 4->5->null after reversing 5->4->null
        //firstHalf is still [1,2,3,4,5] so to detach it from secondHalf make mid.next i.e, slow.next i.e, 3.next null i.e, 3->null
        //now firstHalf is 1->2->3->null

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
        //Iteration 1: 1 -> 5 -> 2 -> 3
        //Iteration 2: 1 -> 5 -> 2 -> 4 -> 3
    }

    // Helper method to reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, current = head, nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        reorderList(head1);
        printList(head1); // Output: 1 -> 4 -> 2 -> 3

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        reorderList(head2);
        printList(head2); // Output: 1 -> 5 -> 2 -> 4 -> 3
    }

    // Helper method to print a linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
