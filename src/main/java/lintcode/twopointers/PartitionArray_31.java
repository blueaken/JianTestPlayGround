package lintcode.twopointers;

public class PartitionArray_31 {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (start <= end && nums[start] < k) {
                start++;
            }
            while (start <= end && nums[end] >= k) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
        return start;
    }

    public static void main(String[] args) {
//        int[] input = {3,2,2,1};
//        int[] input = {7,7,9,8,6,6,8,7,9,8,6,6};
        int[] input = {3,2,3,3,2,1};
        int k = 2;

        PartitionArray_31 solution = new PartitionArray_31();
        System.out.println(solution.partitionArray(input, k));
    }
}
