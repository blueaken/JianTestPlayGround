package lintcode.dynamicprogramming2;

public class BurstBalloons_168 {
    class Record {
        int score;
        int lastBallonPos;
    }

    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
     /*
        Similar to LE 486, Ref - https://www.youtube.com/watch?v=IFNibRVgFBo

        a few notes to the d[i][j] of the video:
        1) if range [i to j] is to be burst AND all other range [0 to i] and [j to len] are STILL THERE.
        2) dp[i][j] is the max value to get for condition 1)
        3) to calculate d[i][j], we examine all k (i <= k <= j) calcuate if k is the last to burst, which means all other baloons in rang [i, j] r gone, then we get the min value
        4) we calculate d[i][j] by length in increasing order len = j - i + 1
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //init
        Record[][] rec = new Record[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                rec[i][j] = new Record();
            }
        }

        //dp
        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    //init leftValue & rightValue default to 1
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }
                    if (j != nums.length - 1) {
                        rightValue = nums[j+1];
                    }

                    //init before & after default to 0
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = rec[i][k-1].score;
                    }
                    if (j != k) {
                        after = rec[k+1][j].score;
                    }

                    int cur = leftValue * nums[k] * rightValue + before + after;
                    if (cur > rec[i][j].score) {
                        rec[i][j].score = cur;
                        rec[i][j].lastBallonPos = k;
                    }
                }
            }
        }
        return rec[0][nums.length-1].score;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8}; //expect 167,3

        BurstBalloons_168 solution = new BurstBalloons_168();
        System.out.println(solution.maxCoins(nums));
    }
}
