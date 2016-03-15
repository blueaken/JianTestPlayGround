package ninechapter_algrithem.chapter1_strstr_to_search_problems.strStr;

/**
 * Author: blueaken
 * Date: 2/21/16 3:17 PM
 */
public class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public static int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) return -1;

        int sLen = source.length();
        int tLen = target.length();

        for (int i=0; ; i++){
            for (int j=0; ; j++){
                if (j == tLen){
                    return i;
                }
                if (i+j == sLen){
                    return -1;
                }
                if (target.charAt(j) != source.charAt(i+j)){
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        String haystack = "asdfsadfsa";
        String needle = "x";
        System.out.println(strStr(haystack, needle));

        haystack = "a";
        needle = "a";
        System.out.println(strStr(haystack, needle));

        haystack = "aaa";
        needle = "aaaa";
        System.out.println(strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issip";
        System.out.println(strStr(haystack, needle));

        haystack = "";
        needle = "";
        System.out.println(strStr(haystack, needle));
    }

}
