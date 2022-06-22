package lintcode.greedy;

public class MaximumLenSubarrayPositiveProduct_LE_1567_Greedy_P1 {
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
    */
    public int getMaxLen(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int positive = 0;
        int negative = 0;
        int max = 0;
        for (int n : nums) {
            if (n == 0) {
                positive = 0;
                negative = 0;
            } else if (n > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else { //n < 0 case
                int temp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = temp + 1;
            }
            max = Math.max(max, positive);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumLenSubarrayPositiveProduct_LE_1567_Greedy_P1 solution = new MaximumLenSubarrayPositiveProduct_LE_1567_Greedy_P1();
        int[] nums = {1,-2,-3,4};//4
//        int[] nums = {0,1,-2,-3,-4};//3
        System.out.println(solution.getMaxLen(nums));
    }
}
