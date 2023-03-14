package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LE_18_Labuladong {
    /**
     11.21.2022
     - ref prev code & 东哥 post
     - 东哥的模板使用了递归的，为了解决最后的nSum问题，对3Sum和4Sum感觉还是自己以前写的模板好用
     ================
     3.10.2023
     redo with 东哥nSum模板
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);// note - have to sort before
        return nSumTarget(nums, 4, 0, target);
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();

        int size = nums.length;
        if (n < 2 || n > size) {
            return res;
        }

        if (n == 2) {
            int lo = start, hi = size-1;
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                long sum = left + right;
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(left);
                    temp.add(right);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                    res.add(temp);
                }
            }
        } else {
            // n > 2时，递归计算 (n-1)sum 的结果
            for (int i = start; i < size; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n-1, i+1, target - nums[i]);
                for (List<Integer> list : sub) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    for (Integer x : list) {
                        temp.add(x);
                    }
                    res.add(temp);
                }
                while (i < size-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum_LE_18_Labuladong solution = new FourSum_LE_18_Labuladong();
//        int[] nums = {2,3,4,5,7};
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(solution.fourSum(nums, target));
    }
}
