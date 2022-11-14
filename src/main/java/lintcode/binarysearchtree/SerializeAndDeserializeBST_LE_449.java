package lintcode.binarysearchtree;

import java.util.LinkedList;
import type.TreeNode;

public class SerializeAndDeserializeBST_LE_449 {
    // Encodes a tree to a single string.
    /**
     ref 东哥 post
     利用BST左小右大特点可以比297对BT的时间更加优化
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb);
        return sb.toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(",");
        seHelper(node.left, sb);
        seHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        LinkedList<Integer> inorder = new LinkedList<>();
        for (String s : data.split(",")) {
            inorder.add(Integer.valueOf(s));
        }

        return deHelper(inorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deHelper(LinkedList<Integer> inorder, Integer min, Integer max) {
        if (inorder.size() == 0) {
            return null;
        }

        int val = inorder.getFirst();
        if (val < min || val > max) {
            return null;
        }
        inorder.removeFirst();

        TreeNode node = new TreeNode(val);
        node.left = deHelper(inorder, min, val);
        node.right = deHelper(inorder, val, max);

        return node;
    }
}
