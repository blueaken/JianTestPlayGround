package lintcode.math.median;

import java.util.*;

public class MakeKSubarraySumsEqual_LE_2607 {
    /**
     11.28.23
     ref - https://www.youtube.com/watch?v=AL9kUNQALZE
     */
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new LinkedList<>();

        // can optimize here, since the index increases in the cycle of k & n, we can use gcd of n & k directly to avoid the loop back
        int t = gcd(n, k);

        // at most k buckets
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int j = i;
            while (j < n && !visited[j]) {
                list.add(arr[j]);
                visited[j] = true;
                j += t;
            }

            sum += getMinOpp(list);
            list = new LinkedList<>();
        }

        return sum;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    // get min distance of an array, with median diff summary, similar to 296
    long getMinOpp(List<Integer> list) {
        int n = list.size();
        if (n == 0) {
            return 0;
        }
        Collections.sort(list);

        long sum = 0;
        int median = list.get(n/2);

        for (Integer num : list) {
            sum += Math.abs(num - median);
        }
        return sum;
    }
}
