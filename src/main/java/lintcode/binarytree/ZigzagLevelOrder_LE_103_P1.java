package lintcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import type.TreeNode;
import util.TreeNodeUtil;

public class ZigzagLevelOrder_LE_103_P1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isEvenRow = false;
            while (queue.size() > 0) {
                int size = queue.size();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (isEvenRow) {
                        list.addFirst(node.val);
                    } else {
                        list.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                isEvenRow = !isEvenRow;
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {3,9,20,-999,-999,15,7};//[[3],[20,9],[15,7]]
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNodeUtil.printTree(root);

        ZigzagLevelOrder_LE_103_P1 solution = new ZigzagLevelOrder_LE_103_P1();
        System.out.println(solution.zigzagLevelOrder(root));
    }
}
