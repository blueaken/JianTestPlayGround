package lintcode.colleciton.selected.phase3_array.related.sort;

import java.util.Arrays;

public class InsertSort_N2 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] A) {
        // write your code here
        // with InsertSort, stable, ref: https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j-1]) {
                    swap(A, j, j-1);;
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int input[] = {6, 5, 4, 3, 2, 1};
        sortIntegers(input);
        System.out.println(Arrays.toString(input));
    }
}
