package ninechapter_algorithm.chapter2_binarysearch.required.findminimumrotatedsortedarray.second;

/**
 * Author: blueaken
 * Date: 4/12/16 2:46 PM
 */
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return num[start];
    }
}
