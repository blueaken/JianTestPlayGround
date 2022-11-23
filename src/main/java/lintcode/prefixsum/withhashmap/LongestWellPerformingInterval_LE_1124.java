package lintcode.prefixsum.withhashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval_LE_1124 {
    /**
     11.23.2022
     ref 东哥 post
     solve by prefix sum & hash map
     - 对数组进行归一化处理，如果大于8记为1，否则记为-1，那么问题转化为 range sum > 0的最长sub array
     */
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> valToIdx = new HashMap<>();
        valToIdx.put(0, -1);

        int sum = 0, res = 0;
        for (int i = 0; i < n; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            //ps[j] - ps[i] > 0 => ps[j] > ps[i];

            if (!valToIdx.containsKey(sum)) {
                valToIdx.put(sum, i);
            }

            if (sum > 0) {
                res = Math.max(res, i+1);
            } else {
                //to make sum - ps[i] > 0 & the length to be longest, sum - ps[i] = 1, ps[i] = sum - 1
                if (valToIdx.containsKey(sum-1)) {
                    res = Math.max(res, i - valToIdx.get(sum-1));
                }
            }
        }
        return res;
    }
}
