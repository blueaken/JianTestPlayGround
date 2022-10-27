package lintcode.greedy;

import java.util.Arrays;

public class Candy_LE_135_P1 {
    /*
        - ref https://www.youtube.com/watch?v=QzPWc0ilEek
        - 1st from left to right
        - 2nd from right to left
        - notice 2nd round loop does not change the order of 1st round
        - say r[i] < r[i+1], after 1st round f[i] < f[i+1], then in 2nd round, f[i+1] will only get higher, not
          lower, so the 1st round order persists
        - say r[i] > r[i+1], after 1st round f[i] > f[i+1], then in 2nd round f[i] = max(f[i], f[i+1]+1), the
          1st round order persists
        ===========================================
        P1 10.27.2022
        ref prev notes and solve with greedy
    */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                f[i] = Math.max(f[i], f[i-1]+1);
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                f[i] = Math.max(f[i], f[i+1]+1);
            }
        }

        //sum it up
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += f[i];
        }
        return sum;
    }
}
