package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicates_II {

    public Node deleteDuplicates(Node head) {
//        basically we while bottom approach
        if (head == null || head.next == null) {
            return head;
        }
        boolean isCurDup = false;
        while(head.next != null && head.data == head.next.data) {// if last ele is dup then null is nextNonDup
            head = head.next;
            isCurDup = true;
        }
        Node nextNonDup = deleteDuplicates(head.next);
        if (isCurDup)
            return nextNonDup;//my prev node's next Iam setting to next non dup
        else {// is cur is non dup, consider my cur non dup node.
            head.next = nextNonDup;
            return head;
        }
    }
}
