package com.decodejava.dsa.stackandqueue.queue;

public class CircularQueue {
    private final int[] arr;
    private int start;
    private int end;
    private static final int DEFAULT_SIZE = 10;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        arr = new int[size];
        start = -1;
        end = -1;
    }

    public void add(int ele) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (isEmpty()) {
            start = 0;
        }
        end = (end + 1) % arr.length;
        arr[end] = ele;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        int ele = arr[start];
        if (start == end) {
            start = end = -1;
        } else {
            start = (start + 1) % arr.length;
        }
        return ele;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }
        return arr[start];
    }

    public boolean isFull() {
        return (end + 1) % arr.length == start;
    }

    private boolean isEmpty() {
        return start == -1 && end == -1;
    }

    public void display() {
        for (int i = start; !isEmpty() && i <= end ; i = (i + 1) % arr.length){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
