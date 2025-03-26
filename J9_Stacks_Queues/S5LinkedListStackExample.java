package J9_Stacks_Queues;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Stack1 {
    private Node top;

    // Push operation
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    //checking of stack overflow
    /*
    In a linked list-based stack implementation, stack overflow can occur when the system runs out of memory to allocate a new node.
    Unlike array-based stacks with a fixed capacity,a linked list stack theoretically does not have a predefined limit unless
    we explicitly set one.
    if you want to check then create a constructor and pass the capacity and initialize a size variable with value 0
    and whenever push happens increase it and whenever pop happens decrease it and check size==capacity for stack overflow
    */

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Test the stack
public class S5LinkedListStackExample {
    public static void main(String[] args) {
        Stack1 stack = new Stack1();

        stack.push(10);
        stack.pop();
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        stack.display();

        System.out.println("Popped element: " + stack.pop());
        stack.display();
    }
}
