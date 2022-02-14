package lintcode.binarySearch;

public class LastPosition_458 {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        // Idea1 : 标准模板的index在hit情况下返回第一个Index, 处理后再返回
        if (nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            while (start < nums.length && nums[start] == target) {
                start++;
            }
            return start - 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,2,2,3,4,5,5};
        int target = 2;

        LastPosition_458 solution = new LastPosition_458();
        System.out.println(solution.lastPosition(input,target));
    }
}
