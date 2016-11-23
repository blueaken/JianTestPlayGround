package ninechapter_algorithm.chapter4_dynamic_prgramming_1.jumpgame2.second;

/**
 * Author: blueaken
 * Date: 4/6/16 3:28 PM
 */
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public static int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        int n = A.length;
        int[] res = new int[n];
        res[0] = 0;

        //dp
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (res[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    res[i] = res[j] + 1;
                    break;
                }
            }
        }

        return res[n-1];
    }

    public static void main(String[] args) {
        int[] test = {2,3,1,1,4};
//        int[] test = {3,2,1,0,4};
//        int[] test = {4,6,9,5,9,3,0};

        System.out.println(jump(test));
    }
}
