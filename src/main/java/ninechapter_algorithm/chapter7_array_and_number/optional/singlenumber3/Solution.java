package ninechapter_algorithm.chapter7_array_and_number.optional.singlenumber3;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/26/16 15:52
 */
public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }

        //1. get xor result of num1 and num2
        int xor = 0;
        for (int x : A) {
            xor ^= x;
        }

        //2. find the rightmost different bit between num1 and num2
        int mask = 1;
        while ((xor & mask) == 0) {
            mask = mask << 1;
        }

        //3. diff the input array with the diff bit and find the result
        int num1 = 0;
        int num2 = 0;
        for (int x : A) {
            if ((x & mask) == 0) {
                num1 ^= x;
            } else {
                num2 ^= x;
            }
        }
        result.add(num1);
        result.add(num2);

        return result;
    }
}
