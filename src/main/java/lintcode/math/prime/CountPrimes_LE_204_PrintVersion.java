package lintcode.math.prime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPrimes_LE_204_PrintVersion {
    /**
     9.28.23
     - refactor to print version
     - make result set less or equal to n
     */
    public Set<Integer> countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        CountPrimes_LE_204_PrintVersion solution = new CountPrimes_LE_204_PrintVersion();
        int n = 16; //2,3,5
        System.out.println(solution.countPrimes(n));
    }
}
