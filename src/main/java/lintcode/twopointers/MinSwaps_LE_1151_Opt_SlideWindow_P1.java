package lintcode.twopointers;

public class MinSwaps_LE_1151_Opt_SlideWindow_P1 {
    /*
        first idea:
        - 1. find the number of 1's, say n
        - 2. for each subarray of size n, found the number of swaps needs and find the min
        - Time - O(N^2) and get TLE without surprise.

        second thought after read hint 5:
        - actually no need to count number of zeros all over again, can build a prefix sum array in another iteration, and the number of zeros at index i is:  i + 1 - data[i + 1]
        - Time is O(N) this time

        third time:
        - reading the solution link approach 1, using the sliding windows idea, brilliant solution
        - Time is also O(N) and Space is O(1)l
    */
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i = 0; i < data.length; i++) {
            ones += data[i];
        }

        int runningones = 0;
        for (int i = 0; i < ones; i++) {
            runningones += data[i];
        }

        int ans = ones - runningones;
        for (int i = ones; i < data.length; i++) {
            runningones = runningones + data[i] - data[i - ones];
            ans = Math.min(ans, ones - runningones);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinSwaps_LE_1151_Opt_SlideWindow_P1 solution = new MinSwaps_LE_1151_Opt_SlideWindow_P1();
//        int[] data = {1,0,1,0,1}; // 1
//        int[] data = {0,0,0,1,0}; // 0
        int[] data = {1,0,1,0,1,0,0,1,1,0,1}; //3

        System.out.println(solution.minSwaps(data));
    }
}
