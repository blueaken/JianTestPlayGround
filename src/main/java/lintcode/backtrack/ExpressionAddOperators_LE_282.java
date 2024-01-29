package lintcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperators_LE_282 {
    /**
     1.29.24
     - solve by backtrack, a trick is to deal with '*' operator, needs to save the value to be multiplied before next backtrack
     - ref https://leetcode.com/problems/expression-add-operators/solutions/71895/java-standard-backtrace-ac-solutoin-short-and-clear/
     */
    List<String> res;
    String num;
    long target;
    public List<String> addOperators(String num, int target) {
        res = new LinkedList<>();
        this.num = num;
        this.target = target;

        String path = "";
        backtrack(path, 0, 0, 0);
        return res;
    }

    void backtrack(String path, int pos, long eval, long multi) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
                return;
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.valueOf(num.substring(pos, i+1));
            if (pos == 0) {
                backtrack(path+cur, i+1, cur, cur);
            } else {
                backtrack(path+"+"+cur, i+1, eval+cur, cur);
                backtrack(path+"-"+cur, i+1, eval-cur, -cur);
                backtrack(path+"*"+cur, i+1, eval-multi+multi*cur, multi*cur);
            }
        }

    }

    public static void main(String[] args) {
        ExpressionAddOperators_LE_282 solution = new ExpressionAddOperators_LE_282();
        String num = "123";
        int target = 6;
        System.out.println(solution.addOperators(num, target));
    }
}
