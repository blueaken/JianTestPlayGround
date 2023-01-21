package lintcode.greedy;

import java.util.LinkedList;
import java.util.List;

public class PancakeSorting_LE_969 {
    /**
     1.21.2023
     - ref东哥post, 递归处理，先解决最大一个饼，再解决次大的
     - 这个解法并非最优，但可以通过
     */

    List<Integer> res = new LinkedList<>();
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    // note the result is 1 based index
    private void sort(int[] cakes, int n) {
        // base case
        if (n == 1) {
            return;
        }

        // find the max cake
        int maxCake = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxIdx = i;
            }
        }

        // flip the max cake to bottom, first move it to top
        flip(cakes, 0, maxIdx);
        res.add(maxIdx+1);
        // then flip the top cake to bottom
        flip(cakes, 0, n-1);
        res.add(n);

        sort(cakes, n-1);
    }

    private void flip(int[] cakes, int i, int j) {
        while (i < j) {
            int temp = cakes[i];
            cakes[i] = cakes[j];
            cakes[j] = temp;
            i++; j--;
        }
    }
}
