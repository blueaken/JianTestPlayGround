package leetcode.hard.findminrotatedsortedarray_duplicate_value;

/**
 * Created by jshe18 on 8/1/15.
 */
public class SolutionTest {
    public static void main(String[] args){
//        int[] nums = {6,-3,1,2,3,4,5};//left
//        int[] nums = {1,1,3,1};
//        int[] nums = {3,1,1};
        int[] nums = {3,1,3};
        System.out.println("min value from the rotated array is: "  + new Solution().findMin(nums));
    }
}
