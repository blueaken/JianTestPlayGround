package lintcode.dynamicprogramming2.backpack;

public class BackPackII_125 {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    //Idea: similar to backPackI's solution, ref Tushar Roy's youtube video
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (A == null || A.length == 0 || V == null || V.length == 0
                || A.length != V.length) {
            return 0;
        }

        //init
        int size = A.length;
        int[][] res = new int[size + 1][m + 1];

        //dp
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i-1] > j) {
                    res[i][j] = res[i-1][j];
                } else {
                    res[i][j] = Math.max(res[i-1][j], V[i-1] + res[i-1][j - A[i-1]]);
                }
            }
        }

        return res[size][m];
    }

    public static void main(String[] args) {
        int m = 5;
        int[] A = {1, 3, 4};
        int[] V = {2, 5, 8};

        BackPackII_125 solution = new BackPackII_125();
        System.out.println(solution.backPackII(m, A, V));
    }
}
