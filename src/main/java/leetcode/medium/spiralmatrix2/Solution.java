package leetcode.medium.spiralmatrix2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 10/14/15 8:01 AM
 */
public class Solution {
    public static int[][] generateMatrix(int n) {
        int [][] result = new int[n][n];
        if (n==0) return result;

        Queue<Integer> queue = new LinkedList<>();
        int m = n*n;
        for (int i=1; i<=m; i++){
            queue.add(i);
        }

        int l = n;
        int h = n;
        int row=0;
        int col=-1;

        while (true){
            for (int i=0; i<l; i++){
                result[row][++col] = queue.poll();
            }
            if (--h==0) break;
            for (int i=0; i<h; i++){
                result[++row][col] = queue.poll();
            }
            if (--l==0) break;
            for (int i=0; i<l; i++){
                result[row][--col] = queue.poll();
            }
            if (--h==0) break;
            for (int i=0; i<h; i++){
                result[--row][col] = queue.poll();
            }
            if (--l==0) break;
        }

        return result;
    }

    public static void main(String[] args){
        int input = 5;
        int[][] result = generateMatrix(input);

        System.out.println(Arrays.deepToString(result));
    }
}
