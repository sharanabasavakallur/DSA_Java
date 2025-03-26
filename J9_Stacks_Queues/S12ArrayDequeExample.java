package J9_Stacks_Queues;

public class S12ArrayDequeExample {
    private int[] deque;  // Array to store elements
    private int front;    // Index of the front element
    private int rear;     // Index of the last element
    private int size;     // Current number of elements
    private int capacity; // Maximum capacity of the deque

    // Constructor to initialize the deque with a given capacity
    public S12ArrayDequeExample(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        front = -1; // Indicates the deque is empty
        rear = -1;
        size = 0;
    }

    // Add an element to the front of the deque
    public void addFront(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        if (isEmpty()) {
            front = rear = 0; // First element
        } else if (front == 0) {
            System.out.println("No Space At Front!");
            return;
        } else {//front>0 i.e, there's space behind front
            front--; // Move front backward
        }
        deque[front] = value;
        size++;
    }

    // Add an element to the rear of the deque
    public void addRear(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }
        if (isEmpty()) {
            front = rear = 0; // First element
        } else {
            rear++; // Move rear forward
        }
        deque[rear] = value;
        size++;
    }

    // Remove an element from the front of the deque
    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        int value = deque[front];
        if (front == rear) { // Deque becomes empty
            front = rear = -1;
        } else {
            front++; // Move front forward
        }
        size--;
        return value;
    }

    // Remove an element from the rear of the deque
    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        int value = deque[rear];
        if (front == rear) { // Deque becomes empty
            front = rear = -1;
        } else {
            rear--; // Move rear backward
        }
        size--;
        return value;
    }

    // Peek the front element
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        return deque[front];
    }

    // Peek the rear element
    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Queue underflow!");
            return -1;
        }
        return deque[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display all elements in the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.print("Deque elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(deque[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        S12ArrayDequeExample deque = new S12ArrayDequeExample(5);

        deque.addRear(10);
        deque.addRear(20);
        deque.addFront(5);//no place at front coz 10 is there
        deque.display(); // Output: Deque elements:10 20

        System.out.println("Remove Front: " + deque.removeFront()); // Output: 10
        deque.display(); // Output: Deque elements:20

        deque.addRear(30);
        deque.addRear(40);
        deque.display(); // Output: Deque elements:20 30 40

        System.out.println("Peek Front: " + deque.peekFront()); // Output: 20
        System.out.println("Peek Rear: " + deque.peekRear());   // Output: 40

        deque.removeRear();
        deque.display(); // Output: Deque elements: 10 20 30
    }
}

