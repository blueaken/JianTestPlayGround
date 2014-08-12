package freq5;

import java.util.Arrays;

/**
 * @author jianshen
 */
public class SetMatrixZeroes {
    //level 3
    public static void main (String[] args){
        int [][] testMatrix = {
                {0,1,1,1},
                {1,1,0,1},
                {1,0,1,1},
                {1,1,1,1}
        };

        setZeroes(testMatrix);

        for (int[] row : testMatrix) System.out.println(Arrays.toString(row));
    }

    /*
     * in place solution - a bit tedious though - have to process the 1st row and column at the end to avoid
     * data incorruption
     */
    public static void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        boolean rowZero = false;
        boolean colZero = false;

        for (int i=0; i<rowNum; i++){
            if(matrix[i][0] == 0) rowZero = true;
        }

        for (int j=0; j<colNum; j++){
            if(matrix[0][j] == 0) colZero = true;
        }

        for (int i=1; i<rowNum; i++){
            for (int j=1; j<colNum; j++){
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i=1; i<rowNum; i++){
            if (matrix[i][0] == 0) {
                for (int j=1; j<colNum; j++){
                    matrix [i][j] = 0;
                }
            }
        }

        for (int j=1; j<colNum; j++){
            if (matrix[0][j] == 0) {
                for (int i=1; i<rowNum; i++){
                    matrix [i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int i=0; i<rowNum; i++){
                matrix[i][0] = 0;
            }
        }

        if (colZero) {
            for (int j=0; j<colNum; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
