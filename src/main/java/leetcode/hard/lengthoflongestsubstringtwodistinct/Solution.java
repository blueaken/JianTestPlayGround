package leetcode.hard.lengthoflongestsubstringtwodistinct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 1/25/16 6:27 PM
 */
public class Solution {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int start = 0, numDistinct = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 0) numDistinct++;
            count[s.charAt(j)]++;
            while (numDistinct > 2) {
                count[s.charAt(start)]--;
                if (count[s.charAt(start)] == 0) numDistinct--;
                start++;
            }
            maxLen = Math.max(j - start + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args){
//        String test = "eceba";
        String test = "abbaac";

        lengthOfLongestSubstringTwoDistinct(test);
    }
}
