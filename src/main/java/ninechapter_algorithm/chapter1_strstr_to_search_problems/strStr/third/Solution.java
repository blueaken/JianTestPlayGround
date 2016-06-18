package ninechapter_algorithm.chapter1_strstr_to_search_problems.strStr.third;

/**
 * Author: blueaken
 * Date: 6/17/16 19:20
 */
public class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }

        int lenS = source.length();
        int lenT = target.length();
        for (int i = 0; ;i++) {
            for (int j = 0; ;j++) {
                if (j == lenT) {
                    return i;
                }
                if (i + j == lenS) {
                    return -1;
                }
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
        }
    }
}
