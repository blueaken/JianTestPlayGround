package lintcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_LE_386 {
    /**
     12.17.23
     ref https://leetcode.com/problems/lexicographical-numbers/solutions/3529211/java-easy-100-o-n-dfs-solution/
     */
    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        rec(n, 1);
        return res;
    }

    void rec(int n, int cur) {
        // base condition
        if (cur > n) {
            return;
        }

        res.add(cur);
        rec(n, cur*10);
        // stop increase when last digit is 9, since lexicographical order
        if (cur%10 != 9) {
            rec(n, cur+1);
        }
    }

    public static void main(String[] args) {
        LexicographicalNumbers_LE_386 solution = new LexicographicalNumbers_LE_386();
        int n = 13;
        System.out.println(solution.lexicalOrder(n));
    }
}
