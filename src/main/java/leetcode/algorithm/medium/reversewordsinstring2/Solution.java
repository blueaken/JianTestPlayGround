package leetcode.algorithm.medium.reversewordsinstring2;

/**
 * Created by jshe18 on 8/18/15.
 */
public class Solution {

    public static String reverseWords(String s) {
        char[] input = s.toCharArray();

        int end = input.length-1;
        int start = 0;

        swap(input, start, end);
        while (end>=0){
            while (end>=0 && input[end] == ' '){
                end--;
            }

            start = end;
            while (start>=0 && input[start]!=' '){
                start--;
            }
            start++;

            swap(input, start, end);
            end = start-1;
        }

        return new String(input);
    }


    private static void swap(char[] input, int start, int end) {
        while (start < end) {
            char temp = input[start];
            input[start++] = input[end];
            input[end--] = temp;
        }
    }

    public static void main(String[] args){
        String input = "the sky is blue";
//        String input = " ";
//        String input = "   a   ";

        System.out.println(reverseWords(input));
    }
}
