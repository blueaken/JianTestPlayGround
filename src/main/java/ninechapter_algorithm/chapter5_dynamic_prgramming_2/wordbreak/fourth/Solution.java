package ninechapter_algorithm.chapter5_dynamic_prgramming_2.wordbreak.fourth;

import java.util.Set;

/**
 * Author: blueaken
 * Date: 7/6/16 12:37
 */
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || dict == null) {
            return false;
        }

        //init
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        res[0] = true;

        //dp
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j, i);
                if (res[j] && dict.contains(cur)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}
