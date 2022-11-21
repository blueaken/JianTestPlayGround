package lintcode.binarysearch;

public class BinarySearch_14 {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start] == target ? start : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4,5,7,7,8,9,9,10};
        int target = 9;

        BinarySearch_14 solution = new BinarySearch_14();
        System.out.println(solution.binarySearch(nums, target));
    }
}
