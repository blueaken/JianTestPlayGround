package ninechapter_algorithm.chapter8_data_structure.largestrectangleinhistogram;

/**
 * Author: blueaken
 * Date: 4/30/16 10:44
 */
public class Solution_Enumeration {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public static int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }

        //Enumeration O(n^2)
        int best = 0;
        for (int i = 0; i < height.length; i++) {
            //avoid duplicate calculation
            if (i != 0 && height[i] <= height[i - 1]) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = i; j < height.length; j++) {
                min = Math.min(height[j], min);
                int area = min * (j - i + 1);
                best = Math.max(area, best);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] test = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(test));
    }

}
