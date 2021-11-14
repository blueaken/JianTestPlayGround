package lintcode.colleciton.selected.phase3_array;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeNum_298 {
    /**
     * @param n: an integer
     * @return: return all prime numbers within n.
     */
    public List<Integer> prime(int n) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            if (i == 2 || i % 2 == 1) {
                //if exists factor other than 1 and itself
                for (int j = 2; j<i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
            } else {
                continue;
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}
