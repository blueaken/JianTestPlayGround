package ninechapter_algorithm.chapter2_binarysearch.required.findfirstbadversion.third;

import type.VersionControl;

/**
 * Author: blueaken
 * Date: 6/23/16 11:43
 */
public class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n < 1) {
            return n;
        }

        int start = 1;
        int end = n;
        while (start < end) {
            int mid = (start + end) / 2;
            if (!VersionControl.isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
