package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.decodeways.second;

/**
 * Author: blueaken
 * Date: 7/9/16 10:51
 */
public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        //init
        int[] res = new int[s.length() + 1];
        res[0] = 1;

        //dp
        int cur; //note this local variable is initialized 2 lines below, so it is still valid
        for (int i = 1; i <= s.length(); i++) {
            cur = s.charAt(i - 1) - '0';
            if (cur != 0) {
                res[i] += res[i - 1];
            }
            if (i != 1) {
                cur = (s.charAt(i - 2) - '0') * 10 + cur;
                if (cur <= 26 && cur >= 10) {
                    res[i] += res[i - 2];
                }
            }
        }
        return res[s.length()];
    }
}
