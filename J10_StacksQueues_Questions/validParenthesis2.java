package J10_StacksQueues_Questions;

import java.util.Scanner;
import java.util.Stack;

/*
leetcode 921
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3
*/
public class validParenthesis2 {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        int unmatched_count=0;

        for(char ch:s.toCharArray()){
            if(ch=='(')//checking for only round brackets
                stack.push(ch);
            else{
                if(!stack.isEmpty() && ch==')')
                    stack.pop();
                else//if stack is empty and ch==')'
                    unmatched_count++;
            }
        }
        return stack.size()+unmatched_count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String p;
        System.out.println("enter the string containing round parenthesis only..");
        p=sc.next();
        validParenthesis2 v=new validParenthesis2();
        System.out.println(v.minAddToMakeValid(p));
    }
}
