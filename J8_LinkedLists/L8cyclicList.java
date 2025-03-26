package J8_LinkedLists;
/*
leetcode 142
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.
Input: head = [3,2,0,-4], pos = 1
 3->2->0->-4--|
    ^         |
    |_________|
Output: tail connects to node index 1 i.e, 2
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Input: head = [1,2], pos = 0
    1->2
    ^  |
    |__|
Output: tail connects to node index 0 i.e, 1
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Input: head = [1], pos = -1
    1->null
Output: no cycle i.e, null
Explanation: There is no cycle in the linked list.
*/

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L8cyclicList {
    /*
    //Kunal Kushwaha Bootcamp
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {//if list empty or has only node but not cyclic
            System.out.println("no cycle found..");
            return null;
        }

        ListNode slow = head; // Slow pointer
        ListNode fast = head; // Fast pointer

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;     // Move fast pointer two steps

            if (slow == fast) {        // Cycle detected
                int count=0;
                do{
                    slow=slow.next;
                    count++;
                }while(slow!=fast);
                //upto here just copy pasted hasCycle method from L8cyclicList.java

                ListNode first=head;
                ListNode second=head;//both the pointers are pointing to the head

                while(count>0){
                    first=first.next;
                    count--;
                }//pushing first pointer cycle's length i.e, count positions forward

                while (first!=second){//now move both pointers one step at a time
                    first=first.next;
                    second=second.next;
                }//if first==second i.e, both pointers meet then the meeting point should be start of cycle
                return first;//or second coz both are pointing same node
            }
        }
        System.out.println("no cycle found");
        return null; // No cycle
    }
    */

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Find the start of the cycle
                slow = head;//now point the slow pointer to head of the list
                while (slow != fast) {//and move both pointers one step at a time
                    slow = slow.next;
                    fast = fast.next;
                }//they will meet exactly at start of the cycle
                return slow; // The start of the cycle
            }
        }

        return null; // No cycle
    }
    /*
    explanation of step2:find the start of cycle:
    This works because of the following mathematical reasoning:

    Definitions:
    Let the distance from the head to the start of the cycle be 𝑘
    Let the distance from the start of the cycle to the meeting point be 𝑚
    Let the length of the cycle be 𝐶
    Distance Traveled:
    By the time the slow pointer and fast pointer meet:
    The slow pointer has traveled k+m steps.
    The fast pointer has traveled 2(k+m) steps (because it moves twice as fast).
    The fast pointer has also completed one or more full cycles in the loop:
    2(k+m) = k+m+nC
    Where n is the number of full cycles completed by the fast pointer.
    Simplifying:
    k+m=nC

    Key Insight:
    Rearrange
    k+m=nC to get:
    k=nC−m
    This means the distance from the head to the start of the cycle (k) is equal to the distance from the meeting point to
    the start of the cycle (nC−m, which is a multiple of the cycle length).

    Resetting the Slow Pointer:
    When the slow pointer is reset to the head:
    Both the slow pointer and fast pointer move one step at a time.
    The slow pointer travels k steps to reach the start of the cycle.
    The fast pointer, starting from the meeting point, also travels k steps to reach the start of the cycle
    (because the remaining distance from the meeting point to the cycle start i.e,(nC-m) is also k).
    They Meet at the Start of the Cycle:
    Therefore, the node where they meet is the start of the cycle.
    */

    public static void main(String[] args) {
        // Example 1: head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // Creates a cycle (pos = 1)

        L8cyclicList solution = new L8cyclicList();
        System.out.println(solution.detectCycle(head).val); // Output: 2

        // Example 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        head2.next = second2;
        second2.next = head2; // Creates a cycle (pos = 0)

        System.out.println(solution.detectCycle(head2).val); // Output: 1

        // Example 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);

        System.out.println(solution.detectCycle(head3)); // Output: null
    }
}
