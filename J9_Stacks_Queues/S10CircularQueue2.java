package J9_Stacks_Queues;

// Node class for linked list
//class Node {
//    int data;
//    Node next;
//
//    Node(int data) {
//        this.data = data;
//        next = null;
//    }
//}
//commented coz of duplicate class i.e, Node class already exists in current package

// Circular Queue class
class CircularQueue {
    private Node front; // Points to the front of the queue
    private Node rear;  // Points to the rear of the queue

    // Constructor
    public CircularQueue() {
        front = null;
        rear = null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (front == null) { // If the queue is empty
            front = rear = newNode;
            rear.next = front; // Point the last node to the first node
        } else {
            rear.next = newNode; // Add the new node at the end
            rear = newNode;      // Update the rear pointer for next enqueue call
            rear.next = front;   // Maintain circularity
        }
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot remove element.");
            return -1;
        }
        int dequeuedValue = front.data;
        if (front == rear) { // If there's only one element
            front = rear = null;
        } else {
            front = front.next; // Move the front pointer to the next node
            rear.next = front;  // Maintain circularity
        }
        return dequeuedValue;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Circular Queue: ");
        Node temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}

// Test the Circular Queue
public class S10CircularQueue2 {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.display();

        // Peek at the front
        System.out.println("Peek: " + queue.peek());

        // Enqueue more elements
        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

        // Dequeue all elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Attempt to dequeue from an empty queue
        System.out.println("Dequeued: " + queue.dequeue());
    }
}

