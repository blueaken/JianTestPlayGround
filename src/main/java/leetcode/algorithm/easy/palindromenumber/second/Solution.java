package leetcode.algorithm.easy.palindromenumber.second;

/**
 * Author: blueaken
 * Date: 1/30/16 10:50 AM
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;

        int y = x;
        int rev = 0;
        while (y!=0){
            rev = rev*10 + y%10;
            y = y/10;
        }

        return rev==x;
    }

    public static void main(String[] args){
//        int x = 123321;
//        int x = 0;
//        int x = 321;
        int x = 1999999999;

        System.out.println(isPalindrome(x));
    }
}
