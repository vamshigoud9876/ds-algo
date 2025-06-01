package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicates {
    public Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.data == head.next.data) return head.next;
        else return head;
    }
}
