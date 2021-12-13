package lintcode.colleciton.selected.phase3_and_phase4_array.related.sort;

import java.util.Arrays;

public class SelectSort_N2 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] A) {
        // write your code here
        // with SelectSort,not stable, for example 58529, ref: https://baike.baidu.com/item/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/9762418
        // i控制交换次数, 最后一次不用交换
        for (int i = 0; i < A.length - 1; i++) {
            int min = i;
            for (int j = i; j < A.length - 1; j++) {
                if (A[min] > A[j+1]) {
                    min = j + 1;
                }
            }
            swap(A, i, min);
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
