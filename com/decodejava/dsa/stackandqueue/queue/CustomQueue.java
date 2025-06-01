package com.decodejava.dsa.stackandqueue.queue;

public class CustomQueue {
    private final int[] arr;
    private int end;
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        arr = new int[size];
        end = -1;
    }

    public void add(int ele) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        arr[++end] = ele;
    }

    public int poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue empty");
        }
        //delete first ele
        //move every element towards left by 1
        int ele = arr[0];
        for (int i = 1; i <= end; i++) {
            arr[i - 1] = arr[i];
        }

        end--;
        return ele;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }
        return arr[0];
    }

    public boolean isFull() {
        return end == arr.length - 1;
    }

    private boolean isEmpty() {
        return end == -1;
    }
}
