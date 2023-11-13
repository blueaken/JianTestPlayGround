package lintcode.dynamicprogramming2.state_compress;

import java.util.Arrays;

public class StickersToSpellWord_LE_691 {
    /**
     11.13.23
     - follow solution post and huifeng guan's video
     - https://leetcode.com/problems/stickers-to-spell-word/solutions/108333/rewrite-of-contest-winner-s-solution/
     - https://www.youtube.com/watch?v=QusReweeTqI
     - solve with bottom up sate compress DP, similar to 1799 (which is top down dp)
     */
    public int minStickers(String[] stickers, String target) {
        int targetLen = target.length();
        int N = 1 << targetLen; //total 2^targetLen -1 state, each bit represents a letter on the positioin of target string, ex, "hello", state is 11111

        int[] dp = new int[N]; //each dp value is the number of min number of stickers needed of each state
        Arrays.fill(dp, Integer.MAX_VALUE);
        // if target string is empty then no sticker needed
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            // if current state is not reachable then continue since it is bottom up DP
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            // build next state with each sticker from the current state
            for (String sticker : stickers) {
                int state = i;
                for (char c : sticker.toCharArray()) {
                    for (int pos = 0; pos < targetLen; pos++) {
                        // find matched letter & the corresponding bit of current state not set
                        if (target.charAt(pos) == c && (((state >> pos) & 1) == 0)) {
                            state |= 1 << pos;
                            //each sticker letter only use once
                            break;
                        }
                    }
                }
                dp[state] = Math.min(dp[state], dp[i]+1);
            }
        }

        return dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1];

    }

    public static void main(String[] args) {
        StickersToSpellWord_LE_691 solution = new StickersToSpellWord_LE_691();

        String[] stickers = {"with","example","science"};
        String target = "thehat";
        System.out.println(solution.minStickers(stickers, target));
    }
}
