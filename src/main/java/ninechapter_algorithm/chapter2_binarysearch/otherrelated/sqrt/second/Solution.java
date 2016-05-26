package ninechapter_algorithm.chapter2_binarysearch.otherrelated.sqrt.second;

/**
 * Author: blueaken
 * Date: 5/26/16 10:16
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

        long start = 1;
        long end = x;
        while (start < end) {
            long mid = (start + end) / 2;
            long product = mid * mid;
            if (product  == x) {
                return (int)mid;
            } else if (product < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int)start - 1;
    }
}
