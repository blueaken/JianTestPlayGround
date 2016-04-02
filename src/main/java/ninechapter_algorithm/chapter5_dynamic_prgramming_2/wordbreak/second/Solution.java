package ninechapter_algorithm.chapter5_dynamic_prgramming_2.wordbreak.second;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 4/2/16 10:33 AM
 */
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public static boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        //init
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;

        //dp
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String cur = s.substring(j, i+1);
                if (res[j] && dict.contains(cur)) {
                    res[i+1] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }

    public static void main(String[] args) {
//        String s = "lintcode";
//        Set<String> dict = new HashSet<>();
//        dict.add("lint");
//        dict.add("code");

        String s = "a";
        Set<String> dict = new HashSet<>();
        dict.add("a");

        System.out.println(wordBreak(s, dict));
    }
}
