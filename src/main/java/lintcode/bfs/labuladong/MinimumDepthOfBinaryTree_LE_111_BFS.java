package lintcode.bfs.labuladong;

import java.util.LinkedList;
import java.util.Queue;

import type.TreeNode;

public class MinimumDepthOfBinaryTree_LE_111_BFS {
    /**
     1.13.2023
     - ref 东哥 post, redo with BFS framework
     - BFS has better time performance since it does not need to traverse the whole tree, but need more space O(N), DFS space just O(logN)
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1; //root本身就是1层
        while (queue.size() > 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    // return at 1st leaf node
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
