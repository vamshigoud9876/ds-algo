package com.decodejava.dsa.linkedlist.reversal;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

public class LinkedListReversal {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head = null;
        head = sll.insertLast(head, 1);
        head = sll.insertLast(head, 2);
        head = sll.insertLast(head, 3);
        head = reverseItr(head);
        sll.display(head);
        head = reverseItr(head);
        head = reverseRec(head);
        sll.display(head);
    }

    String ref = "com/decodejava/dsa/linkedlist/resources/reverse_itr.png";
    public static Node reverseItr(Node head) {
        //3 pointers
        //prev  cur  right
        Node prev = null, cur = head;
        while (cur != null) {
            Node right = cur.next;
            cur.next = prev;
            prev = cur;
            cur = right;
        }
        return prev;
    }

    String ref1 = "com/decodejava/dsa/linkedlist/resources/reverse_rec.png";
    public static Node reverseRec(Node head) {
        if (head == null || head.next == null) //since return last node or if list empty
            return head;
        Node newNode = reverseRec(head.next); //the last node.
        head.next.next = head;// my next node's next is me. link shifted.
        head.next = null; // this is only for first node, first nodes next should be null, since that will be last.
        return newNode;// at every recursion stack frame, I will only return my last node.
    }
}
