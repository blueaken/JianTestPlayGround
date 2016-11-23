package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.binarytreeserialization.second;

import type.TreeNode;

import java.util.StringTokenizer;

/**
 * Author: blueaken
 * Date: 6/29/16 11:29
 */
public class Solution {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        seHelper(sb, root);
        return sb.deleteCharAt(sb.length() -1).toString();
    }

    private void seHelper(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val + ",");
        seHelper(sb, node.left);
        seHelper(sb, node.right);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        StringTokenizer st = new StringTokenizer(data, ",");
        return deHelper(st);
    }

    private TreeNode deHelper(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }

        String current = st.nextToken();
        if (current.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(current));
            node.left = deHelper(st);
            node.right = deHelper(st);
            return node;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        String serialization = solution.serialize(treeNode);
        System.out.println(serialization);
        solution.deserialize(serialization);
    }
}
