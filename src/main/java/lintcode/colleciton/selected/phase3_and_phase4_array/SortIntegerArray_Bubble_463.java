package lintcode.colleciton.selected.phase3_and_phase4_array;

import java.util.Arrays;

public class SortIntegerArray_Bubble_463 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers(int[] A) {
        // write your code here
        //control how many rounds
        for (int i = 1; i < A.length; i++) {
            //control how many compare times each round
            for (int j = 0; j < A.length - i; j++) {
                if (A[j] > A[j+1]) {
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int input[] = {3,2,1};
        sortIntegers(input);
        System.out.println(Arrays.toString(input));
    }
}
