package ninechapter_algorithm.chapter8_data_structure.mergeksortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: blueaken
 * Date: 5/3/16 10:34
 */
public class Solution_DC {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (arrays == null || arrays.length == 0
                || arrays[0] == null || arrays[0].length == 0) {
            return result;
        }

        int row = arrays.length;
        int end = row - 1;
        while (end > 0) {
            int start = 0;
            while (start < end) {
                arrays[start] = merge2arrays(arrays[start], arrays[end]);
                start++;
                end--;
            }
        }

        for (int i : arrays[0]) {
            result.add(i);
        }
        return result;
    }

    private int[] merge2arrays(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int len = lenA + lenB;
        int[] result = new int[len];

        int indA = 0;
        int indB = 0;
        int index = 0;
        while (indA < lenA && indB < lenB) {
            if (A[indA] < B[indB]) {
                result[index++] = A[indA++];
            } else {
                result[index++] = B[indB++];
            }
        }
        while (indA < lenA) {
            result[index++] = A[indA++];
        }
        while (indB < lenB) {
            result[index++] = B[indB++];
        }

        return result;
    }
}
