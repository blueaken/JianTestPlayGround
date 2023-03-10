package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_LE_15_Labuladong {
    /**
     11.21.2022
     - ref prev code & 东哥 post
     - 东哥的模板使用了递归的，为了解决最后的nSum问题，对3Sum和4Sum感觉还是自己以前写的模板好用
     ====================
     3.10.2023
     redo with 东哥 template
     */
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<List<Integer>> sub = twoSumTarget(nums, i+1, target -nums[i]);
            for (List<Integer> list : sub) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                for (Integer x : list) {
                    temp.add(x);
                }
                res.add(temp);
            }
            while (i < n-1 && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        // note - nums is already sorted when called
        int lo = start, hi = n-1;
        while (lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (sum < target) {
                while (lo < n && nums[lo] == left) {
                    lo++;
                }
            } else if (sum > target) {
                while (hi >= 0 && nums[hi] == right) {
                    hi--;
                }
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                while (lo < n && nums[lo] == left) {
                    lo++;
                }
                while (hi >= 0 && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
}
