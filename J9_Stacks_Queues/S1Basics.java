package J9_Stacks_Queues;

import java.util.Stack;
/*
A stack follows the LIFO (Last In, First Out) principle, meaning the last element added is the first to be removed.
Key Features of Stack:
Insertion and removal happen only at the top of the stack.
Used in scenarios like:
Expression evaluation (e.g., infix to postfix conversion).
Undo/redo functionality.
Function call stack.
Common Stack Operations:
Push: Add an element to the top of the stack.
Pop: Remove the element at the top of the stack.
Peek: View the element at the top of the stack without removing it.
isEmpty: Check if the stack is empty.
*/
public class S1Basics {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        /*
        1. Left Side (Before = sign): Stack<Integer> stack
        This declares a reference variable. It specifies:
        Data Type: Stack<Integer> indicates that this variable (stack) will refer to a stack that stores Integer objects.
        Variable Name: stack is the name of the reference variable.
        The left side does not allocate memory or create an object. It simply states what type of object the variable can hold.

        2. Right Side (After = sign): new Stack<>()
        This is the object instantiation part, where:
        new: Allocates memory for a new object.
        Stack<>(): Calls the constructor of the Stack class to create an actual stack object.
        The right side creates a new stack object in memory and returns a reference to it.
        */

        // Push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after push: " + stack);

        // Peek operation
        System.out.println("Peek: " + stack.peek());

        // Pop operation
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // isEmpty operation
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
