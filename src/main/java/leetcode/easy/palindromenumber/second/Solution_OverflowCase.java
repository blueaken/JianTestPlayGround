package leetcode.easy.palindromenumber.second;

/**
 * Author: blueaken
 * Date: 1/30/16 11:06 AM
 */
public class Solution_OverflowCase {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;

        int div = 1;
        while (x/div>=10){
            div*=10;
        }

        while (x!=0){
            int l = x/div;
            int r = x%10;
            if (l!=r) return false;

            x= (x%div)/10;
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args){
//        int x = 123321;
//        int x = 0;
//        int x = 321;
        int x = 1001;

        System.out.println(isPalindrome(x));
    }
}
