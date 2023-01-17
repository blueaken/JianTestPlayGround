package lintcode.math.factor;

public class PreimageSizeOfFactorialZeroesFunction_LE_793 {
    /**
     1.17.2023
     ref东哥post, use the LE 172 result & binary search
     */
    public int preimageSizeFZF(int k) {
        long r = right_bound(k);
        long l = left_bound(k);
        return (int)(r - l + 1);
    }

    private long left_bound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (traillingZeros(mid) < k) {
                left = mid + 1;
            } else {
                // if equals continue search left
                right = mid;
            }
        }
        return left;
    }

    private long right_bound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (traillingZeros(mid) <= k) {
                // if equals continue search right
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private long traillingZeros(long n) {
        long res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        PreimageSizeOfFactorialZeroesFunction_LE_793 solution = new PreimageSizeOfFactorialZeroesFunction_LE_793();
        int k = 6;
        System.out.println(solution.preimageSizeFZF(k));
    }
}
