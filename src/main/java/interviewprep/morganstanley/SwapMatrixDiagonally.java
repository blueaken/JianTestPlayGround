package interviewprep.morganstanley;

/**
 * Created by jianshen on 12/21/14.
 */
public class SwapMatrixDiagonally {
    public static void main(String[] args){
        /*
        * init a 3x3 matrix array
        * The expression '1' + row * 3 + col works since (where you vary row and col between 0 and 2 inclusive).
         */
        int[][] table = new int[3][3];
        for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
                table[row][col] = (char) (1 + row * 3 + col);

        //Print the array before swap
        for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
                System.out.println (table[row][col]);

        //swap on the main diagonal line, notice only swap on half of the matrix, otherwise it converts back to the original.
        for (int row = 0; row < 3; row ++)
            for (int col = row; col < 3; col++) {
                if (row == col) continue; //improve performance by skip the swap for the elements on the diagonal line
                swap(table, row, col);
            }

        System.out.println ("*************** separator *****************");

        //Print the array after swap
        for (int row = 0; row < 3; row ++)
            for (int col = 0; col < 3; col++)
                System.out.println (table[row][col]);
    }

    private static void swap(int[][] table, int r, int c){
        int temp = table[r][c];
        table[r][c] = table[c][r];
        table[c][r] = temp;
    }
}
