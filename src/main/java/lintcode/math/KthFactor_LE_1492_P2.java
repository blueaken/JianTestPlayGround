package lintcode.math;

import java.util.ArrayList;
import java.util.List;

public class KthFactor_LE_1492_P2 {
    /*
        P2
        - check previous notes
    */
    public int kthFactor(int n, int k) {
        List<Integer> f = new ArrayList<>();
        int sq = (int)Math.sqrt(n);
        for (int i = 1; i <= sq; i++) {
            if (n % i == 0) {
                f.add(i);
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }

        //adjust for perfect square
        if (sq * sq == n) {
            k++;
        }

        int size = f.size();
        if (k <= size) {
            return n / f.get(size - k);
        }
        return -1;
    }
}
