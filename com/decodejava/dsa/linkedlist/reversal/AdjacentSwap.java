package com.decodejava.dsa.linkedlist.reversal;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class AdjacentSwap {
    String ref = "com/decodejava/dsa/linkedlist/resources/adj_swap.png";
    public Node swapPairs(Node head) {
        if(head == null || head.next ==  null) {
            return head;
        }
        Node right = head.next;
        head.next = swapPairs(right.next);
        right.next = head;
        return right;
    }
}
