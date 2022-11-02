package lintcode.greedy;

import java.util.Arrays;

public class MinimumNumberOfKeypresses_LE_2268 {
    /*
        - obviously a greedy, and the data size (10^5) also indicates a O(N) / O(NlogN) solution
        - Time is O(NLogN), since array sorting
        ========================
        P1 11.02.2022
        ========================
    */
    public int minimumKeypresses(String s) {
        //build freq array and sort
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            int k = c - 'a';
            freq[k]++;
        }
        Arrays.sort(freq);

        int ans = 0, count = 0, repeat = 1;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            ans += freq[i] * repeat;

            count++;
            if (count % 9 == 0) {
                repeat++;
            }
        }
        return ans;
    }
}
