package com.decodejava.dsa.arrays.dutchnationalflag;

import java.util.Arrays;

public class Sort3Colors {

    public static void sort(int[] arr, int n) {
        System.out.println("Original Arr : " + Arrays.toString(arr));
//        Arrays.sort(arr);  -> O(nlogn) -> Merge Sort
//        counters3Algo(arr, n);   -> O(2N) -> 2 passes
        dutchNationalFlagAlgo(arr, n);  // O(N) -> single pass most optimal
    }

    /**
     * Time Complexity: O(n) -> Single pass
     * Space: O(1)
     */
    private static void dutchNationalFlagAlgo(int[] arr, int n) {
        //                                   Algorithm
        //--------------------------------------------------------------------------------------
        //Dutch National Flag Algorithm. Since Dutch flag has only 3 colors this was named as such.
        // 0,0,0,0,0     1, 1 ,1, 1     0, 1, 2, 0    2, 2, 2, 2
        // 0...low-1     low...mid-1    mid...high    high+1...n-1

        // from mid to high we will have unsorted elements.
        // now we will traverse from mid to high and swap the elements to make this sorted

        // Note ::  (We will not traverse actually but the mid always points to unsorted element and will do operation with mid-element only.
        // At the end we will do these operations until mid and high are equal which means we have 1 unsorted element which also has to be fixed.)
        //
        // Case 1:
        // if a[mid] == 0, technically it has to be in (0 -> low-1).
        // if I swap it with low then it looks ->
        //                         swapped
        //                    /              \
        //     0,0,0,0,0     0, 1 ,1, 1      1, 1, 2, 0    2, 2, 2, 2
        //     0...low-1     low...mid-1     mid...high    high+1...n-1
        //
        //      low++ and mid++;
        //      now if I do low++ and mid++ then it looks -> now this looks sorted and we are in the same diagram
        //
        //     0,0,0,0,0, (0)      1 ,1, 1, ( 1)     1, 2, 0        2, 2, 2, 2
        //     0.........low-1    low......mid-1     mid...high    high+1...n-1
        //
        //      so that's how we reduced the unsorted part.
        //      So basically we try to fit the element in its crt position and reduce the unsorted part
        //
        //      case 2:
        //------------------
        //   if a[mid] == 1, technically it has to be in (low -> mid-1).
        //   So, If I just increment mid -> ie., mid++;

        //     0,0,0,0,0,0         1 ,1, 1, 1, ( 1)        2, 0        2, 2, 2, 2
        //     0.........low-1    low..........mid-1     mid...high    high+1...n-1
        //
        //      this looks perfect as the original figure.
        //      So, we again reduced the unsorted part.
        //
        //          case 3:
        //------------------
        //   if a[mid] == 2, technically it has to be in (high+1 -> N-1).
        //   Basically we want to reduce the unsorted part. So If I swap it with high then it looks ->
        //
        //     0,0,0,0,0,0         1 ,1, 1, 1, 1          0, (2)        2, 2, 2, 2
        //     0.........low-1    low..........mid-1     mid...high    high+1...n-1
        //
        //      So, we are putting it at the last. As that is also a crt position to make the diagram identical
        //
        //      high--;
        //      Now, If I just decrement high ->
        //
        //     0,0,0,0,0,0         1 ,1, 1, 1,  1        0,            (2), 2, 2, 2, 2
        //     0.........low-1    low..........mid-1     mid...high    high+1...n-1
        //
        //      Now we are only left with 0 and that falls under case (i) that we will replace it low and increment low++ ->
        //
        //     0,0,0,0,0,0, (0)         1 ,1, 1, 1, 1        ,              2, 2, 2, 2, 2
        //     0.........low-1        low..........mid-1     mid...high    high+1...n-1


        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++; mid++;
            } else if (arr[mid] == 1) mid++;
            else if (arr[mid] == 2) {
               int temp = arr[mid];
               arr[mid] = arr[high];
               arr[high] = temp;
               high--;
            }
        }
    }

    private static void counters3Algo(int[] arr, int n) {
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) zero++;
            else if (arr[i] == 1) one++;
            else if (arr[i] == 2) two++;
        }
        int index = 0;
       while(zero-- != 0) {
           arr[index++] = 0;
       }
       while(one-- != 0) {
           arr[index++] = 1;
       }
       while(two-- != 0) {
           arr[index++] = 2;
       }
    }
}
