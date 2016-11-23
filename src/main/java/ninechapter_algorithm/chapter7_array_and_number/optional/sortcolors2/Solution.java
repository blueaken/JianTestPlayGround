package ninechapter_algorithm.chapter7_array_and_number.optional.sortcolors2;

import java.util.Arrays;

/**
 * Author: blueaken
 * Date: 5/28/16 11:04
 */
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public int[] sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || k > colors.length) {
            return colors;
        }

        int minColorPos = 0;
        int maxColorPos = colors.length - 1;
        int minColor = 1;
        int maxColor = k;
        int cur = 0;
        while (minColor < maxColor) {
            while (cur <= maxColorPos) {
                if (colors[cur] == minColor) {
                    swap(colors, cur, minColorPos);
                    cur++;
                    minColorPos++;
                } else if (colors[cur] == maxColor) {
                    swap(colors, cur, maxColorPos);
//                    cur++;
                    maxColorPos--;
                } else {
                    cur++;
                }
            }
            minColor++;
            maxColor--;
            cur = minColorPos;
        }
        return colors;
    }

    private void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {3,2,3,4,3,1,3,4,2};
        int k = 4;
        System.out.println(Arrays.toString(solution.sortColors2(test, k)));
    }
}
