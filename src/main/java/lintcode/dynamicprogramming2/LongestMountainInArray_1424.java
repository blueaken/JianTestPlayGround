package lintcode.dynamicprogramming2;

import java.util.Arrays;

public class LongestMountainInArray_1424 {
    /**
     * @param A:
     * @return: the length of the longest mountain
     */
    //Idea: ref - https://www.youtube.com/watch?v=TWHytKnOPaQ
    public int longestMountain(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] lis = new int[A.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    lis[i] = Math.max(lis[i], 1 + lis[j]);
                }
            }
        }

        int[] lds = new int[A.length];
        Arrays.fill(lds, 1);
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = A.length - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < A.length; i++) {
             /*
		       The strictly increasing or strictly decreasing sequences should
               be considered. Otherwise, it will hence fail in,
			   Test case: [5,4,1,3,2,1].
				We need to make sure both the LIS on the left and right, ending at index i,
				has length > 1.
		   */
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max((lis[i] + lds[i] - 1), max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A = {5,4,1,3,2,1};

        LongestMountainInArray_1424 solution = new LongestMountainInArray_1424();
        System.out.println(solution.longestMountain(A));
    }
}
