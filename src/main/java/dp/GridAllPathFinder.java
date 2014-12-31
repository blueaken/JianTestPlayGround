package dp;

/**
 * Created by jianshen on 12/31/14.
 */
public class GridAllPathFinder {
    public static void main(String[]args){
        int row = 4;
        int col = 3;

        System.out.println("All paths from upper left to bottom right in a " + row + " * " + col + " grid is: " +
        findAllPathInGrid(row, col));
    }

    static int findAllPathInGrid(int row, int col){
        int grid[][] = new int[row][col];

        //init the point values on the border to 1
        for (int i=0; i<row; i++){
            grid[i][0] = 1;
        }
        for (int j=0; j<col; j++){
            grid[0][j] = 1;
        }

        for (int i=1; i<row; i++){
            for (int j=1; j<col; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        //print the grid
        System.out.println("The result grid:");
        for (int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        return grid[row-1][col-1];
    }
}
