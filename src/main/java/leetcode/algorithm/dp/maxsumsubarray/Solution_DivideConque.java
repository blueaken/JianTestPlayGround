package leetcode.algorithm.dp.maxsumsubarray;

/**
 * Created by jshe18 on 7/16/15.
 */
public class Solution_DivideConque {
    public int maxSubArray(int[] nums) {
        return rec(nums, 0, nums.length-1);
    }

    private int rec(int[] data, int left, int right){
        if (left >  right){
            return Integer.MIN_VALUE;
        }
        int mid = (left+right)/2;
        int lResult = rec(data, left, mid-1);
        int rResult = rec(data, mid+1, right);

        int sum = 0;
        int lMax = 0;
        for (int i=mid-1;i>=left;i--){
            sum += data[i];
            lMax = Math.max(sum, lMax);
        }

        sum = 0;
        int rMax = 0;
        for (int i=mid+1;i<=right;i++){
            sum += data[i];
            rMax = Math.max(sum, rMax);
        }

        return Math.max(lMax+data[mid]+rMax, Math.max(lResult, rResult));
    }
}
