package com.decodejava.dsa.stackandqueue.stack.implementations;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lfu-cache/
public class LFUCache {
String img = "com/decodejava/dsa/stackandqueue/resources/lfu.png";

    private final Map<Integer, Node<Triple<Integer, Integer, Integer>>> map;
    private final Map<Integer, DoublyLinkedList<Triple<Integer, Integer, Integer>>> listMap;
    private final int CAPACITY;
    private int length;
    private int lowFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        listMap = new HashMap<>();
        CAPACITY = capacity;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public int get(int key) {
        Node<Triple<Integer, Integer, Integer>> existingNode = map.get(key);
        if (existingNode == null) return -1;
        DoublyLinkedList<Triple<Integer, Integer, Integer>> curList = listMap.get(existingNode.data.freq);
        curList.delete(existingNode);
        if (curList.isEmpty()) {
            listMap.remove(existingNode.data.freq);
            if (lowFreq == existingNode.data.freq) {
                lowFreq++;
            }
        }
        existingNode.data.freq++;
        if (listMap.containsKey(existingNode.data.freq)) {
            listMap.get(existingNode.data.freq).insertFirst(existingNode);
        } else {
            DoublyLinkedList<Triple<Integer, Integer, Integer>> newList = new DoublyLinkedList<>();
            newList.insertFirst(existingNode);
            listMap.put(existingNode.data.freq, newList);
        }
        return existingNode.data.val;
    }

    public void put(int key, int value) {
        //3 cases:
        //1. if data exists.
        //2. new data size full
        //3. new data size available

        //case 1. data exists
        if (map.containsKey(key)) {
            Node<Triple<Integer, Integer, Integer>> existing = map.get(key);
            //update value, since data exists
            existing.data.val = value;
            //delete from cur list
            DoublyLinkedList<Triple<Integer, Integer, Integer>> curList = listMap.get(existing.data.freq);
            curList.delete(existing);
            if (curList.isEmpty()) { //if cur list becomes empty we don't need that list and update lowFreq.
                listMap.remove(existing.data.freq);
                if (lowFreq == existing.data.freq) {
                    lowFreq++;
                }
            }
            //now update the freq on the node.
            existing.data.freq++;
            //if the map already contains the next freq list just insert in it.
            if (listMap.containsKey(existing.data.freq)) {
                DoublyLinkedList<Triple<Integer, Integer, Integer>> nextList = listMap.get(existing.data.freq);
                nextList.insertFirst(existing);
            } else { // else create new list with the new frequency
                DoublyLinkedList<Triple<Integer, Integer, Integer>> newList = new DoublyLinkedList<>();
                newList.insertFirst(existing);
                listMap.put(existing.data.freq, newList);
            }
            return;
        }

        //case 2: Size full

        if (length == CAPACITY) {
            //if size is full then delete from lowFreq and add this element at freq = 1.
            DoublyLinkedList<Triple<Integer, Integer, Integer>> lowFreqList = listMap.get(lowFreq);
            Node<Triple<Integer, Integer, Integer>> leastRecentlyUsedNode = lowFreqList.deleteLast();
            if (lowFreqList.isEmpty()) {
                listMap.remove(lowFreq);
            }
            int lruKey = leastRecentlyUsedNode.data.key;
            map.remove(lruKey);
            map.put(key, leastRecentlyUsedNode);
            //update the with new data;
            leastRecentlyUsedNode.data.key = key;
            leastRecentlyUsedNode.data.val = value;
            leastRecentlyUsedNode.data.freq = 1;
            if (listMap.containsKey(1)) {
                listMap.get(1).insertFirst(leastRecentlyUsedNode);
            } else {
                DoublyLinkedList<Triple<Integer, Integer, Integer>> newListWith1 = new DoublyLinkedList<>();
                newListWith1.insertFirst(leastRecentlyUsedNode);
                listMap.put(1, newListWith1);
            }
            lowFreq = 1;
            return;
        }


        //case 3: size available
        //insert at freq 1, since new data.

        Node<Triple<Integer, Integer, Integer>> newNode = new Node<>(new Triple<>(key, value, 1));
        if (listMap.containsKey(1)) {
            listMap.get(1).insertFirst(newNode);
        } else {
            DoublyLinkedList<Triple<Integer, Integer, Integer>> newList = new DoublyLinkedList<>();
            newList.insertFirst(newNode);
            listMap.put(1, newList);
        }
        map.put(key, newNode);
        length++;
        lowFreq = 1;
    }

    private static class Triple<T1, T2, T3> {
        T1 key;
        T2 val;
        T3 freq;
        Triple(T1 k, T2 v, T3 f) {
            key = k;
            val = v;
            freq = f;
        }

        @Override
        public String toString() {
            return "Triple{" +
                    "key=" + key +
                    ", val=" + val +
                    ", freq=" + freq +
                    '}';
        }
    }

    private static class DoublyLinkedList<T> {
        Node<T> head;
        Node<T> tail;
        public DoublyLinkedList() {
            head = new Node<>(null, null, null);
            tail = new Node<>(null, null, null);
            head.next = tail;
            tail.prev = head;
        }
        public Node<T> insertFirst(T data) {
            Node<T> node = new Node<>(head, data, head.next);
            head.next.prev = node;
            head.next = node;
            return head.next;
        }

        public void insertFirst(Node<T> node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        public void insertLast(T data) {
            Node<T> node = new Node<>(tail.prev, data, tail);
            tail.prev.next = node;
            tail.prev = node;
        }

        public Node<T> deleteLast() {
            if (tail.prev == head) return null;
            Node<T> deleted =  tail.prev;
            deleted.prev.next = tail;
            tail.prev = deleted.prev;
            return deleted;
        }

        public Node<T> delete(Node<T> node) {
            if (tail.prev == head) return null;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }
    }
    public static class Node<T> {
        Node<T> prev;
        T data;
        Node<T> next;

        public Node(Node<T> prev, T data, Node<T> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
