package ninechapter_algorithm.chapter2_binarysearch.optional.findminimumrotatedsortedarray2;

/**
 * Author: blueaken
 * Date: 4/13/16 3:41 PM
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
        while (start < end && num[start] >= num[end]) {
            int mid = (start + end) / 2;
            if (num[mid] > num[end]) {
                start = mid + 1;
            } else if (num[mid] < num[start]) {
                end = mid;
            } else {
                //num[mid] = num[left] = num[right]
                start++;
            }
        }

        return num[start];
    }
}
