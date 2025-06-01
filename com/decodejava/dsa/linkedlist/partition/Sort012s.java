package com.decodejava.dsa.linkedlist.partition;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

public class Sort012s {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head = null;
        head = sll.insertLast(head, 1);
        head = sll.insertLast(head, 2);
        head = sll.insertLast(head, 0);
        head = sll.insertLast(head, 0);
        head = sll.insertLast(head, 1);
        sll.display(head);
        head = sort(head);
        sll.display(head);
    }

    public static Node sort(Node head) {
        //pivot it.
        //collect 0's 1's 2's to the separate heads respectively.
        //create the dummy nodes they will be helpful, ;)
        Node zeroHead = new Node(-1), zeroTail = zeroHead;
        Node oneHead = new Node(-1), oneTail = oneHead;
        Node twoHead = new Node(-1), twoTail = twoHead;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }

        twoTail.next = null;

        oneTail.next = twoHead.next;

        zeroTail.next = oneHead.next;

        return zeroHead.next;
    }
}
