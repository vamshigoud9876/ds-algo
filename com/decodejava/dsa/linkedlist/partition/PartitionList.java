package com.decodejava.dsa.linkedlist.partition;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://www.geeksforgeeks.org/problems/partition-a-linked-list-around-a-given-value/1
public class PartitionList {

    public Node partition(Node head, int x) {
        //pivot it.
        //collect all the lesser elements and equal elements and greater elements separately to maintain the order.
        //create the dummy nodes they will be helpful, ;)
        Node lesserHead = new Node(-1), lesserTail = lesserHead;
        Node equalHead = new Node(-1), equalTail = equalHead;
        Node greaterHead = new Node(-1), greaterTail = greaterHead;

        Node temp = head;
        while (temp != null) {
            if (temp.data < x) {
                lesserTail.next = temp;
                lesserTail = lesserTail.next;
            } else if (temp.data == x) {
                equalTail.next = temp;
                equalTail = equalTail.next;
            } else {
                greaterTail.next = temp;
                greaterTail = greaterTail.next;
            }
            temp = temp.next;
        }

        //this order is mandatory. we have arranged the heads and tails in such a way that if any of the tail is null then its handled.
        //this should be null anyways.
        //if no greaters then greaterhead.next is also null ;)
        greaterTail.next = null;

        equalTail.next = greaterHead.next;///if no greaters then greaterhead.next is also null ;)
        /// if no equals then equalsHead is greatersHead ;)

        lesserTail.next = equalHead.next;///if no equals then equalsHead is greatersHead ;)

        return lesserHead.next; //at the end this makes everything sorted ;)
    }
}
