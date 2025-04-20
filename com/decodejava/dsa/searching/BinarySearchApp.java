package com.decodejava.dsa.searching;

public class BinarySearchApp {
    public static void main(String[] args) {
        BinarySearchApp binarySearchApp = new BinarySearchApp();

        int[] a1 = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(searchImpl(a1, 6));

        // 744. Find Smallest Letter Greater Than Target (Easy)
        // https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
        char[] charArr1 = {'c', 'f', 'j'};
        System.out.println(binarySearchApp.nextGreatestLetter(charArr1, 'f'));

//        System.out.println(peakIndexInMountainArray(arr));

        // 4. Median of Two Sorted Arrays (Hard)
        // https://leetcode.com/problems/median-of-two-sorted-arrays
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(binarySearchApp.findMedianSortedArrays(arr1, arr2));


        // 162. Find Peak Element (Medium)
        // https://leetcode.com/problems/find-peak-element
        int[] arr = {1,2,1,3,5,6,4}; //element which is strictly greater than its neighbors
        System.out.println("162. Find Peak Element " + binarySearchApp.findPeakElement(arr));

    }

    /**
     *
     * @param arr
     * @param target
     * @return Returns the
     */
    public static int searchImpl(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (target < arr[middle]) {
                j = middle - 1;
            } else {
                i = middle + 1;
            }
        }
        return -1;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target < letters[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return letters[start % letters.length];
    }

    public static int findTargetInfiniteArray(int[] arr, int target) {

        //step 1: fix ur window
        //2: compare the target with the element at end
        //3: if target is greater increase the size of the window by doubling.
        //          how to increase the size of the window?
        //          multiply the end index
        //4: continue until the target is less than the size of the element at end.
        //5: now apply BinarySearch to this window.

        int[] range =  getRange(arr, target);
        return binarySearchInf(arr, target, range[0], range[1]);
    }

    private static int[] getRange(int[] arr, int target) {
        int start = 0, end = 1;
        while (target > arr[end]) {
            start = end + 1;
            end = end * 2;
        }
        return new int[]{start, end};
    }

    private static int binarySearchInf(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (target < arr[middle]) {
                end = middle - 1;
            } else if (target > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1; int ans = -1;
        while(start <= end) {
            int middle = start + (end - start) / 2;
            if (middle + 1 < arr.length && arr[middle] > arr[middle + 1]) {
                if (middle > ans) {
                    ans = middle;
                }
                end = middle - 1;
            } else if (middle + 1 < arr.length && arr[middle] < arr[middle + 1]) {
                start = middle + 1;
            }
        }
        return ans;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        //for me to always use the smallest sorted array to draw the symmetry.
        //Always nums1 should have less number of elements or equal. So->
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int start = 0, end = n1 ;
        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int l1 = Integer.MIN_VALUE, l2 = l1;
            int r1 = Integer.MAX_VALUE, r2 = r1;
            int mid2 = ((n1 + n2 + 1) /2 ) - mid1 ;
            if (mid1 > 0) l1 = nums1[mid1 - 1];
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 > 0 && mid2 <= n2) l2 = nums2[mid2 - 1];
            else if(mid2 > n2) l2 = nums2[n2 - 1];
            if (mid2 < n2) r2 = nums2[mid2];

            if (l1 > r2 ) end = mid1 - 1;
            else if (l2 > r1) start = mid1 + 1;
            else {
                if ((n1 + n2) % 2 == 0 ) {
                    {
                        return (double) (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2.0;
                    }
                } else return (double) Integer.max(l1, l2);
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            //always move towards the greatest element side.
            //because we have to find the peak, if current it low and next is high then there is chance the there would be a dip so the highest becomes peak.
            //else the last element would be the peak.
            if (mid > start && nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else if(mid < end && nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public int findPeakInRotatedArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid+1]) return mid;
            else if (arr[start] > arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }

}
