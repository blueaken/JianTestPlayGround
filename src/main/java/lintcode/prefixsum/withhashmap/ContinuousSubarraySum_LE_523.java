package lintcode.prefixsum.withhashmap;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_LE_523 {
    /**
     11.23.2022
     ref 东哥 post
     - similar to 525, the difference is this problem looking for sum = (ps[j] - ps[i]) % k = 0, which is equals to ps[j] % k == ps[i] % k, we just need to put the val of ps[i] % k into the hashmap instead
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> valToIdx = new HashMap<>();

        valToIdx.put(0, -1); //in case the target sub array starts from begin
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int curKey = sum % k;
            if (!valToIdx.containsKey(curKey)) {
                valToIdx.put(curKey, i);
            } else {
                int curLen = i - valToIdx.get(curKey);
                if (curLen >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
