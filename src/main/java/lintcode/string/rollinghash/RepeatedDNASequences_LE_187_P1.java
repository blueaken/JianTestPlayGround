package lintcode.string.rollinghash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_LE_187_P1 {
    /**
     12.06.2022
     - solve by rolling hash + sliding window, from 东哥 post
     =============
     3.18.2023
     P1
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            switch(cur) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        int R = 4;
        int L = 10;
        int RL = (int)Math.pow(R, L-1);

        int left = 0, right = 0;
        int windowHash = 0;
        while (right < n) {
            int r = nums[right];
            right++;
            windowHash = windowHash * R + r;

            while (right - left == L) {
                if (seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }

                int l = nums[left];
                left++;
                windowHash = windowHash - l * RL;
            }
        }
        return new ArrayList<>(res);
    }
}
