package lintcode.twopointers;

public class PartitionArrayOddAndEven_373 {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }

        //init
        int oddIdx = 0, evenIdx = 0;
        boolean startOdd = nums[0] % 2 == 1;
        boolean startEven = nums[0] % 2 == 0;
        while (nums[oddIdx] % 2 != 1) {
            oddIdx++;
        }
        while (nums[evenIdx] % 2 != 0) {
            evenIdx++;
        }
        if (startOdd) {
            oddIdx++;
            while (nums[oddIdx] % 2 != 1) {
                oddIdx++;
            }
        }
        if (startEven) {
            evenIdx++;
            while (nums[evenIdx] % 2 != 1) {
                evenIdx++;
            }
        }

        while (evenIdx < nums.length && oddIdx < nums.length) {
            swap(nums, oddIdx, evenIdx);
            while (evenIdx < nums.length && nums[evenIdx] % 2 != 0) {
                evenIdx++;
            }
            while (oddIdx < nums.length && nums[oddIdx] % 2 != 1) {
                oddIdx++;
            }
        }
        return;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,3,5,6};

        PartitionArrayOddAndEven_373 solution = new PartitionArrayOddAndEven_373();
        solution.partitionArray(nums);
    }
}
