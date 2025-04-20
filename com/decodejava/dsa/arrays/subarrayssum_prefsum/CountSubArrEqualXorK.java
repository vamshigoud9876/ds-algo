package com.decodejava.dsa.arrays.subarrayssum_prefsum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSubArrEqualXorK {
    public static int subarraysXor(List<Integer> arr, int k) {
        //xor property x ^ x = 0
        // let. if the sub array till ind contains kor k,
        // till my prefxor be x. now x means some y ^ k. So if i somehow find y then i can say there exists y.
        // So. (y ^ k) ^ k  then I will get y. So I will check if there exists y after this.
        int count = 0, prefXor = 0;//a ^ 0 = a
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : arr) {
            prefXor ^= num;
            if (prefXor == k)
                count++;
            if (map.containsKey(prefXor ^ k))
                count += map.get(prefXor ^ k);
            map.put(prefXor, map.getOrDefault(prefXor, 0) + 1);
        }
        return count;
    }
}
