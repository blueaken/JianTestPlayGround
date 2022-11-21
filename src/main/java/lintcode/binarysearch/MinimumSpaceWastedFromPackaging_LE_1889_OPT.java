package lintcode.binarysearch;

import java.util.Arrays;

public class MinimumSpaceWastedFromPackaging_LE_1889_OPT {
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
                //if reached last package, then break the current box array loop
                if (lastPackagePos == n - 1) {
                    break;
                }

                if(box[i] < packages[0] || box[i] < packages[lastPackagePos+1]) {
                    continue;
                }

                //find upper package position can by hold by box[i]
                int packagePos = find(packages, lastPackagePos, box[i]);
                if (packagePos == -1) {
                    continue;
                }

                //the current box is able to handle package from [lastPackagePos + 1 to packagePos]
                int numPackagesForCurrentBox = packagePos - lastPackagePos;
                long totalSpace = (long)numPackagesForCurrentBox * box[i];
                long totalPackageSize = ps[packagePos] - (lastPackagePos == -1 ? 0 : ps[lastPackagePos]);
                long spaceWastedCurr = totalSpace - totalPackageSize;
                waste += spaceWastedCurr;

                lastPackagePos = packagePos;
            }

            ans = ans == -1 ? waste : Math.min(ans, waste);
        }


        return (int)(ans % mod);
    }

    //find the package pos where it can barely hold by the input boxSize - similar to C++ upbound()
    private int find(int[]packages, int lastPackagePos, int boxSize) {
        int l = lastPackagePos + 1, r = packages.length - 1;
        if (boxSize < packages[l]) {
            return -1;
        }

        while (l < r) {
            int mid = r - (r - l) / 2;
            if (packages[mid] <= boxSize) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }

    public static void main(String[] args) {
        MinimumSpaceWastedFromPackaging_LE_1889_OPT solution = new MinimumSpaceWastedFromPackaging_LE_1889_OPT();
//        int[] packages = {2,3,5};
//        int[][] boxes = {{4,8},{2,8}};
//        //expect 6

//        int[] packages = {3,5,8,10,11,12};
//        int[][] boxes = {{12},{11,9},{10,5,14}};
//        //expect 9

        int[] packages = {2,3,5};
        int[][] boxes = {{1,4},{2,3}};
        //expect -1

        System.out.println(solution.minWastedSpace(packages, boxes));
    }
}
