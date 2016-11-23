package leetcode.algorithm.binarysearch.searchrotatedsortedarray;

/**
 * Created by jshe18 on 8/1/15.
 */
public class SolutionTest {

    public static void main(String[] args){
//        int[] nums = {6,-3,1,2,3,4,5};//left
//        int[] nums = {4,5,6,7,8,9,10,11,12,-2,1,2,3};//right
//        int[] nums = {4,5,6,-2,1,2,3};//middle
        int[] nums = {1,2,3};
        System.out.println("location of the target is: "  + new Solution().search(nums, 99));
    }
}
