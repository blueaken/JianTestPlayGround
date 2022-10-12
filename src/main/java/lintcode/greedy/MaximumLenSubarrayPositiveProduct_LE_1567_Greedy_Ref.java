package lintcode.greedy;

public class MaximumLenSubarrayPositiveProduct_LE_1567_Greedy_Ref {
    /*
        Ref - https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/discuss/820072/EASY-soultion-with-DRY-RUN-JAVA
        - O(N) Time solution, it is a greedy
        Algorithm

        1. If we see a 0, we gotta start off things again
        2. If we see a positive number :
            2.1. Increase length of positive multiplicative result till now.
            2.2. Increase length of negative multiplicative result till now, unless we had not encountered any negative before.
        3. If we see a negative number:
           3.1. It's time to swap positive and negative multiplicative results' lengths and do similar task as we did in above case.
        4. In each iteration, use the length of positive multiplicative result to compute answer.
     ===================================
     redo per Huifeng Guan video - https://www.youtube.com/watch?v=9WE8uAtdJGk
     type - greedy
     1. if see a 0 then reset count
     2. count the current subarry's negative count, if it is even, then the length is the current subarray length
     3. if the negative count is odd, then the length is current pos - 1st negative pos + 1
     overall time is O(N)
    */
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int count = 0;
            int firstNeg = -1;

            int j = i;
            while (j < n && nums[j] != 0) {
                int cur = nums[j];
                count += cur < 0 ? 1 : 0;
                if (count % 2 == 0) {
                    ans = Math.max(ans, j - i + 1);
                } else if (firstNeg != -1) {
                    ans = Math.max(ans, j - firstNeg);
                }

                if (cur < 0 && firstNeg == -1) {
                    firstNeg = j;
                }

                j++;
            }
            i = j;
        }
        return ans;
    }
}
