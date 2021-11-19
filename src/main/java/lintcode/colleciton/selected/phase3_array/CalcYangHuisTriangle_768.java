package lintcode.colleciton.selected.phase3_array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcYangHuisTriangle_768 {
    /**
     * @param n: a Integer
     * @return: the first n-line Yang Hui's triangle
     */
    public static List<List<Integer>> calcYangHuisTriangle(int n) {
        // write your code here
        List<Integer> row = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            row.add(1);
            for (int j = 1; j <= i; j++) {
                List<Integer> preRow = result.get(i-1);
                int sec_factor = preRow.size() == j ? 0 : preRow.get(j);
                row.add(preRow.get(j-1) + sec_factor);
            }
            result.add(row);
            row = new ArrayList<>();
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 5;
        System.out.println(Arrays.deepToString(calcYangHuisTriangle(input).toArray()));
    }
}
