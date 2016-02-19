package leetcode.np_problems.hard.nqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 2/16/16 10:51 PM
 */
public class Solution_Web {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(n,0,new int[n], res);
        return res;
    }

    private static void helper(int n, int row, int[] columnForRow, List<List<String>> res)
    {
        if(row == n)
        {
            List<String> item = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                StringBuilder strRow = new StringBuilder();
                for(int j=0;j<n;j++)
                {
                    if(columnForRow[i]==j)
                        strRow.append('Q');
                    else
                        strRow.append('.');
                }
                item.add(strRow.toString());
            }
            res.add(item);
            return;
        }
        for(int i=0;i<n;i++)
        {
            columnForRow[row] = i;
            if(check(row,columnForRow))
            {
                helper(n,row+1,columnForRow,res);
            }
        }
    }

    private static boolean check(int row, int[] columnForRow)
    {
        for(int i=0;i<row;i++)
        {
            if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }
}
