package lintcode.math;

public class NumPairsDivisibleBy60_LE_1010 {
    /*
        - brute force O(N^2), space O(1)
        - use remainder arr, time O(N), space O(1) - since the remainder arr is of size 60, which is constance
        - ref https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/
    */
    public int numPairsDivisibleBy60(int[] time) {
        int[] reminders = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                count += reminders[0];
            } else {
                count += reminders[60 - t % 60];
            }
            //always update the reminder arr
            reminders[t % 60]++;
        }
        return count;
    }
}
