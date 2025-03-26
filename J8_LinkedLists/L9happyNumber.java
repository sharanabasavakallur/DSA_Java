package J8_LinkedLists;
/*
leetcode 202
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:
Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:
Input: n = 2
Output: false
*/

/*
Why the Slow/Fast Pointer Works
Similar to the "tortoise and hare" method for cycle detection, this approach helps identify repeating numbers (cycles)
without using extra memory.
If there is a cycle, the slow and fast pointers will eventually meet.
If n is a happy number, the fast pointer will reach 1.
*/
/*
Key Similarities between cycle detection and this
Cycle Detection:
In both cases, you are essentially trying to detect a cycle.
In a linked list, a cycle means a node's next pointer eventually points back to a previous node.
In the happy number problem, a cycle occurs when the sequence of sums of squares of digits starts repeating.
Slow and Fast Pointer Technique:
Both problems can use the tortoise and hare (slow and fast pointer) approach to detect cycles efficiently.
In the linked list, the slow pointer moves one step, and the fast pointer moves two steps.
In the happy number problem:
The slow pointer computes the sum of squares once per iteration.
The fast pointer computes the sum of squares twice per iteration.
Stopping Conditions:
For a linked list:
The slow and fast pointers meet inside the cycle.
If there’s no cycle, the fast pointer reaches null.
For a happy number:
The slow and fast pointers meet inside a repeating cycle (not happy).
If the number is happy, the fast pointer reaches 1.
*/
public class L9happyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSumOfSquares(n);//not assigning both with n coz while loop conditions slow!=false will fail without entering loop

        while (fast != 1 && slow != fast) {
            slow = getSumOfSquares(slow);//one step i.e, find square of itself and that's it
            fast = getSumOfSquares(getSumOfSquares(fast));//two steps i.e, find square of square of it
        }

        return fast == 1;//if slow and fast met means there's cycle(so return false) and after meeting also fast==1 means it's a happy number
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        L9happyNumber solution = new L9happyNumber();
        System.out.println(solution.isHappy(19)); // Output: true
        System.out.println(solution.isHappy(2));  // Output: false
    }
}
/*
example 1: n=19
1. 1^2+9^2 = 82
2. 8^2+2^2 = 68
3. 6^2+8^2 = 100
4. 1^2+0^2+0^2 = 1
so 19->82->68->100->1 stops happy number

example 2: n=2
1. 2^2 = 4
2. 4^2 = 16
3. 1^2+6^2 = 37
4. 3^2+7^2 = 58
5. 5^2+8^2 = 89
6. 8^2+9^2 = 145
7. 1^2+4^2+5^2 = 42
8. 4^2+2^2 = 20
9. 2^2+0^2 = 4 (cycle detected)
so 2->4->16->37->58->89->145->42->20-|
      ^                              |
      |______________________________|

      eventually slow==fast but fast!=1 so not a happy number
*/

/*
Time Complexity Analysis
Digit Squaring Process
For each iteration, calculating the sum of squares takes
𝑂(log.base10.(n)) time, where is the number of digits in n.
Number of Iterations
Since the values of n drop into the range
[1,243] coz for 999 9^2+9^2+9^2=243
[1,243] quickly and the process either reaches 1 or enters a cycle, the maximum number of iterations is bounded by a constant.

Total Time Complexity:
𝑂(log.base10.(n))
*/