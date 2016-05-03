package ninechapter_algorithm.chapter8_data_structure.optional.uglynumber1;

/**
 * Author: blueaken
 * Date: 5/3/16 11:13
 */
public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // Write your code here
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;

        }

        while (num >= 5 && num % 5 == 0) {
            num /= 5;
        }
        while (num >= 3 && num % 3 == 0) {
            num /= 3;
        }
        while (num >= 2 && num % 2 == 0) {
            num /= 2;
        }

        return num == 1;
    }
}
