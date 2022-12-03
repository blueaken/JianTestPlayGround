package lintcode.slidewindow;

public class MinWindowSubstring_LE_76 {
    /**
     12.03.2022
     ref labuladong post
     - solve with slide window template
     - maintain一个[left, right)区间。这个区间是左闭右开的理由见东哥post
     - Time - O(N), 因为s中每个字符都进出这个窗口一次
     */
    public String minWindow(String s, String t) {
        // Map<Character, Integer> need= new HashMap<>();
        // Map<Character, Integer> window = new HashMap<>();

        //hashmap timeout, use int array instead
        int[] need = new int[128];
        int[] window = new int[128];

        //init need array
        int count = 0; //count unique chars in t
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if (need[cur] == 0) {
                count++;
            }
            need[cur]++;
        }

        int left = 0, right = 0;
        int valid = 0; //当 valid 等于 need 大小时应该收缩窗口
        String res = "";
        while (right < s.length()) {
            // r 是将移入窗口的字符
            char r = s.charAt(right);
            //窗口扩大
            right++;
            // 进行窗口内数据的一系列更新
            if (need[r] > 0) {
                window[r]++;
                if (window[r] == need[r]) {
                    valid++;
                }
            }

            //decide when window needs shrinking
            while (left < right && valid == count) {
                // 先更新最小字符串
                String curMin = s.substring(left, right);
                if (res.equals("")) {
                    res = curMin;
                } else {
                    res = curMin.length() < res.length() ? curMin : res;
                }

                // l 是将移出窗口的字符
                char l = s.charAt(left);
                //窗口减小
                left++;
                // 进行窗口内数据的一系列更新
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
