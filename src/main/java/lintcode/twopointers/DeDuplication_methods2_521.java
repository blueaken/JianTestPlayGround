package lintcode.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeDuplication_methods2_521 {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    //Idea: 将不重复的数放到slow指向的位置，返回slow的总数
    //Ref: https://www.lintcode.com/problem/521/solution/16899
    public int deduplication(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if (fast == 0 || nums[fast] != nums[fast-1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] input = {1,2,7,7,2};

        DeDuplication_methods2_521 solution = new DeDuplication_methods2_521();
        System.out.println(solution.deduplication(input));
        System.out.println(Arrays.toString(input));
    }
}
