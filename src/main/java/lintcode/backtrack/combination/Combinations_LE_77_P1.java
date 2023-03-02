package lintcode.backtrack.combination;

import java.util.LinkedList;
import java.util.List;

public class Combinations_LE_77_P1 {
    /**
     1.9.2023
     ref 东哥 post
     使用回溯框架，在subset方案上稍作修改(只收集size为k的subset)
     ===================
     3.2.2023
     P1
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i+1, n, k);
            track.removeLast();
        }
    }
}
