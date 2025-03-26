package J10_StacksQueues_Questions;
/*
leetcode 232
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions
of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:
void push(int x) :Pushes element x to the back of the queue.
int pop() :Removes the element from the front of the queue and returns it.
int peek() :Returns the element at the front of the queue.
boolean empty() :Returns true if the queue is empty, false otherwise.

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
*/

import java.util.Stack;

/*
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int removed=stack2.pop();

        while(!stack2.isEmpty()){//push remaining items back to stack1 to allow push operation again
            stack1.push(stack2.pop());
        }

        return removed;
    }

    public int peek() {
        //same as pop()
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int removed=stack2.peek();//dont remove just peek

        while(!stack2.isEmpty()){//push remaining items back to stack1 to allow push operation again
            stack1.push(stack2.pop());
        }

        return removed;

    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
*/
//in above approach pop() and peek() method takes O(n) operations each time
//in below approach
/*
Explanation of Amortized O(1):
Push:
Pushing into stack1 is an O(1) operation because it involves adding an element to the top of a stack.
Pop:
If stack2 is empty, all elements from stack1 are transferred to stack2. This takes O(n) for n elements.
However, once transferred, subsequent pop operations on stack2 are O(1), as no more transfers are needed until stack2 is emptied.
Hence, the cost of transferring elements is distributed across multiple pop operations, making the amortized cost O(1).
Peek:
Similar to pop, if stack2 is empty, it requires transferring elements from stack1 to stack2, which is an O(n) operation.
Once transferred, subsequent peek operations are O(1) until stack2 is emptied again.
This results in an amortized O(1) cost for peek.
Empty:
Checking if both stacks are empty is an O(1) operation.
*/
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    //Transfer all elements from stack1 to stack2 (if stack2 is empty), then pop from stack2
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //Transfer all elements from stack1 to stack2 (if stack2 is empty), then peek the top of stack2.
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // The queue is empty only if both stack1 and stack2 are empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

// Example usage
public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2]
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
