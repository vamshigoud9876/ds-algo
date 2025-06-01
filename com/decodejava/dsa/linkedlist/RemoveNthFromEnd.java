package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head = null;
        head = sll.insertLast(head, 1);
        head = sll.insertLast(head, 2);
        head = sll.insertLast(head, 5);
        sll.display(head);
        sll.display(removeNthFromEnd(head, 3));
    }

    String ref1 = "com/decodejava/dsa/linkedlist/resources/nth_from_end.png";
    public static Node removeNthFromEnd(Node head, int n) {
        //two pointers
        //1. move n steps using first pointer.
        //2. from there keep 2nd pointer at beginning and move both at a time till 2nd reaches end.
        // -> so technically first pointer moved N-n steps.
        if(head == null)
            return null;
        Node fast = head, slow = head;
        for (int i = 1; i <= n; i++) { // we do n steps because if n was N., delete head. Then fast would go till null.
            fast = fast.next;
        }
        if (fast == null) {// if n = N(length). deleting head.
            return head.next;
        }
        while (fast.next != null) {// moving (N-n-1) technically since fast has already moved n steps.
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next; //at target node -1 th position.
        return head;
    }
}
