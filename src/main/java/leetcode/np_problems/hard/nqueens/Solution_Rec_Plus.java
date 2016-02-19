package leetcode.np_problems.hard.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/18/16 3:33 PM
 */
public class Solution_Rec_Plus {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        rec(n,0,new int[n], res);
        return res;
    }

    private static void rec(int n, int row, int[] temp, List<List<String>> res){
        if (row == n){
            //add temp result into result
            List<String> list = new ArrayList<>();
            for (int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<n; j++){
                    if (temp[j]==i){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;

        }

        for (int i=0; i<n; i++){
            temp[row] = i;
            if (verify(row, temp)){
                rec(n, row+1, temp, res);
            }
        }
    }

    private static boolean verify(int row, int[] temp){
        for (int i=0; i<row; i++){
            //existing column in temp[i], check if it conflicts with new column temp[row]
            boolean isSameColumn = (temp[row] == temp[i]);

            //check行差和列差是否相等
            boolean isDiagonal = Math.abs(temp[i] - temp[row]) == row - i;

            if (isSameColumn || isDiagonal){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args){
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }
}
