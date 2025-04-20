package com.decodejava.dsa.recursion.permutation;

import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //todo
        return null;
    }
    private void permute(LinkedList<Integer> processed, int[] unprocessed, int index, List<List<Integer>> ans) {
        if (index == unprocessed.length) {
            List<Integer> temp = new LinkedList<>(processed);
            ans.add(temp);
            return;
        }
        int ele = unprocessed[index];

        for (int i = 0; i <= processed.size(); i++) {// processed size + 1 chances to put ele

            processed.add(i, ele);
            permute(processed, unprocessed, index + 1, ans);
            processed.remove(i);
        }
    }
}
