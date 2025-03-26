package J10_StacksQueues_Questions;

/*
leetcode 20
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
*/

import java.util.Scanner;
import java.util.Stack;

public class validParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(ch==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                }
                if(ch=='}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }
                if(ch==']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String p;
        System.out.println("enter the string containing parenthesis only..");
        p=sc.next();
        validParenthesis v=new validParenthesis();
        System.out.println(v.isValid(p));
    }
}
