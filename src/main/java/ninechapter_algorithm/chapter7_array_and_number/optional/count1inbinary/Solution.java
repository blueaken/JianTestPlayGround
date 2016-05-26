package ninechapter_algorithm.chapter7_array_and_number.optional.count1inbinary;

/**
 * Author: blueaken
 * Date: 5/26/16 08:29
 */
public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
