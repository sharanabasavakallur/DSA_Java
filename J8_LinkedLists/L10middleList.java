package J8_LinkedLists;
/*
leetcode 876
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L10middleList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }//if fast is moving twice the speed of slow and fast has reached end means slow is at the middle of the list

        return slow; // Slow now points to the middle node
        //The fast pointer moves two steps, and the slow pointer moves one step.
        //When fast reaches the end, slow is at the middle node.
    }

    public static void main(String[] args) {
        // Example: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        L10middleList solution = new L10middleList();
        ListNode middle = solution.middleNode(head);

        // Print the middle node and the rest of the list(optional)
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
    }
}
