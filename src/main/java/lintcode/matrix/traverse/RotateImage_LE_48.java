package lintcode.matrix.traverse;

public class RotateImage_LE_48 {
    /**
     12.01.2022
     ref labuladong post
     - 1st rotate from diagnal (upper left to bottom right) then reverse each row, get the clockwise 90 degree rotation
     - similarly for anti-clockwise 90 degree, need rotate from diagnal (upper right to bottom left) first
     */
    public void rotate(int[][] matrix) {
        //1st swap diagnal (upper left to bottom right)
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                //swap matrix[i][j], matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //then reverse each row
        for (int[] row : matrix) {
            int start = 0; int end = n-1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++; end--;
            }
        }
    }
}
