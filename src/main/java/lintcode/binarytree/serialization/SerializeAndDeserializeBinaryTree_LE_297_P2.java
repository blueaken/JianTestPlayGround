package lintcode.binarytree.serialization;

import type.TreeNode;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree_LE_297_P2 {
    /*
        P1
        - read huifeng guan's video, and it is still best use PreOrder traverse. Note "only preorder traverse can settle a fixed tree".
        - use preorder traverse in both se and de. In De use StringTokenizer class as a help.
        - refactor with Queue to replace StringTokenizer, since it is supported by LC by default.
        ================
        P2 11.08.2022
        - ref 东哥 post this time
        - solve by preorder traverse
    */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        seHelper(root, sb);

        return sb.toString();
    }

    private void seHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('#').append(',');
            return;
        }

        sb.append(node.val).append(',');
        seHelper(node.left, sb);
        seHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    // 在105和106中需要2种遍历数组才能构造一棵树，但那是因为没有空位置的原因；有了空位置可以用一个先序数组直接构造，方法也是同样先确定root节点，再进一步处理
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>();
        for (String s : data.split(",")) {
            queue.addLast(s);
        }

        return deHelper(queue);
    }

    private TreeNode deHelper(LinkedList<String> queue) {
        if (queue.size() == 0) {
            return null;
        }

        String cur = queue.removeFirst();
        if (cur.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = deHelper(queue);
        node.right = deHelper(queue);

        return node;
    }
}
