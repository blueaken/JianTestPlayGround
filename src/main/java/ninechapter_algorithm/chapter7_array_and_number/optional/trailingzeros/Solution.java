package ninechapter_algorithm.chapter7_array_and_number.optional.trailingzeros;

/**
 * Author: blueaken
 * Date: 5/27/16 12:24
 */
public class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    /*
    public long trailingZeros(long n) {
        // write your code here
        if (n <= 0) {
            return -1;
        }
        int x = 5;
        int res = 0;
        while (n > x) {
            res += n / x;
            x *= 5;
        }
        return res;
    }
     */
}
