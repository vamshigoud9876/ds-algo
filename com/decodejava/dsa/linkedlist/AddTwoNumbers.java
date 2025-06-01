package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {
    //childhood maths addition carrying
    public Node addTwoNumbers(Node l1, Node l2) {
        int carry = 0;
        Node dummy = new Node(-1), head = dummy;
        while ((l1 != null || l2 != null) || carry != 0) {
            int sum = ((l1 == null) ? 0 : l1.data) + ((l2 == null) ? 0 : l2.data) + carry;
            dummy.next = new Node(sum % 10);
            carry = sum / 10 ;
            dummy = dummy.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return head.next;

    }
}
