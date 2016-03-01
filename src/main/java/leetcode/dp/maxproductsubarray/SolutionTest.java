package leetcode.dp.maxproductsubarray;

/**
 * Created by jshe18 on 7/19/15.
 */
public class SolutionTest {
    public static void main(String[] args){
        int[] test = {2,4,-5,-1};
        int[] test1 = {-1};

        //Solution solution = new Solution();
        //Solution_DP1 solution = new Solution_DP1();
        Solution_DP2 solution = new Solution_DP2();

        //System.out.println("The max product subarray of the test is: " + solution.maxProduct(test));
        System.out.println("The max product subarray of the test is: " + solution.maxProduct(test));
    }
}
