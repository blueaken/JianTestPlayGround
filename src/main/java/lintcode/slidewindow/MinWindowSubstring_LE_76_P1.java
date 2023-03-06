package lintcode.slidewindow;

public class MinWindowSubstring_LE_76_P1 {
    /**
     12.03.2022
     ref labuladong post
     - solve with slide window template
     - maintain一个[left, right)区间。这个区间是左闭右开的理由见东哥post
     - Time - O(N), 因为s中每个字符都进出这个窗口一次
     ==================
     3.6.2023
     P1
     */
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];
        int count = 0;

        for (char c : t.toCharArray()) {
            if (need[c] == 0) {
                count++;
            }
            need[c]++;
        }

        int left = 0, right = 0;
        int valid = 0;
        String res = "";
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need[r] > 0) {
                window[r]++;
                if (window[r] == need[r]) {
                    valid++;
                }
            }

            while (valid == count) {
                String cur = s.substring(left, right);
                if (res.equals("")) {
                    res = cur;
                } else {
                    res = cur.length() < res.length() ? cur : res;
                }

                char l = s.charAt(left);
                left++;
                if (need[l] > 0) {
                    if (window[l] == need[l]) {
                        valid--;
                    }
                    window[l]--;
                }
            }
        }
        return res;
    }
}
