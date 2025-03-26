package J8_LinkedLists;
/*
leetcode 25
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L16reverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the kth node
            ListNode groupStart = prevGroupEnd.next;//now groupStart is pointing to first node of group
            ListNode groupEnd = prevGroupEnd;
            for (int i = 0; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }//now groupEnd is pointing to last node of group

            // If there are fewer than k nodes left, break
            if (groupEnd == null) {
                break;
            }

            // Detach the group and reverse it
            ListNode nextGroupStart = groupEnd.next;//now nextGroupStart is pointing to first node of next group
            groupEnd.next = null; // Temporarily end the current group

            // Reverse the group and get the new start and end nodes
            ListNode[] reversed = reverseList(groupStart);
            ListNode newGroupStart = reversed[0];//now newGroupStart is pointing to first node of reversed group
            ListNode newGroupEnd = reversed[1];//now newGroupEnd is pointing to last node of reversed group

            // Connect the reversed group
            prevGroupEnd.next = newGroupStart;//linking prevGroupEnd and newGroupStart
            newGroupEnd.next = nextGroupStart;//linking newGroupEnd and nextGroupStart

            // Move the pointer for the next group
            prevGroupEnd = newGroupEnd;//now prevGroupEnd is pointing to last node of already reversed group so that
            //its next can be used for groupStart for start of next group
        }

        return dummy.next;
    }

    // Helper method to reverse a linked list and return the new head and tail
    private static ListNode[] reverseList(ListNode head) {
        ListNode prev = null, current = head, nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return new ListNode[] {prev, head}; // prev becomes the new head, head becomes the new tail
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode result1 = reverseKGroup(head1, 2);
        printList(result1); // Output: [2, 1, 4, 3, 5]

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        ListNode result2 = reverseKGroup(head2, 3);
        printList(result2); // Output: [3, 2, 1, 4, 5]
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
