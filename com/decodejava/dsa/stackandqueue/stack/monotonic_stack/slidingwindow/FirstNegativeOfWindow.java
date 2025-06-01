package com.decodejava.dsa.stackandqueue.stack.monotonic_stack.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//First negative in every window of size k
//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeOfWindow {
    static List<Integer> firstNegInt(int nums[], int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>(n - (k - 1));
        for (int i = 0; i < n; i++) {
            //check if prev window ele exists in the deque
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            //if negative then only add into the queue
            if(nums[i] < 0)
                deque.addLast(i);

            if (i >= k - 1) {
                if(!deque.isEmpty() && nums[deque.peekFirst()] < 0)
                    ans.add(nums[deque.peekFirst()]);
                else
                    ans.add(0);
            }
        }
        return ans;

    }
}
