package lintcode.binarytree.serialization;

import java.util.ArrayDeque;
import java.util.Deque;

import type.TreeNode;
import util.TreeNodeUtil;

public class SerializeAndDeserializeBinaryTree_LE_297_P1 {
    /*
        P1
        - read huifeng guan's video, and it is still best use PreOrder traverse. Note "only preorder traverse can settle a fixed tree".
        - use preorder traverse in both se and de. In De use StringTokenizer class as a help.
        - refactor with Queue to replace StringTokenizer, since it is supported by LC by default. Slower than StringTokenizer, but safer.
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb);

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("# ");
        } else {
            sb.append(node.val + " ");
            seHelper(node.left, sb);
            seHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new ArrayDeque<>();
        String[] arr = data.split(" ");
        for (int i = 0; i < arr.length; i++) {
            queue.offerLast(arr[i]);
        }

        return deHelper(queue);
    }

    private TreeNode deHelper(Deque<String> queue) {
        String cur = queue.pollFirst();
        if (cur.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = deHelper(queue);
            node.right = deHelper(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree_LE_297_P1 solution = new SerializeAndDeserializeBinaryTree_LE_297_P1();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        String serialization = solution.serialize(treeNode);
        System.out.println(serialization);
        TreeNodeUtil.printTree(solution.deserialize(serialization));
    }

}
