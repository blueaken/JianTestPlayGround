package lintcode.binarySearch;

import java.util.Arrays;

public class SmallestDistancePair_1072 {
    /**
     * @param nums: a list of integers
     * @param k: a integer
     * @return: return a integer
     */
    //Idea:
    // 1. 最小Pair差肯定在0和最大值和最小值差之间，作为2分区间
    // 2. 二分出答案时，我们需要找到最小的x，使得差小于等于x的数对个数是大于等于k的（这样找到的x就是第k小的数对差）。而找小于等于x的数对个数，可以用前后双指针来做。
    // 思路和复印书籍（437）和木头尺寸（183）有点象，Ref - https://blog.csdn.net/qq_46105170/article/details/113523424

    public int smallestDistancePair(int[] nums, int k) {
        // write your code here
        Arrays.sort(nums);
        int start = 0, end = nums[nums.length - 1] - nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isWorkable(nums, mid, k)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isWorkable (int[] nums, int diff, int k) {
        int count = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums[i] - nums[j] > diff) {
                j++;
            }
            count += i - j;
        }
        return count >= k;
    }
}
