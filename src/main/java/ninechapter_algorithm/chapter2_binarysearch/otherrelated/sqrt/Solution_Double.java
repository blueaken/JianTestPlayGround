package ninechapter_algorithm.chapter2_binarysearch.otherrelated.sqrt;

/**
 * Author: blueaken
 * Date: 4/14/16 9:34 AM
 */
public class Solution_Double {
    public static double sqrt(int x) {
        // write your code here
        if (x < 0) {
            return -1;
        }
        if (x < 2) {
            return x;
        }

        double start = 1;
        double end = x / 2 + 1;
        double epsilon = 0.001;
        while (start < end) {
            double mid = (start + end) / 2;
            double product = mid * mid;
            if (Math.abs(product - x) < epsilon) {
                return mid;
            } else if (product < x) {
                start = mid + epsilon;
            } else {
                end = mid;
            }
        }

        return start - epsilon;
    }

    public static void main(String[] args) {
        int x = 15;
//        int x = 999999999;
//        int x = 16;

        System.out.println(sqrt(x));
    }
}
