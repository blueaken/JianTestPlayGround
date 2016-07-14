package leetcode.algorithm.easy.stringtointeger.second;

/**
 * Author: blueaken
 * Date: 1/3/16 3:56 PM
 */
public class Solution {
    public final static int maxDIV10 = Integer.MAX_VALUE/10;

    public static int atoi(String str) {
        int i = 0;
        int n = str.length();

        while (i<n && Character.isWhitespace(str.charAt(i))) i++;

        int sign = 1;
        if (i<n && str.charAt(i) == '+') {
            i++;
        }
        else if (i<n && str.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        int num = 0;
        while (i<n && Character.isDigit(str.charAt(i))){
            int digit = Character.getNumericValue(str.charAt(i));
            //overflow handling
            if (num > maxDIV10 || (num ==  maxDIV10 && digit>7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args){
//        String input = "234";
//        String input = "234bcv";
//        String input = "-234";
//        String input = "-234bcv";
//        String input = "   ";
//        String input = "+234";
//        String input = "bc345";
//        String input = String.valueOf(Integer.MAX_VALUE);
//        String input = "9223372036854775809";
//        String input = "2147483642";
        String input = "+-2";

        System.out.println(atoi(input));
    }

}
