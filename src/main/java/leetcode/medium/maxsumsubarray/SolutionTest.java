package leetcode.medium.maxsumsubarray;

/**
 * Created by jshe18 on 7/15/15.
 */
public class SolutionTest {
    public static void main(String[] args){
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        int[] test1 = {-1};

        //Solution solution = new Solution();
        //Solution_DP solution = new Solution_DP();
        Solution_DivideConque solution = new Solution_DivideConque();

        //System.out.println("The max sum subarray of the test is: " + solution.maxSubArray(test));
        System.out.println("The max sum subarray of the test is: " + solution.maxSubArray(test1));
    }
}
