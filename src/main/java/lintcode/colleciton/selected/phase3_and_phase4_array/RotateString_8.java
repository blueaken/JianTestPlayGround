package lintcode.colleciton.selected.phase3_and_phase4_array;

public class RotateString_8 {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    //Key Idea: reverse 3 times to get the result
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0 || offset == 0) {
            return;
        }

        offset = offset % str.length;
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length -1);
        return;
    }

    private void reverse (char[] str, int start, int end) {
        while (end > start) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
        return;
    }
}
