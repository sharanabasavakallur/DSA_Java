package J9_Stacks_Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
A Deque (Double-Ended Queue) is a linear data structure that allows insertion and deletion of elements from both ends, i.e.,
from the front and rear. It is part of the Java Collections Framework and is implemented using the Deque interface in java.util.

Key Features of Deque:
Bidirectional Operations:
Insertions and deletions can happen at both ends (front and rear).
Flexible Queue Operations:
Can act as both a queue (FIFO) and a stack (LIFO).
Implemented Classes:
ArrayDeque
LinkedList
*/
public class S3Basics {
    public static void main(String[] args) {
        //using ArrayDeque class
        Deque<Integer> deque = new ArrayDeque<>();

        // Adding elements to the deque
        deque.addFirst(10); // Adds 10 at the front
        deque.addLast(20);  // Adds 20 at the rear
        deque.offerFirst(5); // Adds 5 at the front
        deque.offerLast(30); // Adds 30 at the rear

        System.out.println("Deque: " + deque);

        // Accessing elements
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());

        // Removing elements
        System.out.println("Removed from front: " + deque.removeFirst());
        System.out.println("Removed from rear: " + deque.removeLast());

        System.out.println("Deque after removals: " + deque);


        //using LinkedList class
        Deque<String> deque2 = new LinkedList<>();

        // Adding elements to the deque
        deque2.addFirst("Front");
        deque2.addLast("Rear");

        System.out.println("Deque: " + deque2);

        // Accessing elements
        System.out.println("Peek First: " + deque2.peekFirst());
        System.out.println("Peek Last: " + deque2.peekLast());

        // Removing elements
        System.out.println("Poll First: " + deque2.pollFirst());
        System.out.println("Poll Last: " + deque2.pollLast());

        System.out.println("Deque after operations: " + deque2);
    }
}
