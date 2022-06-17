package lintcode.dynamicprogramming2;

public class NumRollsToTarget_LE_1155 {
    //try dp
    public int numRollsToTarget(int n, int k, int target) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 || target == 0) {
            return 0;
        }

        int[][] res = new int[n+1][target+1];
        res[0][0] = 1;
        int mod = (int)1e9 + 7;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                //skip the calculation if j bigger than max possible value
                if (j > i * k) {
                    continue;
                }
                for (int m = 1; m <= k && m <= j; m++) {
                    res[i][j] = (res[i][j] + res[i-1][j-m]) % mod;
                }
            }
        }
        return res[n][target];
    }

    public static void main(String[] args) {
        NumRollsToTarget_LE_1155 solution = new NumRollsToTarget_LE_1155();
//        int n = 2, k = 6, target = 7;//6
        int n = 1, k = 6, target = 3;//1

        System.out.println(solution.numRollsToTarget(n, k, target));
    }
}
