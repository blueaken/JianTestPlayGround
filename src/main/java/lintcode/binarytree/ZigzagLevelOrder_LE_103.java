package lintcode.binarytree;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.*;

public class ZigzagLevelOrder_LE_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEven = false;
        while (queue.size() > 0) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (isEven) {
                    list.addFirst(cur.val);
                } else {
                    list.add(cur.val);
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(list);
            isEven = !isEven;
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder_LE_103 solution = new ZigzagLevelOrder_LE_103();
        int[] input = {1,2,3,4,-999,-999,5};
        TreeNode root = TreeNodeUtil.buildTree(input);
        System.out.println(solution.zigzagLevelOrder(root).toString());
    }
}
