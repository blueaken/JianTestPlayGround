package lintcode.mathmatics;

import java.util.ArrayList;
import java.util.List;

public class KthFactor_LE_1492 {
    /*
        - gut feel is brute force - Time is also efficient O(N)
        - ref the solution link, only need scan from 1 to sqrt(n), remain k-- in the process. Since all factors has a pair relation, get the result from N / factors(factors.size - k).
        - Note a correction for perfect square is required, since it has a hidden duplicate factor not in the list.
        - Time is O(sqrt(n)), space is O(min(k, squrt(n))) to store the list of factors
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

        //adjust if n is a perfect square
        if (sqrtN * sqrtN == n) {
            k++;
        }

        return k <= factors.size() ? n / factors.get(factors.size() - k) : -1;
    }

    public static void main(String[] args) {
        KthFactor_LE_1492 solution = new KthFactor_LE_1492();
//        int n = 15;
//        int k = 3;
//        //5

//        int n = 16;
//        int k = 5;
//        //16

        int n = 46;
        int k = 4;
        //46

        System.out.println(solution.kthFactor(n, k));
    }
}
