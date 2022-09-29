package lintcode.binarytree.serialization;

import type.TreeNode;
import util.TreeNodeUtil;

import java.util.StringTokenizer;

public class SerializeAndDeserializeBinaryTree_LE_297 {
    /*
        - ref https://www.youtube.com/watch?v=JL4OjKV_pGE
        - basically using preorder traverse for both se & de
        - in the video, since it is c++, he also use binary to avoid the cost of int to string conversion, which is expensive when the integer is big
        - but this problem, node value is between [-1000, 1000], should not a huge improvement
     */


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb);

        //remove the end space and return
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb) {
        //write cur node val
        if (node == null) {
            sb.append("# ");
            return;
        } else {
            sb.append(node.val + " ");
        }
        seHelper(node.left, sb);
        seHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data, " ");
        return deHelper(st);
    }

    private TreeNode deHelper(StringTokenizer st) {
        //read cur pos val
        if (!st.hasMoreTokens()) {
            return null;
        }

        String cur = st.nextToken();
        if (cur.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(cur));
            node.left = deHelper(st);
            node.right = deHelper(st);
            return node;
        }
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree_LE_297 solution = new SerializeAndDeserializeBinaryTree_LE_297();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);

        String serialization = solution.serialize(treeNode);
        System.out.println(serialization);
        TreeNodeUtil.printTree(solution.deserialize(serialization));
    }
}
