package com.decodejava.dsa.linkedlist.mergesort;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/sort-list/
public class SortList {
    public Node sortList(Node head) {
        return mergeSort(head);
    }
    public Node mergeSort(Node start) {
        if(start == null || start.next == null) {
            return start;
        }
        Node mid = findMid(start);
        Node rightStart = mid.next;
        mid.next = null;
        Node list1 = mergeSort(start);
        Node list2 = mergeSort(rightStart);
        return merge(list1, list2);
    }
    public Node merge(Node list1, Node list2) {
        Node newHead = null, newTail = newHead;
        while (list1 != null && list2 != null) {
            if(list1.data <= list2.data) {
                if(newHead == null) {
                    newHead = list1;
                } else {
                    newTail.next = list1;
                }
                newTail = list1;
                list1 = list1.next;
            }
            else {
                if(newHead == null) {
                    newHead = list2;
                } else {
                    newTail.next = list2;
                }
                newTail = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            if(newHead == null) {
                newHead = list1;
            } else {
                newTail.next = list1;
            }
        }
        if (list2 != null) {
            if(newHead == null) {
                newHead = list2;
            } else {
                newTail.next = list2;
            }
        }
        return newHead;
    }
    public Node findMid(Node start) {
        Node slow = start, s= slow, fast = start;
        while(fast != null && fast.next != null) {
            s = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return s;
    }
}
