package leetcode.medium.oneditdistance;

/**
 * Author: blueaken
 * Date: 1/27/16 2:59 PM
 */
public class Solution {
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int diff = m-n;

        if (Math.abs(diff)>1) return false;
        if (diff==0){
            int numOfDiffChar = 0;
            int i=0;
            while (i<m){
                if (s.charAt(i)!=t.charAt(i)){
                    numOfDiffChar++;
                }
                if (numOfDiffChar>1) return false;
                i++;
            }
            return true;
        } else {

        }

        return false;
    }

    public static void main(String[] args){
        String s1 = "abcd";
        String s2 = "abce";

        System.out.println("The 2 input strings are one edit away: " + isOneEditDistance(s1, s2));
    }
}
