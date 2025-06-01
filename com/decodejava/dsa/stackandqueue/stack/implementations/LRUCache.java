package com.decodejava.dsa.stackandqueue.stack.implementations;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private final Map<Integer, Node<Pair<Integer, Integer>>> map;
    private final DoublyLinkedList<Pair<Integer, Integer>> dll;
    private final int CAPACITY;
    private int length;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        dll = new DoublyLinkedList<>();
        CAPACITY = capacity;
    }

    public int get(int key) {
        Node<Pair<Integer, Integer>> target = map.get(key);
        if (target == null) {
            return -1;
        }
        Node<Pair<Integer, Integer>> node = dll.delete(target);
        if (node == null) return -1;
        dll.insertFirst(node);
        return node.data.val;
    }

    public void put(int key, int value) {
        Node<Pair<Integer, Integer>> existing = map.get(key);
        if (existing != null) {
            existing.data.val = value;
            get(key);
            return;
        }
        Pair<Integer, Integer> newData = new Pair<>(key, value);
        if (length == CAPACITY) {
            Node<Pair<Integer, Integer>> deleted = dll.deleteLast();
            if (deleted == null) return;
            map.remove(deleted.data.key);
            deleted.data = newData;
            dll.insertFirst(deleted);
            map.put(key, deleted);
        } else {
            Node<Pair<Integer, Integer>> insertedNode = dll.insertFirst(newData);
            map.put(key, insertedNode);
            length++;
        }

    }

    private static class Pair<T1, T2> {
        T1 key;
        T2 val;
        Pair(T1 k, T2 v) {
            key = k;
            val = v;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", val=" + val +
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