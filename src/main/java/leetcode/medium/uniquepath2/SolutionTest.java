package leetcode.medium.uniquepath2;

import leetcode.easy.validparenthese.*;

/**
 * Created by jshe18 on 7/12/15.
 */
public class SolutionTest {
    public static void main(String[] args){
        int row = 3;
        int col = 3;

        int[][] testGrid1 = new int[row][col];

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if ((i==0 && j==0)) {
                    testGrid1[i][j] = 1;
                } else{
                    testGrid1[i][j] = 0;
                }
            }
        }

        //print the grid
        printGrid(testGrid1);

        Solution solution = new Solution();
        System.out.println("The actual result is: " + solution.uniquePathsWithObstacles(testGrid1));

        //print the grid
        printGrid(testGrid1);

    }

    private static void printGrid(int[][] testGrid){
        System.out.println("The test grid:");
        int row = testGrid.length;
        int col = testGrid[0].length;

        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(testGrid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
