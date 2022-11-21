package lintcode.binarysearch;

public class SingleNumber4_824 {
    /**
     * @param nums: The number array
     * @return: Return the single number
     */
    //Idea: 通过数组长度的奇数或者偶数判断下一步二分的位置
    //Ref - https://www.lintcode.com/problem/824/solution/25970
    public int getSingleNumber(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid-1]) {
                if ((mid - start + 1) % 2 == 1) {
                    end = mid - 2;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] == nums[mid+1]) {
                if ((end - mid + 1) % 2 == 1) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[start];
    }
}
