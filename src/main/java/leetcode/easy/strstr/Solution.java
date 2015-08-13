package leetcode.easy.strstr;

/**
 * Created by jshe18 on 8/9/15.
 */
public class Solution {
    public static int strStr(String haystack, String needle) {
        int hlength = haystack.length();
        int nlength = needle.length();
//        if (hlength<nlength) return -1;
//        if (nlength==0) return 0;

        int hstart = 0;
        int nstart = 0;
        while (hstart<=hlength-1){
//            while ((hstart<=hlength-1) && (haystack.charAt(hstart)!=needle.charAt(nstart))) hstart++;
//            if ((hlength-hstart)<nlength) return -1;
//            int hindex = hstart;
            while (nstart<=nlength-1) {
                if (haystack.charAt(hstart) != needle.charAt(nstart)) break;
                hstart++;
                nstart++;
            }
        }

        return -1;
    }

    public static void main(String[] args){
//        String haystack = "asdfsadfsa";
//        String needle = "x";

//        String haystack = "a";
//        String needle = "a";

        String haystack = "mississippi";
        String needle = "issip";

        System.out.println(strStr(haystack, needle));
    }
}
