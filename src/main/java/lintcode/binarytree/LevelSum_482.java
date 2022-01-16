package lintcode.binarytree;

import type.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSum_482 {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        int curLevel = 0;
        queue.offer(root);

        while (queue.size() > 0) {
            int count = queue.size();
            curLevel++;
            for (int i = 0; i < count; i ++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (curLevel == level) {
                        sum += node.val;
                    }
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (curLevel == level) {
                break;
            }
        }
        return sum;
    }
}
