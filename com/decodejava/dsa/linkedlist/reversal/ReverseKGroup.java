package com.decodejava.dsa.linkedlist.reversal;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/reverse-nodes-in-k-group/ -- hard
public class ReverseKGroup {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head = null;
        head = sll.insertLast(head, 1);
        head = sll.insertLast(head, 2);
        head = sll.insertLast(head, 3);
        head = sll.insertLast(head, 4);
        head = sll.insertLast(head, 5);
        head = sll.insertLast(head, 6);
        head = sll.insertLast(head, 7);
        sll.display(head);
        sll.display(reverseKGroup(head, 3));
    }

    String ref = "com/decodejava/dsa/linkedlist/resources/reverse_k_groups.png";
    public static Node reverseKGroup(Node head, int k) {
        if(head == null) return null;
        int windowSize = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            windowSize++;
        }
        if (windowSize < k) return head;
        Node cur = head, prev = null;
        for(int i = 1; i<=k; i++) {
            Node right = cur.next;
            cur.next = prev;
            prev = cur;
            cur = right;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
