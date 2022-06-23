package lintcode.math;

import java.util.ArrayList;
import java.util.List;

public class KthFactor_LE_1492_P1 {
    /*
        - gut feel is brute force - Time is also efficient O(N)
        - ref the solution link, only need scan from 1 to sqrt(n), remain k-- in the process. Since all factors has a pair relation, get the result from N / factors(factors.size - k).
        - Note a correction for perfect square is required, since it has a hidden duplicate factor not in the list.
        - Time is O(sqrt(n)), space is O(min(k, sqrt(n))) to store the list of factors
    */
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 1; i < sqrtN + 1; i++) {
            if (n % i == 0) {
                factors.add(i);
                k--;
            }
            if (k == 0) {
                return i;
            }
        }

        //adjust for perfect square number
        if (sqrtN * sqrtN == n) {
            k++;
        }

        if (k <= factors.size()) {
            return n / factors.get(factors.size() - k);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        KthFactor_LE_1492_P1 solution = new KthFactor_LE_1492_P1();
//        int n = 12;
//        int k = 3;
//        //3

//        int n = 12;
//        int k = 5;
//        //6

        int n = 16;
        int k = 5;
        //16

//        int n = 46;
//        int k = 4;
//        //46

        System.out.println(solution.kthFactor(n, k));
    }
}
