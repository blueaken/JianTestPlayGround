package lintcode.colleciton.selected.phase3_and_phase4_array;

import java.util.ArrayList;
import java.util.List;

public class PrintX_25 {
    /**
     * @param n: An integer.
     * @return: A string list.
     */
    public List<String> printX(int n) {
        // write your code here
        List<String> result = new ArrayList<>();
        char[] line = new char[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                line[j] = ' ';//初始化
            }
            line[i] = 'X';//右对角线赋值
            line[n-i-1] = 'X';//左对角线赋值
            result.add(String.valueOf(line));
        }
        return result;
    }
}
