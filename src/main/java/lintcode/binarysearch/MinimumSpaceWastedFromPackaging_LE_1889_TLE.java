package lintcode.binarysearch;

import java.util.Arrays;

public class MinimumSpaceWastedFromPackaging_LE_1889_TLE {
    /*
        ref - https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/2201322/Java-solution.-PrefixSum-%2B-BinarySearch
        - for each supplier's boxes, find the waste space to hold all packages, and return min
        - use binary search to find the best fit box for certain package
        - Time is O(KLogM) + O(KNLogM), K - number of suppliers, N - number of packages, M - the longest size of boxes
          ~= O(KNLogM), still got TLE
    */
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int mod = (int)1e9 + 7;
        long ans = Long.MAX_VALUE;

        //sort first for the binary search
        for (int[] box : boxes) {
            Arrays.sort(box);
        }

        for (int[] box : boxes) {
            long waste = 0;
            for (int i = 0; i < packages.length; i++) {
                int boxSize = find(box, packages[i]);
                if (boxSize == -1) {
                    break;
                }
                waste += boxSize - packages[i];
                //note: put the ans comparing here in case there is no right size box
                if (i == packages.length-1) {
                    ans = Math.min(ans, waste);
                }
            }
        }
        return ans == Long.MAX_VALUE ? -1 : (int)(ans % mod);
    }

    private int find(int[]box, int val) {
        int l = 0, r = box.length - 1;
        if (box[r] < val) {
            return -1;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (box[mid] < val) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return box[l];
    }
}
