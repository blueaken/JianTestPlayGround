package lintcode.binarytree.level;

import type.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView_LE_199 {
    /**
     04.12.2023
     - 注意和545 Binary Tree边界不同，这里右边界可能在左字数上（当右子树为空时）
     - 使用level traverse
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size() > 0) {
            int sz = queue.size();
            // 每层最后一个就是right side value
            res.add(queue.peekLast().val);
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        BinaryTreeRightSideView_LE_199 solution = new BinaryTreeRightSideView_LE_199();
        System.out.println(solution.rightSideView(root));
    }
}
