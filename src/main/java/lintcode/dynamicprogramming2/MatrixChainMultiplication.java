package lintcode.dynamicprogramming2;

//ref Tushor's video, did not found on lintcode / leetcode though
//the loop is similar to WordBreak/LongestPalindromeSubSequence/EggDrop2
//code adjusted from: https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
public class MatrixChainMultiplication {
    public int findCost(int arr[]){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] res = new int[arr.length][arr.length];

        //when length is 1, there is no cost to multiple itself, the cost is 0
        for (int len = 2; len < arr.length; len++) {
            for (int start = 1; start < arr.length - len + 1; start++) {
                int end = start + len - 1;
                if (end == arr.length) {
                    continue;
                }
                res[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end - 1; k++) {
                    int cur = res[start][k] + res[k+1][end] + arr[start - 1] * arr[k] * arr[end];
                    res[start][end] = Math.min(res[start][end], cur);
                }
            }
        }
        return res[1][arr.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,6,4,5}; //match the example from the video

        MatrixChainMultiplication solution = new MatrixChainMultiplication();
        System.out.println(solution.findCost(arr)); //expect value is 124
    }
}
