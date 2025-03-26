package J9_Stacks_Queues;

class LinearQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public LinearQueue(int size) {
        queueArray = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot add " + value);
            return;
        }
        queueArray[++rear] = value; // Increment rear and add the value
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot remove element.");
            return -1;
        }
        int dequeuedValue = queueArray[front]; // Retrieve the front element
        front++; // Move front pointer forward
        return dequeuedValue;
    }
    //if the condition was to use only 1 pointer i.e, rear (here we've used front and rear pointers)
    //then store queueArray[0] to remove it/pop it and shift remaining elements left side by one position
    //for(i=1;i<rear;i++) { queueArray[i-1]=queueArray[i] }
    //rear--; //one item decreased

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueArray[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front > rear;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }
}

public class S7ArrayQueueExample {
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        // Attempt to enqueue when full
        queue.enqueue(60);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();

        // Peek at the front
        System.out.println("Peek: " + queue.peek());

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Attempt to dequeue from an empty queue
        System.out.println();
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
