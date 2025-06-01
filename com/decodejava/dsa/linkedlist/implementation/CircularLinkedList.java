package com.decodejava.dsa.linkedlist.implementation;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        Node head = null;
        head = cll.insertFirst(head, 1);
        head = cll.insertLast(head, 2);
        head = cll.insertAt(head, 99, 1);
        head = cll.insertAt(head, 100, 2);
        head = cll.deleteAt(head, 4);
        cll.display(head);
    }

    public Node deleteAt(Node head, int position) {
        if (head == null || head.next == head) return null;
        Node temp = head;
        if (position == 1) { //if 1st position
            do {
                temp = temp.next;
            } while (temp.next != head);
            temp.next = head.next;
            return temp.next;//head = start
        }
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp.next == head) break;
        }
        if (temp.next != head) {//between position
            temp.next = temp.next.next;
        }
        return head;
    }

    public Node insertAt(Node head, int data, int position) {
        if (position == 1) {
            return insertFirst(head, data);
        }
        Node temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp.next == head) break;
        }
        temp.next = new Node(data, temp.next);
        return head;

    }

    public Node insertFirst(Node head, int data) {
        if (head == null) {
            return insertLast(head, data);
        }
        Node tempLast = head;
        do {
            tempLast = tempLast.next;
        } while (tempLast.next != head);
        tempLast.next = new Node(data, head);
        head = tempLast.next;
        return head;
    }

    public void display(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
    }

    public Node insertLast(Node head, int data) {
        if (head == null) {
            head = new Node(data);
            head.next = head;
            return head;
        }
        Node temp = head;
        do {
            temp = temp.next;
        } while (temp.next != head);

        temp.next = new Node(data, head);
        return head;
    }
}
