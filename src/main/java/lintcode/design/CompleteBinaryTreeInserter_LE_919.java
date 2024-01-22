package lintcode.design;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter_LE_919 {
    /**
     1.22.24
     - 层序遍历，维护一个queue保存可以插入的节点
     - ref 东哥post
     */

    TreeNode root;
    Queue<TreeNode> queue;
    public CompleteBinaryTreeInserter_LE_919(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();

        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while (temp.size() > 0) {
            TreeNode cur = temp.poll();
            if (cur.left != null) {
                temp.offer(cur.left);
            }
            if (cur.right != null) {
                temp.offer(cur.right);
            }
            // found a node has position for child node
            if (cur.left == null || cur.right == null) {
                queue.offer(cur);
            }
        }

    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur = queue.peek();
        if (cur.left == null) {
            cur.left = node;
        } else if (cur.right == null) {
            cur.right = node;
            queue.poll(); // cur node cannot take new child node anymore
        }
        queue.offer(node);

        return cur.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        CompleteBinaryTreeInserter_LE_919 solution = new CompleteBinaryTreeInserter_LE_919(root);
        System.out.println(solution.insert(3));
        System.out.println(solution.insert(4));
        TreeNodeUtil.printTree(solution.get_root());
    }
}
