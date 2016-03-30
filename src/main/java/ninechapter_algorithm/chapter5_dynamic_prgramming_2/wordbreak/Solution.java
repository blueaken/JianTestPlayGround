package ninechapter.chapter5_dynamic_prgramming_2.wordbreak;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: blueaken
 * Date: 3/4/16 9:21 AM
 */
public class Solution {
    public static boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++) {
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++)
            {
                if(res[j] && dict.contains(str.toString()))
                {
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        String s = "lintcode";
        Set<String> dict = new HashSet<>();
        dict.add("lint");
        dict.add("code");

//        String s = "a";
//        Set<String> dict = new HashSet<>();
//        dict.add("a");

        System.out.println(wordBreak(s, dict));
    }
}
