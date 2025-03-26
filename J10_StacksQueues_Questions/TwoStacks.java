package J10_StacksQueues_Questions;


/*
Alexa has two stacks of non-negative integers, stack a[n] and stack b[m]  where index 0 denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack a or stack b .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer maxSum given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given a,b, and maxSum for g games, find the maximum possible score Nick can achieve.

Example
a=[1,2,3,4,5]
b=[6,7,8,9]

The maximum number of values Nick can remove is 4. There are two sets of choices with this result.

Remove 1,2,3,4 from a with a sum of 10.
Remove 1,2,3 from a and 6 from b with a sum of 12.
Function Description
Complete the twoStacks function in the editor below.

twoStacks has the following parameters: - int maxSum: the maximum allowed sum
- int a[n]: the first stack
- int b[m]: the second stack

Returns
- int: the maximum number of selections Nick can make

sample input:
1                               (no. of games)
5 4 10                          (size of a,size of b,maxSum)
4 2 4 6 1                       (first array)
2 1 8 5                         (second array)

sample output:
4

we use recursion to solve this so we'll check with each top element and go on adding and returning when sum reaches >maxSum
and finally the no.of.steps-1 will be answer -1 coz no.of.steps the sum would be >maxSum so we need when !>maxSum
refer twostacks.png
*/

import java.util.Arrays;
import java.util.Scanner;

public class TwoStacks {
    static int twoStacks(int x, int[] a, int[] b) {
        return twoStacksHelper(x, a, b, 0, 0, 0);
    }

    private static int twoStacksHelper(int x, int[] a, int[] b, int indexA, int indexB, int sum) {
        // Base case: if sum exceeds x, return the count so far (excluding the last element)
        if (sum > x) {
            return indexA + indexB - 1;
        }

        // If both arrays are exhausted, return the total count
        if (indexA == a.length && indexB == b.length) {
            return indexA + indexB;
        }

        // If one array is exhausted, continue with the other
        if (indexA == a.length) {
            return twoStacksHelper(x, a, b, indexA, indexB + 1, sum + b[indexB]);
        }
        if (indexB == b.length) {
            return twoStacksHelper(x, a, b, indexA + 1, indexB, sum + a[indexA]);
        }
        // Recursively try picking from both stacks
        int ans1 = twoStacksHelper(x, a, b, indexA + 1, indexB, sum + a[indexA]);
        int ans2 = twoStacksHelper(x, a, b, indexA, indexB + 1, sum + b[indexB]);

        // Return the maximum count
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
/*        Scanner sc=new Scanner(System.in);
        System.out.println("enter the no. of games..");
        int t=sc.nextInt();//no. of games
        for(int i=0;i<t;i++){
            System.out.println("enter in sequence \nlength of array a\nlength of array b\ntotal sum\nelements of array a\nelements of array b");
            int n=sc.nextInt();//length of array a
            int m=sc.nextInt();//length of array b
            int x=sc.nextInt();//total sum
            int[] a=new int[n];
            int[] b=new int[m];
            for(int j=0;j<n;j++){
                a[j]=sc.nextInt();
            }
            for(int j=0;j<m;j++){
                b[j]=sc.nextInt();
            }

            System.out.println(twoStacks(x,a,b));

        }*/
        //for debugging use below function call
        System.out.println(twoStacks(10,new int[]{4,2,4,6,1},new int[]{2,1,8,5}));
    }
}
/*
dry running using above approach

Initial Call
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 0, 0, 0)
indexA = 0, indexB = 0, sum = 0
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 1: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 1, 0, 4)
indexA = 1, indexB = 0, sum = 4
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 2: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 0, 6)
indexA = 2, indexB = 0, sum = 6
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 3: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 3, 0, 10)
indexA = 3, indexB = 0, sum = 10
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 4: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 4, 0, 16)
indexA = 4, indexB = 0, sum = 16
Base case triggered: sum > x (16 > 10)
Return indexA + indexB - 1 = 4 + 0 - 1 = 3

Back to Recursive Call 3
Result of picking from a: 3
Now try picking from b:
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 3, 1, 12)
indexA = 3, indexB = 1, sum = 12
Base case triggered: sum > x (12 > 10)
Return indexA + indexB - 1 = 3 + 1 - 1 = 3
Compare results: max(3, 3) = 3
Return 3

Back to Recursive Call 2
Result of picking from a: 3
Now try picking from b:
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 1, 8)
indexA = 2, indexB = 1, sum = 8
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 5: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 3, 1, 12)
indexA = 3, indexB = 1, sum = 12
Base case triggered: sum > x (12 > 10)
Return indexA + indexB - 1 = 3 + 1 - 1 = 3

Recursive Call 6: Pick from b
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 2, 9)
indexA = 2, indexB = 2, sum = 9
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 7: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 3, 2, 13)
indexA = 3, indexB = 2, sum = 13
Base case triggered: sum > x (13 > 10)
Return indexA + indexB - 1 = 3 + 2 - 1 = 4

Recursive Call 8: Pick from b
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 3, 14)
indexA = 2, indexB = 3, sum = 14
Base case triggered: sum > x (14 > 10)
Return indexA + indexB - 1 = 2 + 3 - 1 = 4
Compare results: max(4, 4) = 4
Return 4

Back to Recursive Call 2
Result of picking from b: 4
Compare results: max(3, 4) = 4
Return 4

Back to Recursive Call 1
Result of picking from a: 4
Now try picking from b:
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 1, 1, 6)
indexA = 1, indexB = 1, sum = 6
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 9: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 1, 8)
indexA = 2, indexB = 1, sum = 8
Already computed in Recursive Call 5. Result: 4

Recursive Call 10: Pick from b
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 1, 2, 7)
indexA = 1, indexB = 2, sum = 7
Neither array is exhausted.
Recursively try picking from a and b.

Recursive Call 11: Pick from a
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 2, 2, 9)
indexA = 2, indexB = 2, sum = 9
Already computed in Recursive Call 6. Result: 4

Recursive Call 12: Pick from b
twoStacksHelper(10, [4,2,4,6,1], [2,1,8,5], 1, 3, 12)
indexA = 1, indexB = 3, sum = 12
Base case triggered: sum > x (12 > 10)
Return indexA + indexB - 1 = 1 + 3 - 1 = 3
Compare results: max(4, 3) = 4
Return 4

Back to Recursive Call 1
Result of picking from b: 4
Compare results: max(4, 4) = 4
Return 4

Back to Initial Call
Final result: 4

Output
4
This means the maximum number of elements you can pick from the two stacks without exceeding the sum of 10 is 4.
*/

//non-recursive approach
/*
public static int twoStacks(int maxSum, int[] a, int[] b) {
        int n = a.length; // Length of stack a
        int m = b.length; // Length of stack b

        int currentSum = 0;  // Running sum of removed elements
        int count = 0;  // Total count of removed elements

        // First, calculate how many elements we can take from stack a
        int maxCount = 0;  // The maximum number of elements we can remove
        int i = 0; // Pointer for stack a

        // Start removing elements from stack a while the sum does not exceed maxSum
        while (i < n && currentSum + a[i] <= maxSum) {
            currentSum += a[i]; // Add element from stack a to the sum
            i++;  // Move to the next element in stack a
        }

        maxCount = i;  // The maximum count is the number of elements removed from stack a

        // Now, let's start removing from stack b
        int j = 0;  // Pointer for stack b
        while (j < m && j <= i) {//This avoids an unfair advantage, where we could take more from b than we should.This prevents removing too many from b before ensuring a is properly adjusted.

            // For each element removed from stack b, update the running sum
            currentSum += b[j];
            j++;

            // If the sum exceeds maxSum, adjust by removing elements from stack a
            //If adding b[j] exceeds maxSum, we remove elements from a to adjust.
            //i > 0 ensures we don’t go below zero elements removed from a.
            while (currentSum > maxSum && i > 0) {
                i--;  // Remove one element from stack a
                currentSum -= a[i];  // Subtract that element from the sum
            }

            // Update the maximum count of elements removed from both stacks
            maxCount = Math.max(maxCount, i + j);  // The total elements removed (i from a, j from b)
            //Updates maxCount to store the highest number of elements removed so far.
        }

        return maxCount;  // Return the maximum count of elements removed
    }

    public static void main(String[] args) {
        // Sample Input
        int maxSum = 10;
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};

        // Output the result
        int result = twoStacks(maxSum, a, b);
        System.out.println(result); // Expected Output: 4
    }

    //j <= i ensures we do not remove more from b than a allows.
    //We greedily remove from a first, then try to remove from b, adjusting when needed.
    //currentSum + a[i] <= maxSum prevents adding elements that exceed the sum.
    //The loop efficiently adjusts a to maximize removals without exceeding maxSum.
*/