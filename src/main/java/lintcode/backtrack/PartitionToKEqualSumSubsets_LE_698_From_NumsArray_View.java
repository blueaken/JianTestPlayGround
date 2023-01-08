package lintcode.backtrack;

public class PartitionToKEqualSumSubsets_LE_698_From_NumsArray_View {
    /**
     1.8.2023
     - ref 东哥 post, 使用回溯法
     - 从nums数组角度进行处理，but will TLE
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
        int[] bucket = new int[k];
        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, bucket, 0, target);
    }

    private boolean backtrack(int[] nums, int[] bucket, int index, int target) {
        // base case
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        // 穷举 nums[index] 可能装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 减枝，去掉已超过target的路径
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            //开始回溯
            bucket[i] += nums[index];
            if (backtrack(nums, bucket, index + 1, target)) {
                return true;
            }
            bucket[i] -= nums[index];
        }
        // 没有找到任何一个solution
        return false;
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets_LE_698_From_NumsArray_View solution = new PartitionToKEqualSumSubsets_LE_698_From_NumsArray_View();
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(solution.canPartitionKSubsets(nums, k));
    }
}
