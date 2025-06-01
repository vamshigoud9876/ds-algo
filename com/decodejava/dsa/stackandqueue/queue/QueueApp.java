package com.decodejava.dsa.stackandqueue.queue;

public class QueueApp {
    public static void main(String[] args) {

        // Simple Queue Implementation
        CustomQueue queue = new CustomQueue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll()); // O(n) to remove an ele
        System.out.println(queue.poll()); // O(n) to remove an ele

        // Circular Queue Implementation
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.add(1);
        circularQueue.add(2);
        circularQueue.display();
        circularQueue.add(3);
        circularQueue.display();
        circularQueue.poll();
        circularQueue.display();
    }

}
