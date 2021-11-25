package lintcode.colleciton.selected.phase3_array;

import java.util.HashMap;
import java.util.Map;

public class KthPrime_By_Calculate_792 {
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public static int kthPrime(int n) {
        // write your code here
        // 1. calculate all primes
        Map<Integer, Integer> primes = new HashMap<>();
        int count = 1;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            if (i == 2 || i % 2 == 1) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                    }
                }
            } else {
                continue;
            }
            if (flag) {
                primes.put(i, count++);
            }
        }

        // 2. find the order
        return primes.get(n);
    }

    public static void main(String[] args) {
        int input = 23;
        System.out.println(kthPrime(input));
    }
}
