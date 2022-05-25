package lintcode.twopointers;

public class MinSwaps_LE_1151_Opt {
    /*
        first idea:
        - 1. find the number of 1's, say n
        - 2. for each subarray of size n, found the number of swaps needs and find the min
        - Time - O(N^2) and get TLE without surprise.

        second thought after read hint 5:
        - actually no need to count number of zeros all over again, can build a prefix sum array in another iteration, and get the number of zeros from  prefix[i] - data[i-1]
        - Time is O(N) this time
    */
    public int minSwaps(int[] data) {
        int num = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                num++;
            }
        }

        if (num == 1) {
            return 0;
        }

        int[] prefix = new int[data.length + 1];
        for (int i = 1; i <= data.length; i++) {
            prefix[i] = prefix[i-1] + data[i-1];
        }

        int left = 0, right = num - 1, min = Integer.MAX_VALUE;
        while (left < right && right < data.length) {
            int count = 0;
            if (left == 0) {
                count = prefix[right+1] - data[right];
            } else {
                count = (prefix[right+1] - data[right]) - (prefix[left] - data[left-1]);
            }
            min = Math.min(min, count);
            left++; right++;
        }
        return min;
    }

    public static void main(String[] args) {
        MinSwaps_LE_1151_Opt solution = new MinSwaps_LE_1151_Opt();
//        int[] data = {1,0,1,0,1}; // 1
//        int[] data = {0,0,0,1,0}; // 0
        int[] data = {1,0,1,0,1,0,0,1,1,0,1}; //3

        System.out.println(solution.minSwaps(data));
    }
}
