package com.decodejava.dsa.linkedlist;


import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/rotate-list/
public class RotateList {

    public Node rotateRight(Node head, int k) {
        if(head == null || head.next == null)return head;
        Node last = head, first = head;
        int len = findLen(head);
        k = k % len;
        for(int i=1; i <= len - k ;i++) {
            last = first;
            first = first.next;
        }
        if (first == null) return head;
        last.next = null;

        Node firstEnd = first;
        while(firstEnd.next != null) {
            firstEnd = firstEnd.next;
        }
        firstEnd.next = head;
        return first;
    }

    public int findLen(Node head) {
        if (head == null) return 0;
        return findLen(head.next) + 1;
    }
}
