package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeleteMiddle {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head = null;
        head = sll.insertLast(head, 1);
        head = sll.insertLast(head, 2);
        head = sll.insertLast(head, 3);
        sll.display(head);
        head = deleteMiddle(head);
        sll.display(head);
    }

    public static Node deleteMiddle(Node head) {
        Node fast = head, slow = head, slowest = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slowest = slow;
            slow = slow.next;
        }
        if(slowest == null) return null;
        slowest.next = slow.next;
        return head;
    }
}
