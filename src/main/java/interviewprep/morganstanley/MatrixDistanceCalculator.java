package interviewprep.morganstanley;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianshen on 12/25/14.
 */

class Point{
    int row;
    int col;

    Point(int r, int c){
        this.row = r;
        this.col = c;
    }
}

public class MatrixDistanceCalculator {
    /*
    *Given a matrix of -1’s and 0’s, display a matrix which contains minimum distance to reach nearest 0 for that
    * particular position.
    * Example:
    * Input:
    * -1 0 -1
    * -1 -1 -1
    * -1 -1 -1
    *
    * Output:
    * 1 0 1
    * 2 1 2
    * 3 2 3
     */
    public static void main(String[] args){

        int[][] matrix = new int[4][4];
        matrix[0][0] = -1;
        matrix[0][1] = 0;
        matrix[0][2] = -1;
        matrix[0][3] = -1;

        matrix[1][0] = -1;
        matrix[1][1] = -1;
        matrix[1][2] = -1;
        matrix[1][3] = -1;

        matrix[2][0] = -1;
        matrix[2][1] = -1;
        matrix[2][2] = -1;
        matrix[2][3] = -1;

        matrix[3][0] = -1;
        matrix[3][1] = -1;
        matrix[3][2] = 0;
        matrix[3][3] = -1;

        //Print the array before calculation
        System.out.println("Here is the matrix before calc:");
        for (int i=0; i<matrix.length; i++) {                   //row size
            for (int j = 0; j < matrix[0].length; j++) {        //col size
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        calculateMatrixDistance(matrix);

        //Print the array after calculation
        System.out.println("Here is the matrix after calc:");
        for (int i=0; i<matrix.length; i++) {                   //row size
            for (int j = 0; j < matrix[0].length; j++) {        //col size
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    * Plan of Attack:
    * 1. scan the matrix and record the position of 0s
    * 2. for every single 0, each position calculate its distance value and update the current value
    *    if the calculated value is smaller
    *
    * Time Complex: assume number of matrix elements is n and number of 0s is m. And get O(n*m).
    */
    private static void calculateMatrixDistance(int[][] matrix){
        //step 1.
        Queue<Point> points = new LinkedList<Point>();
        for (int i=0; i<matrix.length; i++){            //row size
            for (int j=0; j<matrix[0].length; j++){     //col size
                if (matrix[i][j] == 0){
                    points.add(new Point(i, j));
                }
            }
        }

        //step 2.
        for (Point point : points){
            for (int i=0; i<matrix.length; i++){            //row size
                for (int j=0; j<matrix[0].length; j++){     //col size
                    int distance = Math.abs(i - point.row) + Math.abs(j - point.col);
                    if (matrix[i][j] == -1){
                        matrix[i][j] = distance;
                    } else if (distance < matrix[i][j]){
                        matrix[i][j] = distance;
                    }
                }
            }
        }
    }
}
