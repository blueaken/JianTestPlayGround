package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.binarytreeserialization;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 4/20/16 4:46 PM
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
        preOrder(root, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
            return;
        }

        sb.append(node.val);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */

    class InputType {
        String data;
        int pos;

        public InputType(String data, int pos) {
            this.data = data;
            this.pos = pos;
        }
    }

    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0)
            return null;

        InputType input = new InputType(data, 0);
        return helper(input);
    }

    private TreeNode helper(InputType input) {
        if (input.pos == input.data.length()) {
            return null;
        }

        char cur = input.data.charAt(input.pos);
        input.pos++;
        TreeNode node;
        if (cur == '#') {
            return null;
        } else {
            node = new TreeNode(cur - '0');
            node.left = helper(input);
            node.right = helper(input);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        Solution solution = new Solution();
        String serialization = solution.serialize(treeNode);
        System.out.println(serialization);
        solution.deserialize(serialization);
    }
}
