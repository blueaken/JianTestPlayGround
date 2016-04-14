package ninechapter_algorithm.chapter2_binarysearch.otherrelated.sqrt;

/**
 * Author: blueaken
 * Date: 4/14/16 8:56 AM
 */
public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public static int sqrt(int x) {
        // write your code here
        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1;
        long end = x;
        while (start < end) {
            long mid = start + (end - start) / 2;
            long product = mid * mid;
            if (product == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return (int)start - 1;
    }

    public static void main(String[] args) {
//        int x = 10;
//        int x = 999999999;
        int x = 16;

        System.out.println(sqrt(x));
    }
}
