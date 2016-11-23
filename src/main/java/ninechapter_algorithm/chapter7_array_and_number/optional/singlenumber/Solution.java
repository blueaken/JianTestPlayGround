package ninechapter_algorithm.chapter7_array_and_number.optional.singlenumber;

/**
 * Author: blueaken
 * Date: 5/26/16 10:40
 */
public class Solution {
    /**
     *@param A : an integer array
     *return : a integer
     */
    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        for (int x : A) {
            result ^= x;
        }
        return result;
    }
}
