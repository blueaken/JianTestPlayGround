package ninechapter_algorithm.chapter2_binarysearch.otherrelated.rotatestring;

/**
 * Author: blueaken
 * Date: 4/14/16 10:52 AM
 */
public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            //err handling
            return;
        }

        int n = str.length;
        offset = offset % n;
        reverse(str, 0, n - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, n - 1);
    }

    private static void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] test = {'a','b','c','d','e'};
        int offset = 2;

        rotateString(test, offset);
    }
}
