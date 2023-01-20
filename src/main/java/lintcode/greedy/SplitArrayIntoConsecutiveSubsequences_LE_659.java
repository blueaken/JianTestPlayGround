package lintcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences_LE_659 {
    /**
     1.20.2023
     - ref 东哥 post, 对当前元素分2种情况讨论：加入已有的子序列，或者自己开头建立一个新子序列
     - 通过2个HashMap freq 和 need 辅助
     - Greedy type
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        // init freq map
        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        for (int v : nums) {
            if (!freq.containsKey(v)) {
                continue;
            }

            // first check if can join exisitng subsequence
            if (need.containsKey(v) && need.get(v) > 0) {
                int curFreq = freq.get(v) - 1;
                if (curFreq == 0) {
                    freq.remove(v);
                } else {
                    freq.put(v, curFreq);
                }

                need.put(v, need.get(v) - 1);

                // 对v+1的need增加了1
                need.put(v+1, need.getOrDefault(v+1, 0) + 1);
            } else if (freq.containsKey(v) && freq.get(v) > 0
                    && freq.containsKey(v+1) && freq.get(v+1) > 0
                    && freq.containsKey(v+2) && freq.get(v+2) > 0) {
                // second try to setup a new subsequence
                int curFreq = freq.get(v) - 1;
                if (curFreq == 0) {
                    freq.remove(v);
                } else {
                    freq.put(v, curFreq);
                }

                curFreq = freq.get(v+1) - 1;
                if (curFreq == 0) {
                    freq.remove(v+1);
                } else {
                    freq.put(v+1, curFreq);
                }

                curFreq = freq.get(v+2) - 1;
                if (curFreq == 0) {
                    freq.remove(v+2);
                } else {
                    freq.put(v+2, curFreq);
                }

                // v+3的需求增加了1
                need.put(v+3, need.getOrDefault(v+3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
