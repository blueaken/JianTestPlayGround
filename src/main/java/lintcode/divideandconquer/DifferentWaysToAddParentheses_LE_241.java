package lintcode.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses_LE_241 {
    /**
     1.18.2023
     ref 东哥 post, divide & conquer, 注意base case在后序遍历位置
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);
            // if input is a seperator then divide & conquer
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (Integer a : left) {
                    for (Integer b : right) {
                        if (cur == '+') {
                            res.add(a + b);
                        } else if (cur == '-') {
                            res.add(a - b);
                        } else if (cur == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }

        // base case, 说明是个数字
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }

        return res;
    }
}
