package ninechapter_algorithm.chapter5_dynamic_prgramming_2.optional.decodeways;

/**
 * Author: blueaken
 * Date: 4/8/16 8:50 AM
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
        int n = s.length();
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = s.startsWith("0") ? 0 : 1;

        //dp
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i-1) != '0') {
                res[i] = res[i-1];
            }

            int twoDigits = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                res[i] += res[i-2];
            }
        }

        return res[n];
    }
}
