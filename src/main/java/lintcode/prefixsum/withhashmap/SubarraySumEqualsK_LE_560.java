package lintcode.prefixsum.withhashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_LE_560 {
    /**
     11.23.2022
     - similar to 525 & 523
     - solve by prefix sum + hashmap
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        Map<Integer, Integer> count = new HashMap<>();//ps[i], count - count of the number of subarray when ps[i] exists
        count.put(0, 1); //in case the element itself is an answer

        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            int need = sum - k; //ps[j] - ps[i] = k, need = ps[i]
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
