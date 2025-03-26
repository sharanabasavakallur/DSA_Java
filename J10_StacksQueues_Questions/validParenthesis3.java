package J10_StacksQueues_Questions;

import java.util.Stack;

/*
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

Example 1:
Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
Example 2:
Input: s = "())"
Output: 0
Explanation: The string is already balanced.
Example 3:
Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
*/
public class validParenthesis3 {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0; // Track extra insertions needed

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch); // Push '(' to stack
            } else { // Encounter ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // Found '))'
                    i++; // Move to next character
                } else { // Single ')' case
                    insertions++; // Need one more ')' to form '))'
                }

                if (!stack.isEmpty()) { // Match with an existing '('
                    stack.pop();
                } else { // No unmatched '(' to pair with '))'
                    insertions++; // Insert '(' before '))'
                }
            }
            i++;
        }

        // Each unmatched '(' needs two '))' to balance
        insertions += stack.size() * 2;

        return insertions;
    }

    public static void main(String[] args) {
        validParenthesis3 solution = new validParenthesis3();

        // Test cases
        System.out.println(solution.minInsertions("(()))"));   // Output: 1
        System.out.println(solution.minInsertions("())"));     // Output: 0
        System.out.println(solution.minInsertions("))())("));  // Output: 3

        System.out.println(solution.minInsertions(")))"));
    }
}

/*
Dry run :
Example 1 (Normal Case)
Input:
s = "(()))"
Expected Output:
1 (because we need one extra ) to balance the extra ()

Step-by-Step Execution
public int minInsertions(String s) {
    Stack<Character> stack = new Stack<>(); // Create stack to track '('
    int insertions = 0; // Track extra insertions needed

    int i = 0;
    while (i < s.length()) {
        char ch = s.charAt(i);

Initialize an empty stack
insertions = 0
i = 0

Iteration 1 (i = 0, `ch = '(' )
if (ch == '(') {
    stack.push(ch); // Push '(' to stack
}

stack = ['(']
Move to next character (i = 1)

Iteration 2 (i = 1, `ch = '(' )
if (ch == '(') {
    stack.push(ch); // Push '(' to stack
}

stack = ['(', '(']
Move to next character (i = 2)

Iteration 3 (i = 2, `ch = ')' )
if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // Found '))'
Next character is ) (at i+1 = 3), so it's a valid )) pair.

Move i++ to skip next ), now i = 3
if (!stack.isEmpty()) { // Match with an existing '('
    stack.pop();
} else {
    insertions++; // Insert '(' before '))'
}

Stack is not empty, so we pop one (
stack = ['(']
Move to next character (i = 4)

Iteration 4 (i = 4, `ch = ')' )
if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // Found '))'
Next character (i+1 = 5) is out of bounds, so we don't have a ))

We need one more ) to make a )), so:
insertions++; // Need one more ')' to form '))'
insertions = 1
if (!stack.isEmpty()) { // Match with an existing '('
    stack.pop();
} else {
    insertions++; // Insert '(' before '))'
}

Stack is not empty, so we pop (
stack = []
Move to next character (i = 5, exit loop)

Post Loop Processing
insertions += stack.size() * 2; // Each '(' needs two '))'
stack = [], so no extra insertions needed

Final insertions = 1

Final Output
return insertions; // Returns 1
Answer: 1


Example 2: input:")))"

Iteration 1 (i = 0, `ch = ')' )
if (i + 1 < s.length() && s.charAt(i + 1) == ')') { // Found '))'
Next character (i+1 = 1) is ), so we found a )) pair.
if (!stack.isEmpty()) { // Match with an existing '('
    stack.pop();
} else { // No unmatched '(' to pair with '))'
    insertions++; // Insert '(' before '))'
}
Stack is empty, so we insert ( before )).

insertions = 1
Move to next character (i = 2)

Iteration 2 (i = 2, `ch = ')' )
No )) pair (since we are at the last character).

We need one more ) to complete )).
insertions++; // Need one more ')' to form '))'
insertions = 2
if (!stack.isEmpty()) { // Match with an existing '('
    stack.pop();
} else { // No unmatched '(' to pair with '))'
    insertions++; // Insert '(' before '))'
}
Stack is empty, so we insert one ( before this ).

insertions = 3

Move to next character (i = 3, exit loop)

Post Loop Processing
insertions += stack.size() * 2; // Each '(' needs two '))'
Stack is empty, so no additional insertions needed.

Final Output
return insertions; // Returns 3
Correct Answer: 3
*/