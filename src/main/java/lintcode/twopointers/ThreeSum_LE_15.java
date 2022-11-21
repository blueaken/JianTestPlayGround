package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_LE_15 {
    /**
     11.21.2022
     - ref prev code & 东哥 post
     - 东哥的模板使用了递归的，为了解决最后的nSum问题，对3Sum和4Sum感觉还是自己以前写的模板好用
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = n-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j = moveMidIdx(nums, j, k);
                } else if (sum > 0) {
                    k = moveRightIdx(nums, j, k);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);

                    j = moveMidIdx(nums, j, k);
                    k = moveRightIdx(nums, j, k);
                }
            }
        }
        return res;
    }

    private int moveMidIdx(int[] nums, int j, int k) {
        j++;
        while (j < k && nums[j] == nums[j-1]) {
            j++;
        }
        return j;
    }

    private int moveRightIdx(int[] nums, int j, int k) {
        k--;
        while (j < k && nums[k] == nums[k+1]) {
            k--;
        }
        return k;
    }
}
