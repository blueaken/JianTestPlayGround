package lintcode.binarySearch;

public class SearchRotatedSortedArray_LE_33 {
    /*
        - many different ways to attack this, the key is the positioin between mid and left
        - refactor previous solution following an easier to understand version -  https://leetcode.com/problems/search-in-rotated-sorted-array/solution/
    */
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return m;
            }

            if (nums[m] >= nums[l]) { //if left half is sorted
                //target in sorted range
                if (target >= nums[l] && target <= nums[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[m] < nums[l]) { //if right half is sorted
                //target in sorted range
                if (target >= nums[m] && target <= nums[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return nums[l] == target ? l : -1;

    }
}
