package lintcode.binarytree;

import java.util.*;

import type.TreeNode;

public class ZigzagLevelOrder_LE_103_P2 {
    /*
        P2
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerFirst(root);
        boolean isEven = false;
        while (queue.size() > 0) {
            int n = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.pollLast();
                if (isEven) {
                    list.addFirst(cur.val);
                } else {
                    list.addLast(cur.val);
                }

                if (cur.left != null) {
                    queue.offerFirst(cur.left);
                }
                if (cur.right != null) {
                    queue.offerFirst(cur.right);
                }
            }
            res.add(list);
            isEven = !isEven;
        }
        return res;
    }
}
