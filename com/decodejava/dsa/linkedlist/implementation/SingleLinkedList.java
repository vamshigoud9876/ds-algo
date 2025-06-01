package com.decodejava.dsa.linkedlist.implementation;

public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        Node head = null;
        head = linkedList.insertLast(head, 3);
        head = linkedList.insertFirst(head, 6);
        head = linkedList.insertAt(head, 1, 1);
        head = linkedList.insertAt(head, 2, 2);
        head = linkedList.deleteAt(head, 2);
        head = linkedList.insertLastRec(head, 2);
        head = linkedList.insertAtRec(head, 4, 1);
        head = linkedList.insertAtRec(head, 5, 3);
        linkedList.display(head);
    }

    public Node insertAtRec(Node head, int data, int pos) {
        if (head == null) return new Node(data);
        if (pos == 1) {
            return new Node(data, head);
        }
        head.next = insertAtRec(head.next, data, pos - 1);
        return head;
    }

    public Node insertLastRec(Node head, int data) {
        if (head == null) return new Node(data);
        head.next = insertLastRec(head.next, data);
        return head;
    }

    public Node deleteAt(Node head, int position) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        if (position == 1) { // If 1st element
            head = head.next;
            return head;
        }
        for (int i = 1; i < position - 1; i++) { //go only till position - 1
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    public Node insertAt(Node head, int data, int position) {
        if (head == null)// list empty
            return new Node(data);
        if (position <= 1) // first node
            return insertFirst(head, data);
        Node temp = head;

//      (stop at before pos)  &&  (stop at last, if pos is last or beyond)
        while (position > 2 && temp.next != null) {
            temp = temp.next;
            position--;
        }
        if (temp.next == null) //if last Node
            return insertLast(head, data);
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public Node insertFirst(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) return newNode;
        newNode.next = (head);
        return newNode;
    }

    public Node insertLast(Node head, int data) {
        if (head == null) return new Node(data);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
