package lintcode.binarytree;

import type.TreeNode;
import type.ListNode;
import util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeToLists_242 {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    //Idea: BFS with queue
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        if (root == null) return null;
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() > 0) {
            ListNode dummy = new ListNode(-999);
            ListNode cur = dummy;
            int curLevelCount = queue.size();
            for (int i = 0; i < curLevelCount; i++) {
                TreeNode treeNode = queue.poll();

                ListNode node = new ListNode(treeNode.val);
                cur.next = node;
                cur = cur.next;

                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(dummy.next);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        TreeNode root = TreeNodeUtil.buildTree(input);

        binaryTreeToLists(root);
    }
}
