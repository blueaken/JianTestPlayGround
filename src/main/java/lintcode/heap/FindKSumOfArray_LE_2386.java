package lintcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKSumOfArray_LE_2386 {
    /*
        ref https://www.youtube.com/watch?v=pquoywwK0_w
        - genius mathmatic solution
        - Difficulty level - hard (real one))
        - 第一步：转化为求一个正数数组的第k小序列和。
        - 第二步：构造一个正数数组的从小到大所有的序列和。
        - 第三步：证明这个构造方法的正确性
    */
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                maxSum += nums[i];
            } else {
                nums[i] = Math.abs(nums[i]);
            }
        }
        if (k == 1) {
            return maxSum;
        }

        Arrays.sort(nums);

        //note the type conversion of the comparator return val
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> (int)(a[0] - b[0]));
        long[] init = new long[]{nums[0], 0};//sum, ending idx
        minHeap.offer(init);
        //get the k-1 th subsequence sum (considering empty subsequene), and substracted by maxSum is the answer
        for (int i = 1; i <= k - 1; i++) {
            long[] cur = minHeap.poll();
            long sum = cur[0];
            int idx = (int)cur[1];

            if (i == (k-1)) {
                return maxSum - sum;
            }
            if (idx + 1 < n) {
                minHeap.offer(new long[]{sum - nums[idx] + nums[idx+1], idx+1});
                minHeap.offer(new long[]{sum + nums[idx+1], idx+1});
            }
        }
        return -1;
    }
}
