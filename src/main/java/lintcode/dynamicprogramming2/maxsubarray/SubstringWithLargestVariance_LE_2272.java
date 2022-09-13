package lintcode.dynamicprogramming2.maxsubarray;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithLargestVariance_LE_2272 {
    /*
        ref - https://www.youtube.com/watch?v=tMIBXRhp9hs
        - Time - O(N^3)
    */
    public int largestVariance(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int ans = 0;
        //traverse combinations of any 2 existing chars
        int[] occur = new int[s.length()];
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (!count.containsKey(i) || !count.containsKey(j) || i == j) {
                    continue;
                }
                //build occurrence array
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == i) {
                        occur[k] = 1;
                    } else if (s.charAt(k) == j) {
                        occur[k] = -1;
                    } else {
                        occur[k] = 0;
                    }
                }
                //find the max variance of current occurrence array
                ans = Math.max(ans, helper(occur));
            }
        }
        return ans;
    }

    private int helper(int[] occur) {
        //here the logic is similar to 053, but the tricky is have to count at least one '-1' occurrence, otherwise the max can be only one char case
        int ret = 0;
        int[] dp1 = new int[occur.length];
        dp1[0] = occur[0];
        for (int i = 1; i < occur.length; i++) {
            dp1[i] = Math.max(dp1[i-1] + occur[i], occur[i]);
        }

        int curSum = 0;
        for (int i = occur.length-1; i >= 0; i--) {
            curSum = Math.max(curSum + occur[i], occur[i]);
            if (occur[i] == -1) {
                ret = Math.max(ret, dp1[i] + curSum - occur[i]);//occur[i] counted twice, need adjust
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        SubstringWithLargestVariance_LE_2272 solution = new SubstringWithLargestVariance_LE_2272();
        String str = "aababbb";//3
//        String str = "bbc";//1
        System.out.println(solution.largestVariance(str));
    }
}
