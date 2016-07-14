package leetcode.algorithm.medium.oneditdistance;

/**
 * Author: blueaken
 * Date: 1/27/16 3:25 PM
 */
public class Solution_Elegant {
    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m>n) return isOneEditDistance(t, s);

        int diff = n-m;
        if (diff>1) return false;

        int i=0;
        while (i<m && s.charAt(i)==t.charAt(i)) i++;
        if (i==m) return diff>0; //insert
        if (diff==0) i++;
        while (i<m && s.charAt(i)==t.charAt(i+diff)) i++;
        return i==m;
    }

    public static void main(String[] args){
//        String s1 = "abcd";
//        String s2 = "abce";

//        String s1 = "abcd";
//        String s2 = "abcde";

        String s1 = "abcd";
        String s2 = "abcdef";

        System.out.println("The 2 input strings are one edit away: " + isOneEditDistance(s1, s2));
    }
}
