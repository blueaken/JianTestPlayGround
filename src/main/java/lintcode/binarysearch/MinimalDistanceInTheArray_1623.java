package lintcode.binarysearch;

import java.util.Arrays;

public class MinimalDistanceInTheArray_1623 {
    /**
     * @param a: array a
     * @param b: the query array
     * @return: Output an array of length `b.length` to represent the answer
     */
    //Idea: similar to 1629, 用nine chapter模板，最后比较了end和start，确保了相等条件下先返回start
    public int[] minimalDistance(int[] a, int[] b) {
        // Write your code here
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return new int[0];
        }
        Arrays.sort(a);

        int[] res = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            int min = findMin(a, b[i]);
            res[i] = min;
        }
        return res;
    }

    private int findMin (int[] a, int pos) {
        int start = 0, end = a.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == pos) {
                return a[mid];
            } else if (a[mid] < pos) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (Math.abs(a[end] - pos) < Math.abs(a[start] - pos)) {
            return a[end];
        } else {
            return a[start];
        }
    }
}
