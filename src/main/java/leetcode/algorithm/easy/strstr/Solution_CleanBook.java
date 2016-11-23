package leetcode.algorithm.easy.strstr;

/**
 * Created by jshe18 on 8/13/15.
 */
public class Solution_CleanBook {
    public static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            } }
    }

    public static void main(String[] args){
//        String haystack = "asdfsadfsa";
//        String needle = "x";

//        String haystack = "a";
//        String needle = "a";

//        String haystack = "mississippi";
//        String needle = "issip";

        String haystack = "aaaaaaaaaaa";
        String needle = "aaaaaaaaaab";

        System.out.println(strStr(haystack, needle));
    }
}
