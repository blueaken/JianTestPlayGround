package lintcode.twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeDuplication_521 {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }

        Set<Integer> set = new HashSet<>();
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (set.contains(nums[left])) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right--] = temp;
            } else {
                set.add(nums[left++]);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = {1,2,7,7,2};

        DeDuplication_521 solution = new DeDuplication_521();
        System.out.println(solution.deduplication(input));
        System.out.println(Arrays.toString(input));
    }
}
