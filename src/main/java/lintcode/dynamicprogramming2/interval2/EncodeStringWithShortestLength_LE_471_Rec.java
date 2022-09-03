package lintcode.dynamicprogramming2.interval2;

import java.util.HashMap;
import java.util.Map;

public class EncodeStringWithShortestLength_LE_471_Rec {
    /*
        ref https://leetcode.com/problems/encode-string-with-shortest-length/discuss/2308429/Java-top-down-and-bottom-up-with-detailed-comments
        - a smart solution:
        1. If a String length is less than or equal to 4 it can't be shortened via encoding
        2. Else if a string is composed of repeating substrings then we find the repeating substring, encode the string using the substring and return because this is the shortest encoding of the string.
        3. Else, we'll need to split the string, encode the left and right and concatenate. The pivot for the split lies in the range [1, s.length]. We return the encoding having minimum length
        4. By using memoization we can speed up the above exponential algorithm to o(n^3). We can memoize because left and right strings above will repeat across recrusion calls.
    */

    Map<String, String> memo = new HashMap<>();
    public String encode(String s) {
        return helper(s);
    }

    private String helper(String s) {
        int len = s.length();
        if (len <= 4) {
            return s;
        }

        if (!memo.containsKey(s)) {
            int idx = (s + s).indexOf(s, 1);
            String encoding = idx < len ? String.format("%d[%s]", len / idx, helper(s.substring(0, idx))) : s;

            if (encoding.length() >= len) {
                /**
                 1. If the string cannot be encoded into a shorter string then we divide it into two parts with the pivot in the range [1, s.length -1]
                 2. We encode each part and concatenate.
                 3. We return minimum ecnoding across all pivots
                 **/
                for (int i = 1; i < len; i++) {
                    String e = helper(s.substring(0, i)) + helper(s.substring(i));
                    if (e.length() < encoding.length()) {
                        encoding = e;
                    }
                }
            }
            memo.put(s, encoding);
        }
        return memo.get(s);
    }

    public static void main(String[] args) {
        EncodeStringWithShortestLength_LE_471_Rec solution = new EncodeStringWithShortestLength_LE_471_Rec();
        String s = "dabcabcabc"; //"d3[abc]"
        System.out.println(solution.encode(s));
    }
}
