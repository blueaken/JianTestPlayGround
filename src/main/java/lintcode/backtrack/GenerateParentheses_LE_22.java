package lintcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_LE_22 {
    /**
     1.12.2023
     - ref 东哥 post, 使用回溯框架解决
     - 一个valid组合中，任意位置i, 子串str[0..i]中左括号数量必然大于等于右括号。利用这个性质进行剪枝
     */
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        backtrack(n, n, sb);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
    private void backtrack(int left, int right, StringBuilder sb) {
        //base cases
        if (left > right) {
            //剩余左括号多，不符合valid组合性质，返回
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
        }

        //try left parenthesis
        sb.append('(');
        backtrack(left-1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        //try right parenthesis
        sb.append(')');
        backtrack(left, right-1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
