package ninechapter.chapter4_dynamic_prgramming_1.jumpgame2;

/**
 * Author: blueaken
 * Date: 3/3/16 10:28 AM
 */
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        int[] result = new int[A.length];
        result[0] = 0;

        //dp it
        for (int i = 1; i < A.length; i++) {
            result[i] = -1;
            for (int j = 0; j < i; j++) {
                if (result[j] != -1 && (i - j) <= A[j]){
                    result[i] = result[j] + 1;
                    break;
                }
            }
        }
        return result[A.length-1];
    }

    public static void main(String[] args) {
//        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
        int[] test = {4,6,9,5,9,3,0};

        System.out.println(jump(test));
    }
}
