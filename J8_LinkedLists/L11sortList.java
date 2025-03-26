package J8_LinkedLists;
/*
leetcode 148
Given the head of a linked list, return the list after sorting it in ascending order.
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L11sortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: List with 0 or 1 node is already sorted
        }
        // Step 1: Split the list into two halves
        ListNode middle = getMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;//Without this step, the left half of the list will still be connected to the right half.
        //By setting middle.next = null, the left half becomes an independent linked list, ensuring that recursion works correctly.

        // Step 2: Recursively sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(secondHalf);

        // Step 3: Merge the sorted halves
        return merge(left, right);
    }
    /*
    Example Walkthrough Consider the list: 4 -> 2 -> 1 -> 3.
    Step 1: Find Middle:
    Use slow and fast pointers. The middle node is 2.
    Before Splitting:
    Original list:
    4 -> 2 -> 1 -> 3
    Slow: 2, Fast: null
    After middle.next = null:
    Left half: 4 -> 2
    Right half: 1 -> 3
    Now, middle.next = null disconnects the two halves.
    Without middle.next = null, the left recursion would continue into the right half, causing incorrect behavior.
    */

    // Helper function to find the middle of the linked list
    // copy pasted from L10middleList.java
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow pointer will point to the middle node
    }

    // Helper function to merge two sorted linked lists
    // copy pasted from L6mergeList.java
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append remaining nodes from l1 or l2
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next; // The merged sorted list
    }

    public ListNode bubbleSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No sorting needed for empty or single-node lists
        }

        boolean swapped;
        ListNode current;

        do {
            swapped = false;
            current = head;//for outer loop
            //It resets the current pointer to the head of the list so that the sorting process can repeat from the beginning.

            while (current.next != null) {
                if (current.val > current.next.val) {
                    // Swap values
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;

                    swapped = true; // Mark that a swap occurred
                }
                current = current.next;//This statement is used inside the inner loop to traverse the linked list node by node.
                // It moves the current pointer from one node to the next.
            }
        } while (swapped); // Repeat until no swaps are needed if swapped==false means list already sorted so end loop

        return head;
    }

    public static void main(String[] args) {
        // Example: [4,2,1,3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        L11sortList solution = new L11sortList();
        ListNode sortedHead = solution.sortList(head);

        // Print the sorted list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + "->");
            sortedHead = sortedHead.next;
        }
        System.out.println("null");

        // Example: [11,-3,8,7,2]
        ListNode head2 = new ListNode(11);
        head2.next = new ListNode(-3);
        head2.next.next = new ListNode(8);
        head2.next.next.next = new ListNode(7);
        head2.next.next.next.next=new ListNode(2);

        L11sortList sol=new L11sortList();
        ListNode bubblesort=sol.bubbleSortList(head2);
        //display
        while(bubblesort!=null){
            System.out.print(bubblesort.val+"->");
            bubblesort=bubblesort.next;
        }
        System.out.println("null");
    }
}
