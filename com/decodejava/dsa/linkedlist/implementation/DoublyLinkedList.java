package com.decodejava.dsa.linkedlist.implementation;

public class DoublyLinkedList<T> {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        Node<Integer> head = null;
        head = dll.insertFirst(head, 1);
        head = dll.insertLast(head, 2);
        head = dll.insertAt(head, 3, 7);
        head = dll.insertAt(head, 4, 7);
        head = dll.insertAt(head, 5, 7);
        head = dll.insertAt(head, 6, 7);
        head = dll.insertAt(head, 7, 7);
        head = dll.deleteAt(head, 1);
        dll.display(head);
    }

    public Node<Integer> deleteAt(Node<Integer> head, int position) {
        if (head == null || head.next == null)
            return null;
        Node<Integer> temp = head;
        for (int i = 1; i < position && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.prev == null) {//if first position
            head = head.next;
            head.prev = null;
            return head;
        }
        if (temp.next == null) {//if last position
            temp.prev.next = null;
            return head;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        return head;
    }

    public Node<T> insertAt(Node<T> head, T data, int position) {
        if (position == 1) {
            return insertFirst(head, data);
        }
        Node<T> temp = head;
        for (int i = 1; i < position && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            return insertLast(head, data);
        }
        Node<T> newNode = new Node<>(temp.prev, data, temp);
        temp.prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    public Node<T> insertLast(Node<T> head, T data) {
        if (head == null)
            return new Node<>(data);
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(data);
        temp.next.prev = temp;
        return head;
    }

    public Node<T> insertFirst(Node<T> head, T data) {
        if (head == null) return new Node<>(data);
        Node<T> newNode = new Node<>(null, data, head);
        head.prev = newNode;
        return newNode;
    }

    public void display(Node<Integer> head) {
        Node<Integer> temp = head, backTemp = temp;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            if(temp.next == null) //case for last node
                backTemp = temp;
            temp = temp.next;
        }
        System.out.println();
        while (backTemp != null) {
            System.out.print(backTemp.data);
            backTemp = backTemp.prev;
            if (backTemp != null)
                System.out.print(" -> ");
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
    }
}

