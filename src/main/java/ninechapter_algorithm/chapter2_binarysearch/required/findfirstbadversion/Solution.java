package ninechapter_algorithm.chapter2_binarysearch.required.findfirstbadversion;

import type.VersionControl;

/**
 * Author: blueaken
 * Date: 2/25/16 9:08 AM
 */
public class Solution {
    public static int findFirstBadVersion(int n) {
        // write your code here
        int end = n;
        int start = 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            if (!VersionControl.isBadVersion(mid)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

    public static void main (String[] args){
        int test = 10;

        System.out.println(findFirstBadVersion(test));
    }

}
