package J9_Stacks_Queues;

//using only one pointer i.e, rear (not front and rear both)
public class S11DynamicQueueExample {
    private int[] queue; // Array to store elements
    private int rear;    // Points to the next insertion point
    private int size;    // Number of elements in the queue

    // Constructor to initialize the queue with a default size
    public S11DynamicQueueExample(int capacity) {
        queue = new int[capacity];
        rear = 0;
        size = 0;
    }

    // Enqueue operation to add an element at the rear
    public void enqueue(int value) {
        // Resize if the queue is full
        if (size == queue.length) {
            resize();
        }
        queue[rear] = value; // Add the value at the rear position
        rear++;             // Move rear forward
        size++;
    }

    // Dequeue operation to remove the first element
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedValue = queue[0]; // Always remove the first element
        // Shift all elements to the left
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--; // Adjust rear after shifting
        size--;
        return removedValue;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Resize the array to double its current capacity
    private void resize() {
        int newCapacity = queue.length * 2;
        int[] newQueue = new int[newCapacity];

        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[i];
        }

        queue = newQueue; // Replace old array with new one
    }

    // Peek operation to view the first element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return queue[0]; // Always the first element
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        S11DynamicQueueExample dq = new S11DynamicQueueExample(3);

        dq.enqueue(10);
        dq.enqueue(20);
        dq.enqueue(30);

        dq.display(); // Output: Queue elements: 10 20 30

        dq.enqueue(40);
        dq.display(); // Output: Queue elements: 10 20 30 40

        System.out.println("Dequeue: " + dq.dequeue()); // Output: Dequeue: 10
        dq.display(); // Output: Queue elements: 20 30 40

        dq.enqueue(50);
        dq.enqueue(60);

        dq.display(); // Output: Queue elements: 20 30 40 50 60

        while (!dq.isEmpty()) {
            System.out.println("Dequeue: " + dq.dequeue());
        }

        dq.display(); // Output: Queue is empty
    }
}

