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

// Queue class
class LinkedListQueue {
    private Node front; // Points to the front of the queue
    private Node rear;  // Points to the rear of the queue

    // Constructor
    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear == null) { // If the queue is empty
            front = rear = newNode;
            return;
        }
        rear.next = newNode; // Link the new node at the end of the queue
        rear = newNode;      // Update the rear pointer and keep front as it is
    }
    //The queue grows and shrinks dynamically, so there’s no fixed size or wasted space.

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot remove element.");
            return -1;
        }
        int dequeuedValue = front.data;
        front = front.next; // Move the front pointer to the next node

        if (front == null) { // If the queue becomes empty
            rear = null;
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
        System.out.print("Queue: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Test the Linked List Queue
public class S8LinkedListQueueExample {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

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

