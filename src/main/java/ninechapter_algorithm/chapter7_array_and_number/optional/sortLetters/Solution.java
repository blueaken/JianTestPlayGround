package ninechapter_algorithm.chapter7_array_and_number.optional.sortLetters;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/29/16 10:23
 */
public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public char[] sortLetters(char[] chars) {
        //write your code here
        if (chars == null || chars.length == 0) {
            return null;
        }

        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            while (start < end && !Character.isUpperCase(chars[start])) {
                start++;
            }
            while (start < end && Character.isUpperCase(chars[end])) {
                end--;
            }
            if (start < end) {
                swap(chars, start, end);
            }
        }
        return chars;
    }

    private void swap(char[] chars, int start, int end) {
        char temp = chars[end];
        chars[end] = chars[start];
        chars[start] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] test = {'a','b','A','c','D'};
        System.out.println(Arrays.toString(solution.sortLetters(test)));
    }
}
