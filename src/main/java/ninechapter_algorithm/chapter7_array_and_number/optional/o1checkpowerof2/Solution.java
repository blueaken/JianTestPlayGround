package ninechapter_algorithm.chapter7_array_and_number.optional.o1checkpowerof2;

/**
 * Author: blueaken
 * Date: 5/26/16 07:50
 */
public class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n < 0) {
            return false;
        }

        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count == 1;
    }
}
