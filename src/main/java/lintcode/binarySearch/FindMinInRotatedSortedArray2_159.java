package lintcode.binarySearch;

public class FindMinInRotatedSortedArray2_159 {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    //Idea: 由于有duplicates，可能有111111111011111，BS不适合使用，只能O(N)循环数组一遍
    //或者：发现Mid和头尾相等时，进行end--或者start++来缩小范围，能比O(N)好些的Performance
    public int findMin(int[] nums) {
        // write your code here
        //Idea 2
        if (nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] > nums[start]) {
                end = mid - 1;
            } else {
                end--;
            }
        }
        return nums[start];

//        //Idea 1
//        if (nums.length == 0) {
//            return -1;
//        }
//
//        int start = 0, end = nums.length - 1;
//        while (start < end) {
//            int mid = (start + end) >> 1;
//            if (nums[mid] > nums[nums.length-1]) {
//                start = mid + 1;
//            } else {
//                end = mid;
//            }
//        }
//        return nums[start];
    }
}
