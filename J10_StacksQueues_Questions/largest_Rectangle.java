package J10_StacksQueues_Questions;

/*
leetcode 84
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.
Example 1:

refer largest_Rectangle.png
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
*/
public class largest_Rectangle {

    //bruteforce approach
    public int maxArea(int[] heights){
        int n=heights.length;
        int max_area=0; //you can set Integer.MIN_VALUE

        for(int i=0;i<n;i++){
            int minHeight=Integer.MAX_VALUE; //initializing with worst case
            for(int j=i;j<n;j++){
                minHeight=Math.min(minHeight,heights[j]);
                int current_area=minHeight*(j-i+1);
                //Here:
                //minHeight is the minimum height between indices i and j.
                //(j - i + 1) is the width of the rectangle (number of bars between i and j, inclusive).
                max_area=Math.max(max_area,current_area);
            }
        }
        return max_area;
    }
    /*
    For the input heights = {2, 1, 5, 6, 2, 3}:

When i = 0:

j ranges from 0 to 5.
For j = 0: minHeight = 2, currentArea = 2 * 1 = 2.
For j = 1: minHeight = 1, currentArea = 1 * 2 = 2.
For j = 2: minHeight = 1, currentArea = 1 * 3 = 3.
For j = 3: minHeight = 1, currentArea = 1 * 4 = 4.
For j = 4: minHeight = 1, currentArea = 1 * 5 = 5.
For j = 5: minHeight = 1, currentArea = 1 * 6 = 6.
maxArea is updated to 6.

When i = 1:
j ranges from 1 to 5.
For j = 1: minHeight = 1, currentArea = 1 * 1 = 1.
For j = 2: minHeight = 1, currentArea = 1 * 2 = 2.
For j = 3: minHeight = 1, currentArea = 1 * 3 = 3.
For j = 4: minHeight = 1, currentArea = 1 * 4 = 4.
For j = 5: minHeight = 1, currentArea = 1 * 5 = 5.
maxArea remains 6.

When i = 2:
j ranges from 2 to 5.
For j = 2: minHeight = 5, currentArea = 5 * 1 = 5.
For j = 3: minHeight = 5, currentArea = 5 * 2 = 10.
For j = 4: minHeight = 2, currentArea = 2 * 3 = 6.
For j = 5: minHeight = 2, currentArea = 2 * 4 = 8.
maxArea is updated to 10.

Continue similarly for i = 3, i = 4, and i = 5.

Final Output
The maximum area is 10.
    */

    public static void main(String[] args) {
        //heights array
        int[] heights={2,1,5,6,2,3};

        largest_Rectangle lr=new largest_Rectangle();
        System.out.println(lr.maxArea(heights));
    }
}



//optimized code using stack
/*
import java.util.Deque;
import java.util.ArrayDeque;

public class Solution {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        // Arrays to store the indices of the previous and next smaller elements
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // Initialize prevSmaller array with -1 (no smaller element to the left)
        for (int i = 0; i < n; i++) {
            prevSmaller[i] = -1;
        }

        // Initialize nextSmaller array with n (no smaller element to the right)
        for (int i = 0; i < n; i++) {
            nextSmaller[i] = n;
        }

        // Stack to track indices of bars in increasing order of height
        Deque<Integer> stack = new ArrayDeque<>();

        // Step 1: Find previous smaller elements
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until we find a smaller bar
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            // If stack is not empty, the top element is the previous smaller
            if (!stack.isEmpty()) {
                prevSmaller[i] = stack.peek();
            }
            // Push the current index to the stack
            stack.push(i);
        }

        // Clear the stack for reuse
        stack.clear();

        // Step 2: Find next smaller elements
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack when the current bar is smaller than the stack's top
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int popped = stack.pop();
                nextSmaller[popped] = i;
            }
            // Push the current index to the stack
            stack.push(i);
        }

        // Step 3: Calculate the maximum area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // Width = distance between nextSmaller and prevSmaller (exclusive)
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            // Area = height * width
            int area = heights[i] * width;
            // Update maxArea if the current area is larger
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights)); // Output: 10
    }
}
*/

//dry run
/*
Dry Run:
Initialization:
heights = [2, 1, 5, 6, 2, 3]

n = 6

prevSmaller = [-1, -1, -1, -1, -1, -1]

nextSmaller = [6, 6, 6, 6, 6, 6]

stack = []

maxArea = 0

Step 1: Find prevSmaller:
i	heights[i]	Stack State (indices)	Action	prevSmaller Update
0	2	[]	Push 0 → [0]	prevSmaller[0] = -1
1	1	[0]	Pop 0 (since heights[0] >= heights[1]) → [] → Push 1 → [1]	prevSmaller[1] = -1
2	5	[1]	Push 2 → [1, 2]	prevSmaller[2] = 1
3	6	[1, 2]	Push 3 → [1, 2, 3]	prevSmaller[3] = 2
4	2	[1, 2, 3]	Pop 3 (since heights[3] >= heights[4]) → [1, 2]	prevSmaller[4] = 1
[1, 2]	Pop 2 (since heights[2] >= heights[4]) → [1] → Push 4 → [1, 4]
5	3	[1, 4]	Push 5 → [1, 4, 5]	prevSmaller[5] = 4
Result:
prevSmaller = [-1, -1, 1, 2, 1, 4]

Step 2: Find nextSmaller:
Reset stack = []

i	heights[i]	Stack State (indices)	Action	nextSmaller Update
0	2	[]	Push 0 → [0]	None
1	1	[0]	Pop 0 (since heights[0] > heights[1]) → nextSmaller[0] = 1 → []	nextSmaller[0] = 1
[]	Push 1 → [1]
2	5	[1]	Push 2 → [1, 2]	None
3	6	[1, 2]	Push 3 → [1, 2, 3]	None
4	2	[1, 2, 3]	Pop 3 (since heights[3] > heights[4]) → nextSmaller[3] = 4 → [1, 2]	nextSmaller[3] = 4
[1, 2]	Pop 2 (since heights[2] > heights[4]) → nextSmaller[2] = 4 → [1]	nextSmaller[2] = 4
[1]	Push 4 → [1, 4]
5	3	[1, 4]	Push 5 → [1, 4, 5]	None
Result:
nextSmaller = [1, 6, 4, 4, 6, 6]

Step 3: Calculate Maximum Area:
i	heights[i]	prevSmaller[i]	nextSmaller[i]	Width (nextSmaller[i] - prevSmaller[i] - 1)	Area (heights[i] * Width)	maxArea Update
0	2	-1	1	1 - (-1) - 1 = 1	2 * 1 = 2	max(0, 2) = 2
1	1	-1	6	6 - (-1) - 1 = 6	1 * 6 = 6	max(2, 6) = 6
2	5	1	4	4 - 1 - 1 = 2	5 * 2 = 10	max(6, 10) = 10
3	6	2	4	4 - 2 - 1 = 1	6 * 1 = 6	max(10, 6) = 10
4	2	1	6	6 - 1 - 1 = 4	2 * 4 = 8	max(10, 8) = 10
5	3	4	6	6 - 4 - 1 = 1	3 * 1 = 3	max(10, 3) = 10
Final Result:
maxArea = 10

Output:
The largest rectangle area is 10, found in the interval [2, 3] with height 5 and width 2.

Why Initialize prevSmaller with -1 and nextSmaller with n?
prevSmaller Initialized with -1:
If there is no smaller bar to the left of a bar, the left boundary is considered to be outside the array (i.e., index -1).
This ensures that the width calculation (nextSmaller[i] - prevSmaller[i] - 1) works correctly when no smaller bar exists to the left.

nextSmaller Initialized with n:
If there is no smaller bar to the right of a bar, the right boundary is considered to be outside the array (i.e., index n).
This ensures that the width calculation works correctly when no smaller bar exists to the right.
*/