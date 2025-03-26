package J9_Stacks_Queues;
/*
A dynamic stack implementation ensures that the stack grows in size automatically when it becomes full.
This is particularly useful for avoiding stack overflow issues in scenarios where the size of the stack cannot be predetermined.

In Java, a dynamic stack can be implemented using a resizable array or a linked list.
Below is the implementation using a resizable array.
*/
class dynamicStack{
    private int[] stack;
    private int top;
    private int capacity;

    public dynamicStack(int initialSize){
        stack=new int[initialSize];
        top=-1;
        capacity=initialSize;
    }

    // Push operation
    public void push(int value) {
        if (isFull()) {
            resize(); // Double the size of the stack
        }
        stack[++top] = value; // Add the element and update top
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop element.");
            return -1;
        }
        return stack[top--]; // Remove and return the top element
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top]; // Return the top element
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    private boolean isFull() {
        return top == capacity - 1;
    }

    // Resize the stack to double its current capacity
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newStack = new int[newCapacity];//or int[] newStack=new int[capacity*2];
        //System.arraycopy(stack, 0, newStack, 0, capacity); // Copy old stack to new stack
        //stack = newStack;
        //capacity = newCapacity;
        //or
        for(int i=0;i<capacity;i++){
            newStack[i]=stack[i];
        }
        capacity=newCapacity;
        stack=newStack;//now stack is of double prev. capacity
        System.out.println("Stack resized to capacity: " + newCapacity);
    }

    // Display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

public class S6DynamicStackExample {
    public static void main(String[] args) {
        dynamicStack stack = new dynamicStack(3); // Initial capacity is 3

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        // Push more elements to trigger resizing
        stack.push(40);
        stack.push(50);

        stack.display();

        // Pop elements
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        // Peek at the top element
        System.out.println("Peek: " + stack.peek());
    }
}
