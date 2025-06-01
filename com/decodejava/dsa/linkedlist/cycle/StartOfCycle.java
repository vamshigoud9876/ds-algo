package com.decodejava.dsa.linkedlist.cycle;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class StartOfCycle {
    public Node detectCycle(Node head) {
        if (head == null || head.next == null)
            return null;
        Node fast = head, slow = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow && fast != null && fast.next != null);

        if (slow != fast)
            return null;

        int len = 0;
        do {
            len++;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        slow = head;

        while (len-- != 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
