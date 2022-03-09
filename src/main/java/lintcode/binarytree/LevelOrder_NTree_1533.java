package lintcode.binarytree;

import type.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_NTree_1533 {
    /**
     * @param root: the tree root
     * @return: the order level of this tree
     */
    public List<List<Integer>> levelOrder(UndirectedGraphNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                level.add(node.label);
                for (UndirectedGraphNode neighbor : node.neighbors) {
                    queue.offer(neighbor);
                }
            }
            res.add(level);
        }

        return res;
    }
}
