package ninechapter_algorithm.chapter1_strstr_to_search_problems.strStr.second;

/**
 * Author: blueaken
 * Date: 6/11/16 13:52
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
        if (source == null || target == null) return -1;

        int lenS = source.length();
        int lenT = target.length();
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == lenT) {
                    return i;
                }
                if ((i + j) == lenS) {
                    return -1;
                }
                if (target.charAt(j) != source.charAt(i + j) ) {
                    break;
                }
            }
        }
    }
}
