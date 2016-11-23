package ninechapter_algorithm.chapter2_binarysearch.optional.woodcut;

/**
 * Author: blueaken
 * Date: 2/27/16 10:14 AM
 */
public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public static int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0 || k == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }

        // find the largest length that can cut more than k pieces of wood.
        int start = 1;
        int end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getTotalNum(L, mid) >= k) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (getTotalNum(L, end) >= k) {
            return end;
        }
        if (getTotalNum(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private static int getTotalNum(int[] L, long length) {
        int sum = 0;
        for (int i = 0; i < L.length; i++){
            sum += L[i] / length;
        }
        return sum;
    }

    public static void main(String[] args) {
        //tc 1
        int[] L = {232,124,456};
        int k = 7;

        //tc 2
//        int[] L = {2147483644,2147483645,2147483646,2147483647};
//        int k = 4;

        System.out.println(woodCut(L, k));
    }
}
