package lintcode.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_838 {
//    /**
//     * @param nums: a list of integer
//     * @param k: an integer
//     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
//     */
//    //Idea1: 数组每个元素按顺序遍历，注意需要加完整个数组，因为可能有负数存在，O(N^2)
//    public int subarraySumEqualsK(int[] nums, int k) {
//        // write your code here
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return an integer, denote the number of continuous subarrays whose sum equals to k
     */
    //Idea1: 数组每个元素按顺序遍历，注意需要加完整个数组，因为可能有负数存在，O(N^2)
    //Idea2: 使用前缀和数组和HashMap，可提高效率，类似2Sum解法，O(N)，ref: https://aaronice.gitbook.io/lintcode/array/subarray-sum-equals-k
    public int subarraySumEqualsK(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }

        Map<Integer, Integer> map = new HashMap<>(); //prefixsum, freq
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                count += map.get(nums[i] - k);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-1,1,2};
        int target = 3;

        SubarraySumEqualsK_838 solution = new SubarraySumEqualsK_838();
        System.out.println(solution.subarraySumEqualsK(nums, target));
    }
}
