package com.decodejava.dsa.linkedlist.mergesort;

import com.decodejava.dsa.linkedlist.implementation.SingleLinkedList.Node;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedLinkedLists {
    public Node mergeKLists(Node[] lists) {
        Node merged = null;
        for (Node list : lists) {
            merged = MergeSortedLinkedList.mergeTwoListsRec(merged, list);
        }
        return merged;
    }
    public Node divideAndConquer(Node[] lists, int left, int right) {
//        Time complexity is NlogK, where k length of arr lists. n is the total number of elements in all the lls.
//        but how??

//        Similar to merge sort algorithm the lists is divided into log k steps every time.
//        At every step approximately we are comparing and fixing n elements.
        int mid = left + (right - left) / 2;
        Node list1 = divideAndConquer(lists, left, mid);
        Node list2 = divideAndConquer(lists, left, mid + 1);
        return MergeSortedLinkedList.mergeTwoLists(list1, list2);
    }

    //                                      divide(0, 3)                            -> n elements
    //                                         |
    //                            ---------------------------
    //                           |                           |
    //                    divide(0, 1)                 divide(2, 3)                 -> n elements
    //                       |                             |
    //                   ------------                 ------------
    //                  |            |               |            |
    //              divide(0, 0)  divide(1, 1)    divide(2, 2)   divide(3, 3)       -> n elements
    //                  |            |               |            |
    //                list[0]     list[1]          list[2]       list[3]

    //                                                                                log K times, so NlogK


    //                                  divide(0, 7)
    //                                     |
    //                       ---------------------------------
    //                      |                                 |
    //               divide(0, 3)                        divide(4, 7)
    //                   |                                    |
    //             ---------------                        ---------------
    //            |               |                      |               |
    //       divide(0, 1)    divide(2, 3)         divide(4, 5)       divide(6, 7)
    //            |               |                      |               |
    //         ---------      ---------             ---------        ---------
    //        |         |    |         |           |         |      |         |
    // divide(0, 0) divide(1, 1) divide(2, 2) divide(3, 3) divide(4, 4) divide(5, 5)  divide(6, 6) divide(7, 7)
    //  |           |         |         |         |         |        |          |
    //list[0]     list[1]   list[2]   list[3]   list[4]   list[5]   list[6]   list[7]
}
