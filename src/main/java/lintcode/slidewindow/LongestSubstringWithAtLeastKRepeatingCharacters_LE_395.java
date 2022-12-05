package lintcode.slidewindow;

public class LongestSubstringWithAtLeastKRepeatingCharacters_LE_395 {
    /**
     12.05.2022
     - a variant of 东哥 sliding window template
     */

    public int longestSubstring(String s, int k) {
        int len = 0;
        for (int i = 1; i <= 26; i++) {
            len = Math.max(len, longestKLetterSubString(s, k, i));
        }
        return len;
    }

    private int longestKLetterSubString(String s, int k, int uniqueCount) {
        int res = 0;

        int[] windowCount = new int[26];
        int windowUniqueCount = 0;
        int windowValidCount = 0;

        int left = 0, right = 0;
        while (right < s.length()) {
            int r = s.charAt(right) - 'a';
            if (windowCount[r] == 0) {
                windowUniqueCount++;
            }
            windowCount[r]++;
            if (windowCount[r] == k) {
                windowValidCount++;
            }
            right++;

            while (windowUniqueCount > uniqueCount) {
                int l = s.charAt(left) - 'a';
                if (windowCount[l] == k) {
                    windowValidCount--;
                }
                windowCount[l]--;
                if (windowCount[l] == 0) {
                    windowUniqueCount--;
                }
                left++;
            }

            //note - i think here the condition should be "windowValidCount == k", but the test proves it is wrong, marked for future research.
            if (windowValidCount == uniqueCount) {
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}
