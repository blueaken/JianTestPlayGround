package ninechapter_algorithm.chapter8_data_structure.uglynumber2;

/**
 * Author: blueaken
 * Date: 5/3/16 11:40
 */
public class Solution_Naive {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public static int nthUglyNumber(int n) {
        // Write your code here
        int candidate = 0;
        int count = 1;
        while (count < n) {
            while (!isUglyNumber(candidate)) {
                candidate++;
            }
            candidate++;
            count++;
        }
        while (!isUglyNumber(candidate)) {
            candidate++;
        }

        return candidate;
    }

    private static boolean isUglyNumber(int candidate) {
        if (candidate <= 0) {
            return false;
        }
        if (candidate == 1) {
            return true;
        }

        while (candidate >= 5 && candidate % 5 == 0) {
            candidate /= 5;
        }
        while (candidate >= 3 && candidate % 3 == 0) {
            candidate /= 3;
        }
        while (candidate >= 2 && candidate % 2 == 0) {
            candidate /= 2;
        }
        return candidate == 1;
    }

    public static void main(String[] args) {
        int n = 7;

        System.out.println(nthUglyNumber(n));
    }
}
