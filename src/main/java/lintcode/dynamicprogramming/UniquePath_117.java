package lintcode.dynamicprogramming;

public class UniquePath_117 {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] res = new int[m][n];

        //init
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }

        //dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }

        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 1, n = 3;
        UniquePath_117 solution = new UniquePath_117();
        System.out.println(solution.uniquePaths(m, n));
    }
}
