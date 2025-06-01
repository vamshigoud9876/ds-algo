package com.decodejava.dsa.linkedlist;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {
    public boolean isPalindrome(Node head) {
        Node mid = findMiddle(head);
        Node rev = reverse(mid);
        return isMatch(head, rev);
    }
    public boolean isMatch(Node head, Node rev) {
        while(head != null && rev != null) {
            if(head.data != rev.data) return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    public Node findMiddle(Node head) {
        Node slow = head, fast = head, temp = null;
        while(fast != null && fast.next != null) { //check only till both length are same. ignoring the odd num
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        if(temp != null)
            temp.next = null;
        return slow;
    }
    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null, cur = head;
        while(cur != null) {
            Node right = cur.next;
            cur.next = prev;
            prev = cur;
            cur = right;
        }
        return prev;
    }
}
