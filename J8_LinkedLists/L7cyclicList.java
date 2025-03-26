package J8_LinkedLists;

/*
leetcode 141
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
Input: head = [3,2,0,-4], pos = 1
    3->2->0->-4--|
       ^         |
       |_________|
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Input: head = [1,2], pos = 0
    1->2
    ^  |
    |__|
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Input: head = [1], pos = -1
    1->null
Output: no cycle
Explanation: There is no cycle in the linked list.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
/*
Using Floyd's 'cycle detection algorithm' also known as 'Tortoise and Hare Algorithm'
1.slow pointer(Tortoise) moves one step at a time
2.fast pointer(Hare) moves two steps at a time
if there is a cycle, the fast pointer will eventually meet the slow pointer
if there is no cycle, the fast pointer will reach end of the list.
*/
public class L7cyclicList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {//if list empty or has only node but not cyclic
            return false;
        }

        ListNode slow = head; // Slow pointer
        ListNode fast = head; // Fast pointer

        while (fast != null && fast.next != null) {//conditions becomes false/loop breaks if list does not have cycle
            //fast is used coz fast traverse faster than slow i.e,fast reaches end before slow..
            //if fast==null means it has reached after last node and fast.next==null means fast itself is last node
            //also ensures it's not trying to access non-existing node or go out of bounds
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;     // Move fast pointer two steps

            if (slow == fast) {        // Cycle detected
                //let's calculate length of the cycle
                int count=0;
                //keep fast there only and move slow one step at a time till it reaches fast again..
                do{
                    slow=slow.next;
                    count++;
                }while(slow!=fast);//if we use this condition in while loop then loop doesn't start only coz already slow==fast so use do-while
                System.out.println("Length of cycle: "+count);

                return true;//this is the only line required after if statement (if length of cycle is not asked..)
            }
            //what is the guarantee that slow and fast will meet when cycle is detected
            //case1
            //consider fast is one step behind the slow(for instance fast at 0th and slow at 1st position in cycle)-->next iteration slow will move 1 step forward
            //i.e, reaches position 2 and fast move 2 steps forward i.e, it also reaches position 2 ...so they met
            //case2
            //consider fast is two steps behind the slow(for instance fast at 0th and slow at 2nd position in cycle)-->next iteration slow will move
            //1 step forward i.e, reaches position 3 and fast move 2 steps forward i.e, it reaches 2nd position
            //and now fast is one step behind the slow ..case1 in which they meet
            //and so on.. so certainly they end up meeting(slow==fast) if it's cyclic list
        }

        return false; // No cycle
    }

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

        L7cyclicList solution = new L7cyclicList();
        System.out.println(solution.hasCycle(head)); // Output: true

        // Example 2: head = [1,2], pos = 0
        ListNode head2 = new ListNode(1);
        ListNode second2 = new ListNode(2);
        head2.next = second2;
        second2.next = head2; // Creates a cycle (pos = 0)

        System.out.println(solution.hasCycle(head2)); // Output: true

        // Example 3: head = [1], pos = -1
        ListNode head3 = new ListNode(1);

        System.out.println(solution.hasCycle(head3)); // Output: false
    }
}
