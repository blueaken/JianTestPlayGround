package leetcode.medium.implementstrstr;

/**
 * Author: blueaken
 * Date: 12/10/15 10:48 PM
 */
public class Solution {
    public static int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if (hLen<nLen) return -1;

        if (nLen==0) return 0;

        int i = 0;
        int j = 0;
        while(i<hLen && j<nLen){
            if (haystack.charAt(i)!=needle.charAt(j)){
                i++;
                continue;
            }

            int temp = i;
            if ((hLen-temp)<nLen) break;
            while (haystack.charAt(i++) == needle.charAt(j++) && j<nLen && i<hLen){
                continue;
            }
            if (haystack.charAt(--i) == needle.charAt(--j)) {
                return temp;
            } else {
                j = 0;
                i = temp+1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
//        String haystack = "thhhhhhethethe";
//        String needle = "he";

//        String haystack = "aaa";
//        String needle = "aaaa";

//        String haystack = "mississippi";
//        String needle = "issip";

//        String haystack = "mississippi";
//        String needle = "issipi";

//        String haystack = "";
//        String needle = "";

//        String haystack = "a";
//        String needle = "";

        String haystack = "";
        String needle = "a";

        System.out.println(strStr(haystack, needle));
    }
}
