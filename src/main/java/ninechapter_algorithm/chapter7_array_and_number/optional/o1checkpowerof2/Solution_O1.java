package ninechapter_algorithm.chapter7_array_and_number.optional.o1checkpowerof2;

/**
 * Author: blueaken
 * Date: 5/26/16 08:00
 */
public class Solution_O1 {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
