package J8_LinkedLists;
/*
leetcode 234
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Input: head = [1,2,2,1]
Output: true
Input: head = [1,2]
Output: false
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L14palindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A single-node or empty list is always a palindrome.
        }

        // Step 1: Find the middle of the list
        // or you can copy paste middleNode method from L10middleList.java
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverse(slow);

        // Step 3: Compare the two halves
        ListNode firstHalf = head;
        ListNode temp = secondHalf; // To restore the list later, save the head of the reversed second half
        boolean isPalindrome = true;

        while (secondHalf != null) {//take care of both even and odd no. of nodes
            //even: abba here mid points to second b and reverse ba i.e, ab so a=a and b=b and secondHalf==null end of loop
            //odd: abcba here mid points to c and reverse cba i.e, abc so a=a, b=b and c=c and secondHalf==null end of loop
            if (firstHalf.val != secondHalf.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4 (Optional): Restore the list
        reverse(temp);

        return isPalindrome;
    }

    // Helper method to reverse a linked list
    // copy pasted reverse method from L12reverseList.java
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
        // Example 1: Palindrome list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // Output: true

        // Example 2: Non-palindrome list
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println(isPalindrome(head2)); // Output: false
    }
}
