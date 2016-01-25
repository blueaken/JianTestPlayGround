package leetcode.medium.lengthoflongestsubstring;

/**
 * Author: blueaken
 * Date: 1/24/16 5:40 PM
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        boolean[] map = new boolean[256];
        int start = 0;
        int max = 0;
        int length = s.length();
        for (int end = 0; end < length; end++){
            if (map[s.charAt(end)]){

                // the loop update the new start point
                // and reset flag array
                // for example, abccab, when it comes to 2nd c,
                // it update start from 0 to 3, reset flag for a,b
                while (s.charAt(start) != s.charAt(end)){
                    map[s.charAt(start)] = false;
                    start++;
                }
                start++;
            } else {
                map[s.charAt(end)] = true;
                max = Math.max(max, end-start+1);
            }
        }

        return max;
    }

    /*
       an elegant version from clean book below for refer - concise code, but still 2 iteration and O(n)
     */
//    public static int lengthOfLongestSubstring(String s) {
//        boolean[] map = new boolean[256];
//        int start = 0, maxLen = 0;
//        for (int end = 0; end < s.length(); end++) {
//            while (map[s.charAt(end)]) {
//                map[s.charAt(start)] = false;
//                start++;
//            }
//            map[s.charAt(end)] = true;
//            maxLen = Math.max(end - start + 1, maxLen);
//        }
//        return maxLen;
//    }

    public static void main (String[] args){
//        String input = "abcdabcdbb";
        String input = "abcdaefghi";
//        String input = "abccba";

        //String input = "bbbbbb";
        //String input = "aab";
        //String input = "abccbad";

        System.out.println(lengthOfLongestSubstring(input));
    }
}
