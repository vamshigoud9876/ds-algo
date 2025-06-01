package com.decodejava.dsa.linkedlist.cycle;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

public class CycleDetection {
    public boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { // checking for fast is enough since fast is ahead
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
