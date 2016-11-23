package leetcode.algorithm.easy.strstr.second;

/**
 * Author: blueaken
 * Date: 2/16/16 1:26 PM
 */
public class Solution {
    public static int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        int hind = 0;
        while (hind <= h){
            for (int nind = 0; ; nind++){
                if (nind == n) return hind;
                if (nind + hind == h) return -1;
                if (needle.charAt(nind) != haystack.charAt(hind+nind)) break;
            }
            hind++;
        }

        return -1;
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
