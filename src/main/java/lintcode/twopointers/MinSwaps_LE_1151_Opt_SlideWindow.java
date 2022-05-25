package lintcode.twopointers;

import java.util.Arrays;

public class MinSwaps_LE_1151_Opt_SlideWindow {
    /*
        first idea:
        - 1. find the number of 1's, say n
        - 2. for each subarray of size n, found the number of swaps needs and find the min
        - Time - O(N^2) and get TLE without surprise.

        second thought after read hint 5:
        - actually no need to count number of zeros all over again, can build a prefix sum array in another iteration, and the number of zeros at index i is:  i + 1 - data[i + 1]
        - Time is O(N) this time

        thrid time:
        - reading the solution link approach 1, using the sliding windows idea, brilliant solution
        - Time is also O(N) and Space is O(1)
    */
    public int minSwaps(int[] data) {
        // `ones` also serve as the size of sliding window
        int ones = Arrays.stream(data).sum();

        // Count 1s in first `ones` elements
        int runningOnes = 0;
        for (int i = 0; i < ones; i++) {
            runningOnes += data[i];
        }

        int minSwap = ones - runningOnes;
        for (int i = ones; i < data.length; i++) {
            // Drop leftmost from sliding window, and accumulate next right
            runningOnes = runningOnes + data[i] - data[i - ones];
            // runningOnes holds 1s seen in current window
            minSwap = Math.min(minSwap, ones - runningOnes);
        }
        return minSwap;
    }
}
