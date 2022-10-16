package lintcode.dynamicprogramming2.backpack;

import java.util.Arrays;

public class BackPack_92 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    //Idea: Ref - https://www.youtube.com/watch?v=8LusJS5-AGo，其实是BackPack2
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        //init
        Arrays.sort(A);
        int n = A.length;
        int res[][] = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            res[i][0] = 0;
        }

        //dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < A[i-1]) {
                    res[i][j] = res[i-1][j];
                } else {
                    //j >= A[i-1], A[i-1] weight can be picked
                    res[i][j] = Math.max(A[i-1] + res[i-1][j-A[i-1]], res[i-1][j]);
                }

            }
        }

        return res[n][m];
    }
}
