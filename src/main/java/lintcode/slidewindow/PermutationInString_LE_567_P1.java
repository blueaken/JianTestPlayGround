package lintcode.slidewindow;

public class PermutationInString_LE_567_P1 {
    /**
     12.04.2022
     ref 东哥 post
     similar to 76, sliding window type
     ====================
     3.6.2023
     P1 - similar to LE 76
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[128];
        int[] window = new int[128];

        int count = 0;
        for (char c : s1.toCharArray()) {
            if (need[c] == 0) {
                count++;
            }
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need[r] > 0) {
                window[r]++;
                if (window[r] == need[r]) {
                    valid++;
                }
            }

            while (right - left == s1.length()) {
                if (valid == count) {
                    return true;
                }

                char l = s2.charAt(left);
                left++;
                if (need[l] > 0) {
                    if (window[l] == need[l]) {
                        valid--;
                    }
                    window[l]--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString_LE_567_P1 solution = new PermutationInString_LE_567_P1();
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(solution.checkInclusion(s1, s2));
    }
}
