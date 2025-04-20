package com.decodejava.dsa.recursion.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class DiceThrow {
    public static void main(String[] args) {
        numRollsToTarget(0, 3);
    }
    public static int numRollsToTarget(int n, int target) {
        System.out.println(getNumRolls(new ArrayList<>(), target));
        return 0;
    }

    private static List<List<Integer>> getNumRolls(List<Integer> processed, int remaining) {
        if (remaining == 0) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>(processed));
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            if (remaining < i) break;
            processed.add(i);
            ans.addAll(getNumRolls(processed, remaining - i));
            processed.remove(processed.size() - 1);
        }
        return ans;
    }
}
