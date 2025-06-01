package com.decodejava.dsa.linkedlist.reversal;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class LinkedListReversal_II {
    public Node reverseBetween(Node head, int left, int right) {
//        1 ->[ 2 -> 3 -> 4 ] -> 5 , left = 2, right = 4
//        |     |         |      |
//      first  temp      prev   cur
//      reverse until cur crosses k range. Basically this is the idea.
//      We are actually using 4 pointers to make our job done.

        Node first = null, temp = head;
        for (int i = 1; i <= left - 1; i++) {
            first = temp;
            temp = temp.next;
        }
        Node cur = temp, prev = null;
        for (int i = 1; i <= (right - left) + 1; i++) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        temp.next = cur;
        if (first != null)
            first.next = prev;
        else
            return prev; //-> new head when left is 1
        return head;
    }
}
