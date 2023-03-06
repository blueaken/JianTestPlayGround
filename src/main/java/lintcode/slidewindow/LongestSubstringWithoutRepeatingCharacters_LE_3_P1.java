package lintcode.slidewindow;

public class LongestSubstringWithoutRepeatingCharacters_LE_3_P1 {
    /**
     12.04.2022
     redo ref 东哥 sliding window template
     ===============
     3.6.2023
     P1
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] window = new int[256];
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            char r = s.charAt(right);
            right++;
            window[r]++;

            while (window[r] > 1) {
                char l = s.charAt(left);
                left++;
                window[l]--;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
