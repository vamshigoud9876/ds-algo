package com.decodejava.dsa.stackandqueue.stack.monotonic_stack.slidingwindow;

import java.util.ArrayDeque;

//https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {
    String img = "com/decodejava/dsa/stackandqueue/resources/sliding_window_max.png";

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - (k - 1)]; int ind = 0;
        for (int i = 0; i < n; i++) {
            //check if prev window ele exists in the deque
            if (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            //To maintain the order in decreasing order, poll elements if there exists that are lesser than cur.
            while (!deque.isEmpty()) {
                if (nums[deque.peekLast()] <= nums[i]) {
                    deque.pollLast();
                } else
                    break;
            }
            //already removed all the elements that are smaller than cur from the deque.
            //So, just insert the cur into the deque.
            deque.addLast(i);
            //we are landing at the last ele in every window to grab the ans.
            //So ignoring until we reach a window
            if (i >= k - 1) {
                ans[ind++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
