package lintcode.math.median;

import java.util.*;
public class BestMeetingPlace_LE_296 {
    /**
     11.23.23
     - similar to 317, but diff is every point is reachable, we can use more time efficient way
     - ref https://www.bilibili.com/video/BV1Sv411M7uk/
     */
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        List<Integer> X = new LinkedList<>();
        List<Integer> Y = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }

        return getMedianDiffSum(X) + getMedianDiffSum(Y);
    }

    int getMedianDiffSum(List<Integer> list) {
        Collections.sort(list);
        int n = list.size();

        int median = list.get(n/2);
        int res = 0;
        for (Integer i : list) {
            res += Math.abs(i - median);
        }
        return res;
    }
}
