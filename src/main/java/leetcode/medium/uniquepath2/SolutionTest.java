package leetcode.medium.uniquepath2;

import leetcode.Util;

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
                if ((i==0 && j==1)) {
                    testGrid1[i][j] = 1;
                } else{
                    testGrid1[i][j] = 0;
                }
            }
        }

        //print the grid
        Util.printGrid(testGrid1);

        //Solution solution = new Solution();
        Solution_Refactor solution = new Solution_Refactor();
        System.out.println("The result is: " + solution.uniquePathsWithObstacles(testGrid1));

    }
}
