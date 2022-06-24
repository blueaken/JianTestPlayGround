package lintcode.math;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_LE_1291 {
    //Idea - iterate with lds dp template, Time - O(1)
    public List<Integer> sequentialDigits(int low, int high) {
        int len1 = String.valueOf(low).length();
        int len2 = String.valueOf(high).length();

        String ori = "123456789";
        List<Integer> res = new ArrayList<>();
        for (int len = len1; len <= len2; len++) {
            for (int i = 0; i <= ori.length() - len; i++) {
                int j = i + len - 1;
                int cur = Integer.valueOf(ori.substring(i, j+1));
                if (cur < low || cur > high) {
                    continue;
                }
                res.add(cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits_LE_1291 solution = new SequentialDigits_LE_1291();
        int low = 100;
        int high = 300;
        //[123, 234]

        System.out.println(solution.sequentialDigits(low, high));
    }
}
