package leetcode.algorithm.medium.reversewordsinstring2.second;

/**
 * Author: blueaken
 * Date: 12/11/15 4:48 PM
 */
public class Solution {
    public static String reverseWords(String s) {
        if (s.length()==0) return "";
        char[] input = s.toCharArray();
        reverse(input, 0, input.length - 1);

        int start = 0;
        int end = start;
        while (end<input.length-1){
            while (input[end] != ' ' && end<input.length-1) {
                end++;
            }

            if (end!=input.length-1){
                reverse(input, start, end-1);
                start = end+1;
                end = start;
            } else{
                reverse(input, start, end);
            }
        }

        return String.valueOf(input);
    }

    private static void reverse(char[] original, int start, int end){
        char temp;
        while (start < end){
            temp = original[start];
            original[start] = original[end];
            original[end] = temp;
            start++; end--;
        }
        return;
    }

    public static void main(String[] args){
        String input = "the sky is blue";
//        String input = " ";

        System.out.println(reverseWords(input));
    }
}
