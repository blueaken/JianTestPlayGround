package leetcode.medium.maxproductsubarray;

import leetcode.Util;

/**
 * Created by jshe18 on 7/19/15.
 */
public class Solution_DP1 {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        int[][] product = new int[size][size];

        for (int i=0; i<size; i++){
            for (int j=i; j<size; j++){ //only calc the result when i<=j is enough
                if (i==j){
                    product[i][j] = nums[i];
                }
                else {
                    product[i][j] = product[i][j-1] * nums[j];
                }
            }
        }

        //Util.printGrid(product);

        int max = Integer.MIN_VALUE;
        for (int i=0; i<size; i++){
            for (int j=i; j<size; j++){
                max = Math.max(product[i][j], max);
            }
        }

        return max;
    }
}
