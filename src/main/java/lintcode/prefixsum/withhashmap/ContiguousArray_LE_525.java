package lintcode.prefixsum.withhashmap;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_LE_525 {
    /**
     ref 东哥 post & Huifeng Guan's code, feel the latter is more elegant
     - solve by Prefix Sum + HashMap
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0;
        Map<Integer, Integer> valToIdx = new HashMap<>();

        valToIdx.put(0, -1); //in case the target sub array starts from begin
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 1 ? 1 : -1; //convert the problem to find the longest subarray with the sum of 0
            if (!valToIdx.containsKey(sum)) {
                //note - since we are looking for the longest subarray, we only record the idx of the target value appears first
                valToIdx.put(sum, i);
            } else {
                res = Math.max(res, i - valToIdx.get(sum));
            }
        }
        return res;
    }
}
