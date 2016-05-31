package ninechapter_algorithm.chapter8_data_structure.largestrectangleinhistogram.second;

/**
 * Author: blueaken
 * Date: 5/31/16 10:21
 */
public class Solution_Enumeration {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height ==  null || height.length == 0) {
            return 0;
        }

        int best = 0;
        for (int i = 0; i < height.length; i++) {
            int min = height[i];
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
        Solution_Enumeration solution = new Solution_Enumeration();
        System.out.println(solution.largestRectangleArea(test));
    }
}
