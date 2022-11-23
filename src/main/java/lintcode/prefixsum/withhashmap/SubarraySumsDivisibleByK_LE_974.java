package lintcode.prefixsum.withhashmap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK_LE_974 {
    /**
     11.23.2022
     ref 东哥 post
     solve by prefix sum & hash map
     - similar to the combination of 523 and 560
     */
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> reminderToCount = new HashMap<>();
        reminderToCount.put(0, 1); //in case the element itself is the key

        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int curKey = sum % k;
            if (curKey < 0) {
                //如果余数小于0，-2 % 3 = -2, 但实际我们想要正余数 -2 + 3 = 1
                curKey += k;
            }

            // if (reminderToCount.containsKey(curKey)) {
            //     res += reminderToCount.get(curKey);
            // }
            int curCount = reminderToCount.getOrDefault(curKey, 0);
            res += curCount;
            reminderToCount.put(curKey, curCount + 1);
        }
        return res;
    }
}
