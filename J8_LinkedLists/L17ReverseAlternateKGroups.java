package J8_LinkedLists;

//if we create ListNode class here it will throw error of duplicate class
//we can access L7cyclicList's ListNode class coz we're in same package

public class L17ReverseAlternateKGroups {
    public static ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head; // No changes needed
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy; // Pointer to track the start of each group
        ListNode prev = null, next = null;

        boolean reverse = true; // Flag to alternate between reversing and skipping

        while (true) {
            // Check if there are at least k nodes left
            ListNode groupStart = current.next;
            ListNode temp = groupStart;
            int count = 0;

            while (count < k && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count < k) {
                break; // Not enough nodes to form a group, terminate
            }

            if (reverse) {
                // Reverse the group of k nodes
                ListNode prevNode = temp; // This will become the next group's "previous" node
                ListNode currNode = groupStart;

                for (int i = 0; i < k; i++) {
                    next = currNode.next;
                    currNode.next = prevNode;
                    prevNode = currNode;
                    currNode = next;
                }

                // Connect the reversed group with the previous part of the list
                ListNode tempNode = current.next; // Store the old group start
                current.next = prevNode; // Link to the new head of the reversed group
                current = tempNode; // Move the current pointer to the end of the reversed group
            } else {
                // Skip k nodes without reversing
                for (int i = 0; i < k; i++) {
                    current = current.next;
                }
            }

            // Toggle the reverse flag
            reverse = !reverse;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example 1: Input: head = [1,2,3,4,5,6,7,8], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        System.out.println("Original List:");
        printList(head);

        head = reverseAlternateKGroup(head, 2);

        System.out.println("Reversed Alternate K-Groups:");
        printList(head);
    }
}
/*
Input: head = [1,2,3,4,5,6,7,8], k = 2
Initial Setup
dummy → New dummy node pointing to head of the list.
dummy = [0 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8]
current = dummy → Pointer initialized to the dummy node.
reverse = true → Start with reversing the first group.
Start of the While Loop

The while (true) loop continues until we have fewer than k nodes left.
Iteration 1: Reverse First k = 2 Group
Step 1: Check if there are k nodes left
groupStart = current.next → groupStart = 1 (start of group).
Use temp to count k nodes:
temp moves to 2 → count = 1
temp moves to 3 → count = 2
temp stops since we have k nodes.
Check passed: There are k nodes.
Step 2: Reverse the group
Initialize prevNode = temp → prevNode = 3 (next node after group).
Initialize currNode = groupStart → currNode = 1.
Reverse using the for-loop:
First iteration (i = 0):
next = currNode.next → next = 2.
currNode.next = prevNode → 1.next = 3.
prevNode = currNode → prevNode = 1.
currNode = next → currNode = 2.
List: dummy → 0 → 1 → 3 → 4 → 5 → 6 → 7 → 8.
Second iteration (i = 1):
next = currNode.next → next = 3.
currNode.next = prevNode → 2.next = 1.
prevNode = currNode → prevNode = 2.
currNode = next → currNode = 3.
List: dummy → 0 → 2 → 1 → 3 → 4 → 5 → 6 → 7 → 8.
Step 3: Connect reversed group
tempNode = current.next → tempNode = 1 (old group start).
current.next = prevNode → current.next = 2 (new group head).
current = tempNode → Move current to 1 (end of reversed group).
List state after 1st iteration:
dummy → 0 → 2 → 1 → 3 → 4 → 5 → 6 → 7 → 8.
reverse = false → Toggle reverse flag to skip next group.

Iteration 2: Skip Next k = 2 Group
Step 1: Check if there are k nodes left
groupStart = current.next → groupStart = 3.
Use temp to count k nodes:
temp moves to 4 → count = 1
temp moves to 5 → count = 2
temp stops since we have k nodes.
Check passed: There are k nodes.
Step 2: Skip k nodes
Move current forward k nodes:
current = current.next → current = 3 (i = 0).
current = current.next → current = 4 (i = 1).
List state after skipping group:
dummy → 0 → 2 → 1 → 3 → 4 → 5 → 6 → 7 → 8.
reverse = true → Toggle reverse flag to reverse the next group.

Iteration 3: Reverse Third k = 2 Group
Step 1: Check if there are k nodes left
groupStart = current.next → groupStart = 5.
Use temp to count k nodes:
temp moves to 6 → count = 1
temp moves to 7 → count = 2
temp stops since we have k nodes.
Check passed: There are k nodes.
Step 2: Reverse the group
Initialize prevNode = temp → prevNode = 7.
Initialize currNode = groupStart → currNode = 5.
Reverse using the for-loop:
First iteration (i = 0):
next = currNode.next → next = 6.
currNode.next = prevNode → 5.next = 7.
prevNode = currNode → prevNode = 5.
currNode = next → currNode = 6.
List: dummy → 0 → 2 → 1 → 3 → 4 → 6 → 5 → 7 → 8.
Second iteration (i = 1):
next = currNode.next → next = 7.
currNode.next = prevNode → 6.next = 5.
prevNode = currNode → prevNode = 6.
currNode = next → currNode = 7.
List: dummy → 0 → 2 → 1 → 3 → 4 → 6 → 5 → 7 → 8.
Step 3: Connect reversed group
tempNode = current.next → tempNode = 5 (old group start).
current.next = prevNode → current.next = 6 (new group head).
current = tempNode → Move current to 5.
List state after 3rd iteration:
dummy → 0 → 2 → 1 → 3 → 4 → 6 → 5 → 7 → 8.
reverse = false → Toggle reverse flag.

Iteration 4: Skip Last k = 2 Group
Step 1: Check if there are k nodes left
groupStart = current.next → groupStart = 7.
Use temp to count k nodes:
temp moves to 8 → count = 1
temp moves to null → count = 2.
Check passed: There are k nodes.
Step 2: Skip k nodes
Move current forward k nodes:
current = current.next → current = 7 (i = 0).
current = current.next → current = 8 (i = 1).
End of While Loop
Now current = null, so we exit the loop.
Final List
dummy → 0 → 2 → 1 → 3 → 4 → 6 → 5 → 7 → 8.
(Remove dummy node).
Output: [2 → 1 → 3 → 4 → 6 → 5 → 7 → 8]
*/