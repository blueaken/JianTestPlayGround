package lintcode.math;

import java.util.ArrayList;
import java.util.List;

public class KthFactor_LE_1492_BruteForce{
    /*
        - gut feel is brute force - Time is also efficient O(N)
    */
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                k--;
            }
            if (k == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KthFactor_LE_1492_BruteForce solution = new KthFactor_LE_1492_BruteForce();
//        int n = 15;
//        int k = 3;
//        //5

        int n = 16;
        int k = 5;
        //16

//        int n = 46;
//        int k = 4;
//        //46

        System.out.println(solution.kthFactor(n, k));
    }
}
