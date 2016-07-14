package leetcode.algorithm.dp.maxproductsubarray;

/**
 * Created by jshe18 on 7/19/15.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        int[][] product = new int[size][size];

        int temp;
        for (int i=0; i<size; i++){
            for (int j=i; j<size; j++){ //only calc the result when i<=j is enough
                if (i==j){
                    product[i][j] = nums[i];
                }
                else {
                    temp = nums[i];
                    for (int k=i+1; k<=j; k++){
                        temp = temp * nums[k];
                    }
                    product[i][j] = temp;
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
