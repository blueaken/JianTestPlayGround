package lintcode.dynamicprogramming2;

public class MaxSumIncreasingSubSequence {
    public int maxSum(int[] num){
        if (num == null || num.length == 0) {
            return 0;
        }

        //init
        int[] maxVal = new int[num.length];
        maxVal[0] = num[0];

        //dp
        for (int i = 1; i < num.length; i++) {
            maxVal[i] = num[i];
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    maxVal[i] = Math.max(maxVal[i], maxVal[j] + num[i]);
                }
            }
        }
        int max = 0;
        for (int i : maxVal) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String args[]){
        int arr[] = {4, 6, 1, 3, 8, 4, 6}; //expect 18

        MaxSumIncreasingSubSequence solution = new MaxSumIncreasingSubSequence();
        System.out.println(solution.maxSum(arr));
    }
}
