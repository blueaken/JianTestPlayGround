package leetcode.algorithm.binarysearch.searchrotatedsortedarray_duplicate_value;

/**
 * Created by jshe18 on 8/2/15.
 */
public class SolutionTest {
    public static void main(String[] args){
        int[] nums = {3,1,1};
//        int[] nums = {1,1,3,1};
        System.out.println("location of the target is: "  + new Solution().search(nums, 3));
    }
}
