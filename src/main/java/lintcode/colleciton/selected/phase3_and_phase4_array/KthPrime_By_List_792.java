package lintcode.colleciton.selected.phase3_and_phase4_array;

public class KthPrime_By_List_792 {
    /**
     * @param n: the number
     * @return: the rank of the number
     * ref: https://blog.csdn.net/NK_test/article/details/46242401
     */
    public static int kthPrime(int n) {
        // write your code here
        // 1. list all primes
        boolean primes[] = new boolean[100009];
        // init all positions to true
        for (int i = 2; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i] == true) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        // find the position
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int input = 23;
        int input = 63527;
        System.out.println(kthPrime(input));
    }
}
