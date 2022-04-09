package lintcode.dynamicprogramming;

public class UniquePath_117_Rec {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

    public static void main(String[] args) {
        int m = 4, n = 6; //56
        UniquePath_117_Rec solution = new UniquePath_117_Rec();
        System.out.println(solution.uniquePaths(m, n));
    }
}
