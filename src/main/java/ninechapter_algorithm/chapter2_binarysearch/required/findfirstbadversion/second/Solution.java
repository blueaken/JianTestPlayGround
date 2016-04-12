package ninechapter_algorithm.chapter2_binarysearch.required.findfirstbadversion.second;

import type.VersionControl;

/**
 * Author: blueaken
 * Date: 4/12/16 3:42 PM
 */
public class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
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
