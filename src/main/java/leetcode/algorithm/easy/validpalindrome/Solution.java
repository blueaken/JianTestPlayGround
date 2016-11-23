package leetcode.algorithm.easy.validpalindrome;

/**
 * Author: blueaken
 * Date: 12/10/15 9:50 PM
 */
public class Solution {
    public static boolean isPalindrome(String s) {
        char[] input = s.toCharArray();
        int i =  0;
        int j = input.length-1;
        while (i<j){
            while (!Character.isLetterOrDigit(input[i]) && (i<j)){
                i++;
            }
            while (!Character.isLetterOrDigit(input[j]) && (i<j)){
                j--;
            }

            if (Character.toString(input[i++]).equalsIgnoreCase(Character.toString(input[j--]))){
                continue;
            }
            return false;

        }
        return true;
    }

    public static void main(String[] args){
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
    }
}
