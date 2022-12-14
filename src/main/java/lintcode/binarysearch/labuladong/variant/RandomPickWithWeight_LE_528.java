package lintcode.binarysearch.labuladong.variant;

import java.util.Random;

public class RandomPickWithWeight_LE_528 {
    /**
     12.14.2022
     - ref 东哥 post，following the 2 steps:
     - 1、根据权重数组 w 生成前缀和数组 preSum。
     - 2、生成一个取值在 preSum 之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
     */
    int[] ps;
    Random rand = new Random();
    int n;

    public RandomPickWithWeight_LE_528(int[] w) {
        this.n = w.length;
        this.ps = new int[n];
        ps[0] = w[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i-1] + w[i];
        }
    }

    public int pickIndex() {
        // 保证取到[1, preSum[n-1]]的闭区间
        int target = rand.nextInt(ps[n-1]) + 1;
        // 返回最靠近左边的索引
        return left_bound(ps, target);
    }

    // 搜索左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
