package lintcode.string.rollinghash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_LE_187 {
    /**
     12.06.2022
     - solve by rolling hash + sliding window, from 东哥 post
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        //convert s to a number array of 4-based number
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            switch(cur) {
                case 'A':
                    num[i] = 0;
                    break;
                case 'C':
                    num[i] = 1;
                    break;
                case 'G':
                    num[i] = 2;
                    break;
                case 'T':
                    num[i] = 3;
                    break;
            }
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>(); //use Set to filter duplicates
        int R = 4;
        int L = 10;
        int RL = (int)Math.pow(R, L-1);

        int left = 0, right = 0;
        int windowVal = 0;
        while (right < n) {
            //add number from low position
            int r = num[right];
            windowVal = windowVal * R + r;
            right++;

            while (right - left == L) {
                if (seen.contains(windowVal)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowVal);
                }

                //remove number from high position
                int l = num[left];
                windowVal = windowVal - l * RL;
                left++;
            }
        }

        return new ArrayList<>(res);
    }
}
