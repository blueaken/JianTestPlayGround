package lintcode.string;

public class GreatestCommonDivisorOfStrings_LE_1071 {
    /*
        - ref https://leetcode.com/problems/greatest-common-divisor-of-strings/discuss/303781/JavaPython-3-3-codes-each%3A-Recursive-iterative-and-regex-w-brief-comments-and-analysis.
        - 1. If longer string starts with shorter string, cut off the common prefix part of the longer string; repeat till one is empty, then the other is gcd string;
        - 2. If the longer string does NOT start with the shorter one, there is no gcd string.
    */
    public String gcdOfStrings(String str1, String str2) {
        //ensure str1 is the longer string
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }

        if (str2.length() == 0) {
            //found gcd
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
