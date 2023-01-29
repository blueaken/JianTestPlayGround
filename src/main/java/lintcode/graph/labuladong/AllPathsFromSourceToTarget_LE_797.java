package lintcode.graph.labuladong;

import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget_LE_797 {
    /**
     1.29.2023
     - ref 东哥 post, 图的基本遍历，因为没有cyclic，visited[]数组可以省略
     */
    LinkedList<Integer> path;
    LinkedList<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path = new LinkedList<>();
        res = new LinkedList<>();

        traverse(graph, 0);
        return res;
    }

    private void traverse(int[][] graph, int node) {
        int[] neighbor = graph[node];
        path.add(node);
        if (node == graph.length - 1) {
            res.add(new LinkedList<>(path));
            // the following can be omitted since there is no cylic in this graph
            path.removeLast();
            return;
        }
        for (int n : neighbor) {
            traverse(graph, n);
        }
        path.removeLast();
    }
}
