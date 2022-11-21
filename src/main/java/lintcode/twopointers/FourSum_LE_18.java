package lintcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LE_18 {
    /**
     11.21.2022
     - ref prev code & 东哥 post
     - 东哥的模板使用了递归的，为了解决最后的nSum问题，对3Sum和4Sum感觉还是自己以前写的模板好用
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i+1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < (long)target) {
                        k = moveMidIdx(nums, k, l);
                    } else if (sum > (long)target) {
                        l = moveRightIdx(nums, k, l);
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);

                        k = moveMidIdx(nums, k, l);
                        l = moveRightIdx(nums, k, l);
                    }
                }
            }
        }
        return res;
    }

    private int moveMidIdx(int[] nums, int k, int l) {
        k++;
        while (k < l && nums[k] == nums[k-1]) {
            k++;
        }
        return k;
    }

    private int moveRightIdx(int[] nums, int k, int l) {
        l--;
        while (k < l && nums[l] == nums[l+1]) {
            l--;
        }
        return l;
    }
}
