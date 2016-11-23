package ninechapter_algorithm.chapter2_binarysearch.optional.woodcut.second;

/**
 * Author: blueaken
 * Date: 4/13/16 11:52 AM
 */
public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public static int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }

        //find the maxium length
        int end = 0;
        for (int i = 0; i < L.length; i++) {
            end = Math.max(L[i], end);
        }

        int start = 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (getCutNum(L, mid) >= k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start - 1;
    }

    private static int getCutNum (int[] L, int len) {
        int count = 0;
        for (int i = 0; i < L.length; i++) {
            count += L[i] / len;
        }
        return count;
    }

    public static void main(String[] args) {
        //tc 1
        int[] L = {232,124,456,323};
        int k = 7;

        System.out.println(woodCut(L, k));
    }
}
