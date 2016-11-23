package ninechapter_algorithm.chapter2_binarysearch.otherrelated.sqrt.third;

/**
 * Author: blueaken
 * Date: 6/24/16 09:02
 */
public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x < 0) {
            return -1;
        }
        if (x < 2) {
            return x;
        }

        long start = 2;
        long end = x;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long sqr = mid * mid;
            if (sqr == x) {
                return (int)mid;
            } else if (sqr < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)start - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 999999999;
        System.out.println(solution.sqrt(x));
    }
}
