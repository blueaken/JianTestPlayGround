package leetcode.algorithm;

/**
 * Created by jshe18 on 7/19/15.
 */
public class Util {
    public static void printGrid(int[][] grid){
        System.out.println("Printing the test grid:");
        int row = grid.length;
        int col = grid[0].length;

        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
