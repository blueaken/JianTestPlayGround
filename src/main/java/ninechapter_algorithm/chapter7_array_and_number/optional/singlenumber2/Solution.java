package ninechapter_algorithm.chapter7_array_and_number.optional.singlenumber2;

/**
 * Author: blueaken
 * Date: 5/26/16 11:25
 */
public class Solution {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public static int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int result = 0;
        int[] count = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                count[i] += (A[j] >> i) & 1;
            }
            result |= (count[i] % 3) << i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,3,3,3,2,2,4,1};
        System.out.println(singleNumberII(test));
    }
}
