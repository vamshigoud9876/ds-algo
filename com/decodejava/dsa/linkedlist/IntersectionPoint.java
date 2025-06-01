package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionPoint {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node first = headA, second = headB;
        int len1 = 0, len2 = 0;
        while(first != null) {
            len1++;
            first = first.next;
        }
        while(second != null) {
            len2++;
            second = second.next;
        }
        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }
        while (len2 > len1) {
            headB = headB.next;
            len2--;
        }
        while(headA != null && headB !=null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
