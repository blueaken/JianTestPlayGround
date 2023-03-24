package lintcode.binarysearch.labuladong.variant;

import java.util.Random;

public class RandomPickWithWeight_LE_528_P1 {
    /**
     12.14.2022
     - ref 东哥 post，following the 2 steps:
     - 1、根据权重数组 w 生成前缀和数组 preSum。
     - 2、生成一个取值在 preSum 之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
     ===============
     3.24.2023
     P1
     */
    int[] ps;
    int n;
    Random rand = new Random();

    public RandomPickWithWeight_LE_528_P1(int[] w) {
        this.n = w.length;
        this.ps = new int[n];

        ps[0] = w[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i-1] + w[i];
        }
    }

    public int pickIndex() {
        // in the range [1, ps[n-1]]
        int target = rand.nextInt(ps[n-1]) + 1;
        return left_bound(ps, target);
    }

    public int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
