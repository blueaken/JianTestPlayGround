package lintcode.binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_69 {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    //Ref:https://blog.csdn.net/weixin_30586085/article/details/99427246?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-4.queryctr&spm=1001.2101.3001.4242.3&utm_relevant_index=7
    //& Previous Leetcode Practice in 2016 Feb.
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int curLevelCount = 1;
        int nextLevelCount = 0;

        List<Integer> level = new ArrayList<>();
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            level.add(node.val);
            curLevelCount--;

            if (node.left != null) {
                queue.offer(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelCount++;
            }

            if (curLevelCount == 0) {
                res.add(level);
                level = new ArrayList<>();
                curLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
        }

        return res;
    }
}
