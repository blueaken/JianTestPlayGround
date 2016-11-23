package leetcode.algorithm.easy.palindromenumber;

/**
 * Author: blueaken
 * Date: 9/6/15 10:57 PM
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        String input = Integer.toString(x);
        int start = 0;
        int end = input.length()-1;
        while (start<end){
            if(input.charAt(start++)!=(input.charAt(end--))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        //int x = 123321;
//        int x = 0;
        int x = 321;
        System.out.println(isPalindrome(x));
    }
}
