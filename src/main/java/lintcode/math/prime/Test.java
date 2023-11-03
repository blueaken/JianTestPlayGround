package lintcode.math.prime;

import java.util.*;

public class Test {

    /**
     10.30.23
     - optimize the with sliding window from O(N^3) to O(N^2)
     */
    public int sumCounts(int[] nums) {
        int mod = (int)1e9 + 7;
        int res = 0;

        int left = 0, right = 0;
        Map<Integer, Integer> windowMap = new HashMap<>();
        while (right < nums.length) {
            windowMap.put(nums[right], windowMap.getOrDefault(nums[right], 0) + 1);
            right++;

            int cur = windowMap.keySet().size();
            res = res + cur * cur % mod;

            if (right == nums.length) {
                int size = windowMap.get(nums[left]) - 1;
                if (size == 0) {
                    windowMap.remove(nums[left]);
                } else {
                    windowMap.put(nums[left], size);
                }
                windowMap = new HashMap<>();
                left++; right = left;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();

        int[] nums = {1,2,1};

        System.out.println(test.sumCounts(nums));
    }
}
