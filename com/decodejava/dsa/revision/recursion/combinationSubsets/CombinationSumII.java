package com.decodejava.dsa.revision.recursion.combinationSubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CombinationSumII {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CombinationSumII obj = new CombinationSumII();
        ExecutorService service = Executors.newFixedThreadPool(5);

        CompletableFuture.supplyAsync(() -> obj.combinationSumII(new int[]{1, 2, 2}, 4), service)
                        .thenAccept(System.out::println);
        service.shutdown();
        System.out.println(" " + Thread.currentThread().getName());
        System.out.println("Main"+ Thread.currentThread().getName());

    }
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        System.out.println(Thread.currentThread().getName());
        try {int k = 100;
            if (Thread.currentThread().getName().equals("running pool-1-thread-2"))
                k = 1000;
            for (int i = 0; i < k; i++) {
//                System.out.println("running "+ Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (Exception ignored) {}
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int[] arr, int ind, int remaining, List<Integer> ele, List<List<Integer>> ans) {
        if (remaining == 0) {
            ans.add(new ArrayList<>(ele));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (remaining - arr[i] < 0)
                break;
            if (i > ind && arr[i-1] == arr[i]) continue;
            ele.add(arr[i]);
            helper(arr, i + 1, remaining - arr[i], ele, ans);
            ele.remove(ele.size() - 1);
        }
    }
}
