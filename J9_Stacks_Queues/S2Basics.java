package J9_Stacks_Queues;

import java.util.LinkedList;
import java.util.Queue;

/*
A Queue is a data structure that follows the FIFO (First In, First Out) principle.
The first element added to the queue is the first one to be removed.
Key Features of Queue:
Insertion happens at the rear (end).
Removal happens at the front (start).
Used in scenarios like:
Scheduling tasks (e.g., CPU scheduling).
Handling requests in web servers.
Operations:
Enqueue: Add an element to the rear.
Dequeue: Remove an element from the front.
Peek: View the front element without removing it.
isEmpty: Check if the queue is empty.
*/
public class S2Basics {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        /*
        1. Before =: Queue<Integer> queue
        Declares the reference variable named queue.
        Specifies that this variable will hold an object that implements the Queue interface and stores Integer objects.
        The reference is of type Queue, allowing you to work with any implementation of the Queue interface,
        such as LinkedList or PriorityQueue.
        2. After =: new LinkedList<>()
        Instantiates a specific implementation of the Queue interface.
        Creates a LinkedList object in memory and assigns its reference to the queue variable.
        LinkedList implements the Queue interface, so this assignment is valid.
        */

        // Add elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Queue: " + queue);

        // Peek at the front element
        System.out.println("Front element: " + queue.peek());

        // Remove an element from the queue
        System.out.println("Dequeued element: " + queue.remove());
        System.out.println("Queue after dequeue: " + queue);

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
