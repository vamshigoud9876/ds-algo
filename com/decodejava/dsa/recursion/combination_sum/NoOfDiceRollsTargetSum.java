package com.decodejava.dsa.recursion.combination_sum;

//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NoOfDiceRollsTargetSum {

    double mod = Math.pow(10, 9)+7;
    public static void main(String[] args) {
        // todo
    }
    public int numRollsToTarget(int n, int k, int target) {
        return diceHelper(target, n, 1, k);
    }

    public int diceHelper(int remainingSum, int remainingDice, int start, int faces) {
        if (remainingSum == 0) {
            return 1;
        }
        if(remainingDice==0) return 0;
        int count = 0;
        for (int i = start; i <= faces; i++) {
            if (remainingSum < i)
                break;
            count = (int)((count + diceHelper(remainingSum - i, remainingDice - 1, start, faces)) % mod);
        }
        return count;
    }
}
