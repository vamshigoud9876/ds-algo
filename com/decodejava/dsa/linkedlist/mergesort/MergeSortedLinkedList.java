package com.decodejava.dsa.linkedlist.mergesort;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList;
import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

public class MergeSortedLinkedList {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        Node head1 = null;
        head1 = sll.insertLast(head1, 1);
        head1 = sll.insertLast(head1, 2);
        head1 = sll.insertLast(head1, 3);
        Node head2 = null;
        head2 = sll.insertLast(head2, 1);
        head2 = sll.insertLast(head2, 5);
        head2 = sll.insertLast(head2, 8);
        head2 = sll.insertLast(head2, 9);
        sll.display(head1);
        sll.display(head2);
        Node mergedHead1 = mergeTwoLists(head1, head2);
        Node mergedHead2 = mergeTwoListsRec(head1, head2);
//        sll.display(mergedHead1);
        sll.display(mergedHead2);
    }

    String ref = "com/decodejava/dsa/linkedlist/resources/merge_sorted_2lists.png";
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node newTail = null, newHead = null;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                if (newHead == null) {
                    newHead = newTail = list1;// if my new head is null ie, merged list not started.
                } else {
                    newTail.next = list1;
                    newTail = list1;
                }
                list1 = list1.next;
            } else {
                if (newHead == null) {
                    newHead = newTail = list2;
                } else {
                    newTail.next = list2;
                    newTail = list2;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            if (newHead == null)
                newHead = list1;
            else
                newTail.next = list1;
        }
        if (list2 != null) {
            if (newHead == null)
                newHead = list2;
            else
                newTail.next = list2;
        }
        return newHead;
    }


    String ref1 = "com/decodejava/dsa/linkedlist/resources/merge_sorted_2lists_rec.png";
    public static Node mergeTwoListsRec(Node list1, Node list2) {
        if (list1 == null) {
            return list2;// this also helps when list1 is exhausted then list2 is already sorted to return.
        }
        if (list2 == null) {
            return list1;// this also helps when list1 is exhausted then list2 is already sorted to return.
        }
        if (list1.data <= list2.data) {
            list1.next = mergeTwoListsRec(list1.next, list2);//before returning back link the future nodes to cur
            return list1;
        } else {
            list2.next = mergeTwoListsRec(list1, list2.next);//before returning back link the future nodes to cur
            return list2;
        }
    }
}
