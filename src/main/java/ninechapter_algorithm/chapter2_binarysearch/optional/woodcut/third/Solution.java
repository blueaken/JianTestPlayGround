package ninechapter_algorithm.chapter2_binarysearch.optional.woodcut.third;

/**
 * Author: blueaken
 * Date: 6/24/16 08:05
 */
public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0 || k < 1) {
            return 0;
        }

        int end = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(L[i], end);
        }
        int start = 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int cur = getN(L, mid);
            if (cur >= k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }

    private int getN(int[] L, int len) {
        int result = 0;
        for (int i = 0; i < L.length; i++) {
            result += L[i] / len;
        }
        return result;
    }
}
