package J9_Stacks_Queues;

class ArrayQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int dequeuedValue = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return dequeuedValue;
    }

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
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(queueArray[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}

// Test the queue
public class S9CircularQueue1 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        System.out.println("Dequeued: "+queue.dequeue());
        queue.display();

        queue.enqueue(55);
        // Attempt to enqueue in a full queue
        queue.enqueue(60);
        queue.display();

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();

        // Enqueue elements again
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.display();

        // Peek front element
        System.out.println("Front element: " + queue.peek());
    }
}

