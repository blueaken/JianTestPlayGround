package lintcode.backtrack.combination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_LE_77 {
    /**
     1.9.2022
     ref 东哥 post
     使用回溯框架，在subset方案上稍作修改(只收集size为k的subset)
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        //base case，遍历到了第 k 层，收集当前节点的值
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}
