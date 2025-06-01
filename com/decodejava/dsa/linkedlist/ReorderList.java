package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/reorder-list/
public class ReorderList {
    public void reorderList(Node head) {
        if(head == null || head.next == null) return;
        Node mid = findMid(head);
        Node rev = rev(mid);
        Node newHead = new Node(-1), newTail = newHead;
        while(head != null && rev != null) {
            newTail.next = head;
            newTail = newTail.next;
            head = head.next;

            newTail.next = rev;
            newTail = newTail.next;
            rev = rev.next;
        }
        newHead.next = null;
    }
    public Node findMid(Node head) {
        Node fast = head, slow = head, slowest = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slowest = slow;
            slow = slow.next;
        }
        if(slowest != null)
            slowest.next = null;
        return slow;

    }
    public Node rev(Node head) {
        Node prev = null, cur = head;
        while(cur != null) {
            Node right = cur.next;
            cur.next = prev;
            prev = cur;
            cur = right;
        }
        return prev;
    }
}
