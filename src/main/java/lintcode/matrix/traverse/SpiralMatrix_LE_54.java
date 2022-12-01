package lintcode.matrix.traverse;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_LE_54 {
    /**
     12.01.2022
     ref labuladong post
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int upper_bound = 0, bottom_bound = m-1;
        int left_bound = 0, right_bound = n-1;

        List<Integer> res = new ArrayList<>();
        //traverse complete when res size is m*n
        while (res.size() < m*n) {
            if (upper_bound <= bottom_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= bottom_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                right_bound--;
            }

            if (upper_bound <= bottom_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    res.add(matrix[bottom_bound][i]);
                }
                bottom_bound--;
            }

            if (left_bound <= right_bound) {
                for (int i = bottom_bound; i >= upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                left_bound++;
            }
        }
        return res;
    }
}
