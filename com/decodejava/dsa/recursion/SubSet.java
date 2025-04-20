package com.decodejava.dsa.recursion;

import java.util.*;

public class SubSet {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        SubSet.subSet("", "123", arr);
        System.out.println(arr);
        System.out.println(SubSet.subSet("", "abc"));
        List<Integer> up = new ArrayList<>();
        up.add(1);
        up.add(2);
        up.add(2);
        Collections.sort(up);
        System.out.println(SubSet.subSetArrNoDupRec(new ArrayList<>(), up, 0));
        System.out.println(SubSet.subSetArrItr(new int[]{1, 2, 2}));
        System.out.println(SubSet.subSetArrItrNoDup(new int[]{1, 2, 2, 3}));
    }

    //return subset of string in an array as argument.
    public static void subSet(String processed, String unprocessed, List<String> arr) {
        if (unprocessed.isEmpty()) {
            arr.add(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        subSet(processed, unprocessed.substring(1), arr);
        subSet(processed + ch, unprocessed.substring(1), arr);
    }


//   return subset of string in an array using recursion.
    private String imgRef = "com/decodejava/dsa/recursion/resources/subset_string_rec.png";
    public static List<String> subSet(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            List<String> arr = new ArrayList<>();
            arr.add(processed);
            return arr;
        }
        char ch = unprocessed.charAt(0);
        List<String> arr1 = subSet(processed, unprocessed.substring(1));
        List<String> arr2 = subSet(processed + ch, unprocessed.substring(1));
        arr1.addAll(arr2);
        return arr1;
    }


//   return subset of array elements in an array using recursion without duplicates.
    String img1 = "com/decodejava/dsa/recursion/resources/subset_no_dup_rec.png";
    String img2 = "com/decodejava/dsa/recursion/resources/subset_no_dup_rec2.png";
    public static List<List<Integer>> subSetArrNoDupRec(List<Integer> processed, List<Integer> unprocessed, int index) {
        if (unprocessed.size() <= index) {
            List<List<Integer>> arr = new ArrayList<>();
            arr.add(new ArrayList<>(processed));
            return arr;
        }
        //pick first element from the unprocessed list.
        int ele = unprocessed.get(index);

//       eg: 1, 2, 2, 2, 3
        int ind = index;// if we are to exclude 2, then exclude it for all the 2's. Since that will be handled in include next rec.
        while(ind < unprocessed.size() - 1 && unprocessed.get(ind).equals(unprocessed.get(ind + 1))) ind++;

        //exclude picked element.
        List<List<Integer>> arr1 = subSetArrNoDupRec(processed, unprocessed, ind + 1);// ind + 1 since the ind points to last dup.

        //include picked element.
        processed.add(ele);
        List<List<Integer>> arr2 = subSetArrNoDupRec(processed, unprocessed, index + 1);

        //let's backtrack since it's a list it shares reference
        // Our processed at this stack is the same that came from parent call.
        processed.remove(processed.size() - 1);

        //Add the total resultant array into one array and return it.
        arr1.addAll(arr2);
        return arr1;
    }


//   return subset of array elements in an array using loops.
    String imagePath = "com/decodejava/dsa/recursion/resources/subset_itr.png";
    public static List<List<Integer>> subSetArrItr(int[] givenArr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); //ans -> [[]];

        for (int item : givenArr) { // given arr = [1, 2, 3]; took 1
            int n = ans.size();
            //include it
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> newEle = new ArrayList<>(ans.get(i)); // created a new list from the existing nums from ans
                newEle.add(item);// Since we want to include it keeping the same list since that indicates the excluded list.
                ans.add(newEle);
            }
            //we don't do anything with excluded since, that remains as it is the ans and we add new included list to the arr
        }
        return ans;
    }


    String imgRefe = "com/decodejava/dsa/recursion/resources/subset_no_dup.png";
    public static List<List<Integer>> subSetArrItrNoDup(int[] givenArr) {//1,2,2,3
        Arrays.sort(givenArr);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int end = 0; //for empty [] in the list in the ans.
        for (int i = 0; i < givenArr.length; i++) {
            int start = 0;
            if (i > 0 && givenArr[i-1] == givenArr[i]) {// if my previous ele and current are same, then ignore the
                start = end + 1;// part from prev iteration as dup has already taken to it in the prev iteration.
            }
            end = ans.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> taking = new ArrayList<>(ans.get(j));
                taking.add(givenArr[i]);
                ans.add(taking);
            }
        }
        return ans;
     }
}
