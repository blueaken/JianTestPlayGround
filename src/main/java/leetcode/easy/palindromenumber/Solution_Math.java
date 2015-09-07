package leetcode.easy.palindromenumber;

/**
 * Author: blueaken
 * Date: 9/7/15 9:14 AM
 */
public class Solution_Math {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;

        int div=1;
        int temp=x;
        while(temp>=10){
            temp/=10;
            div *= 10;
        }

        while (x!=0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;

            x = (x%div)/10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args){
//        int x = 123321;
        int x = 0;
//        int x = 321;
        System.out.println(isPalindrome(x));
    }
}
