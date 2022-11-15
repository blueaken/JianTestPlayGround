package lintcode.binarytree;

import type.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest_LE_1110 {
    /**
     11.15.2022
     ref东哥post
     - 不涉及subtree问题，可以不用post traverse
     - 使用pre traverse获得父节点信息可以handle
     */
    List<TreeNode> res = new ArrayList<>();
    Set<Integer> delSet = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return res;
        }

        for (int i : to_delete) {
            delSet.add(i);
        }

        preOrder(root, false);
        return res;
    }

    private TreeNode preOrder(TreeNode node, boolean hasParent) {
        if (node == null) {
            return null;
        }

        boolean deleted = delSet.contains(node.val);
        //如果没有父节点并且又不是要删除的节点，则是remaining forest的一个root node
        if (!hasParent && !deleted) {
            res.add(node);
        }

        node.left = preOrder(node.left, !deleted);
        node.right = preOrder(node.right, !deleted);

        return deleted ? null : node;
    }
}
