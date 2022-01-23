package lintcode.twopointers;

public class TakeCoins_1399 {
    /**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    //Idea: 先预处理数组的和，再遍历k种可能，ref - https://www.lintcode.com/problem/1399/solution/26415
    public int takeCoins(int[] list, int k) {
        // Write your code here
        if (list.length < k) {
            return -1;
        }

        int len = list.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = list[i - 1] + preSum[i - 1];
        }

        int maxSum = 0;
        for (int i = 0; i <= k; i++) {
            int left = i;
            int right = k - i;
            int cur = preSum[len] - preSum[len - right] + preSum[left];
            maxSum = Math.max(cur, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {5,4,3,2,1,6};
        int k = 3;

        TakeCoins_1399 solution = new TakeCoins_1399();
        System.out.println(solution.takeCoins(input, k));
    }
}
