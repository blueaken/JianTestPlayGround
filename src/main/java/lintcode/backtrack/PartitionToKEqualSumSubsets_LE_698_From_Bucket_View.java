package lintcode.backtrack;

import java.util.HashMap;
import java.util.Map;

public class PartitionToKEqualSumSubsets_LE_698_From_Bucket_View {
    /**
     1.8.2023
     - ref 东哥 post, 使用回溯法
     - 从nums数组角度进行处理，but will TLE
     - 如先对数组进行降序排序，可以在剪枝部分提高效率，但仍会 TLE
     - O(K^N)
     ----------------------------------------
     - 从bucket角度进行处理，结合bitMap对每个位置是否used进行记录，提高效率。O(K*2^N)
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 先过滤一些 corner case
        int n = nums.length;
        if (k > n) {
            return false;
        }

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        int used = 0;

        // 穷举，k个桶一开始什么都没装，从nums[0]开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    Map<Integer, Boolean> memo = new HashMap<>();

    private boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        // base case
        if (k == 0) {
            // 所有桶装满，且nums此时必然用完
            return true;
        }

        if (bucket == target) {
            // 当前桶装满，开始装下一个桶
            boolean res = backtrack(k-1, 0, nums, 0, used, target);
            //缓存结果
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            return memo.get(used);
        }

        // 穷举
        for (int i = start; i < nums.length; i++) {
            // 减枝, 这里 '&' 是bit operator
            if (((used >> i) & 1) == 1) {
                // i 位数字已经在其他桶使用
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }

            // 开始回溯
            // 做选择
            used |= 1 << i;
            bucket += nums[i];

            if (backtrack(k, bucket, nums, i+1, used, target)) {
                return true;
            }

            // 撤销选择
            bucket -= nums[i];
            used ^= 1 << i;
        }
        // 没有找到任何一个solution
        return false;
    }
}
