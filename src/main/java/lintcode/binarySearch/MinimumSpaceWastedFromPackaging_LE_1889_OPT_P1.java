package lintcode.binarySearch;

import java.util.Arrays;

public class MinimumSpaceWastedFromPackaging_LE_1889_OPT_P1 {
    /*
        ref - https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/2201322/Java-solution.-PrefixSum-%2B-BinarySearch
        - for each supplier's boxes, find the waste space to hold all packages, and return min
        - use binary search to find the best fit box for certain package
        - Time is O(KLogM) + O(KNLogM), K - number of suppliers, N - number of packages, M - the longest size of boxes
          ~= O(KNLogM), still got TLE
          =======================================
          Read Huifeng guan video and got the trick here is "sum(boxes[j].length) <= 10^5", instead of BS on the box arr, should BS on the package arr, thus Time is O(KMLogN), althouth K and M are both 10^5 level size, but since "sum(boxes[j].length) <= 10^5", K * M itself still a 10^5 size, make the total Time accetptable;

          package: [X X X] [X X X X] ... ... X X X
                        j   next j covers
              box: Y Y Y Y
                   i

          - use presum on packages arr to improve the calc of total used package size
          - many corner cases to consider in this solution
          - refactor the code, after read https://leetcode.com/problems/minimum-space-wasted-from-packaging/discuss/1914249/Simple-Solution-in-Java-oror-Elegant-and-Concise-oror-Binary-Search-and-Prefix-Sum
          =======================================
          P1
          - refactor the find() with upBound() template
          ============================================
    */
    public int minWastedSpace(int[] packages, int[][] boxes) {
        int mod = (int)1e9 + 7;
        long ans = -1;

        Arrays.sort(packages);

        int n = packages.length;
        long[] ps = new long[n];
        ps[0] = packages[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i-1] + packages[i];
        }

        for (int[] box : boxes) {
            Arrays.sort(box);

            int m = box.length;
            if(packages[n - 1] > box[m - 1]){ // Box of required size not present
                continue;
            }

            int lastPackagePos = -1;
            long waste = 0l;

            for (int i = 0; i < m; i++) {
                if(box[i] < packages[lastPackagePos+1]) {
                    continue;
                }

                //find upper package position can by hold by box[i]
                int packagePos = find(packages, lastPackagePos, box[i]);

                //the current box is able to handle package from [lastPackagePos + 1 to packagePos]
                int numPackagesForCurrentBox = packagePos - lastPackagePos;
                long totalSpace = (long)numPackagesForCurrentBox * box[i];
                long totalPackageSize = ps[packagePos] - (lastPackagePos == -1 ? 0 : ps[lastPackagePos]);
                long spaceWastedCurr = totalSpace - totalPackageSize;
                waste += spaceWastedCurr;

                //if reached last package, then break the current box array loop
                if (packagePos == n - 1) {
                    ans = ans == -1 ? waste : Math.min(ans, waste);
                    break;
                }

                lastPackagePos = packagePos;
            }
        }


        return (int)(ans % mod);
    }

    //find the package pos where it can barely hold by the input boxSize - similar to C++ upbound() - 1
    private int find(int[] arr, int lastPos, int val) {
        int l = lastPos + 1, h = arr.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (arr[m] <= val) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        //当Key大于数组范围或者等于最后一个元素时，返回最大地址+1
        if (arr[l] <= val) {
            l++;
        }

        return l-1;
    }
}
