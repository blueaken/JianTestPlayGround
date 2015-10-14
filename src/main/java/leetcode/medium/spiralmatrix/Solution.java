package leetcode.medium.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 10/13/15 10:01 PM
 */
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m==0) return result;

        int n = matrix[0].length;
        int row = 0;
        int col = -1;

        while (true){
            for (int i=0; i<n; i++){
                result.add(matrix[row][++col]);
            }
            if (--m==0) break;
            for (int i=0; i<m; i++){
                result.add(matrix[++row][col]);
            }
            if (--n==0) break;
            for (int i=0; i<n; i++){
                result.add(matrix[row][--col]);
            }
            if (--m==0) break;
            for (int i=0; i<m; i++){
                result.add(matrix[--row][col]);
            }
            if (--n==0) break;
        }


        return result;
    }

    public static void main(String[] args){
        int[][] input = new int[][]{
                { 1, 2, 3},
                { 4, 5, 6},
                { 7, 8, 9}
        };

        List<Integer> result = spiralOrder(input);
        for (int i: result){
            System.out.print(i);
        }
    }

}
