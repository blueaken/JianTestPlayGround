package lintcode.binarytree;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal_LE_889 {
    /*
        11.07.2022
        ref labuladong post, similar to 105, 106
        - solve with 遍历
        - use HashMap to avoid traverse postorder array each time
    */
    Map<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            postMap.put(postorder[i], i);
        }

        return helper(preorder, 0, n-1, postorder, 0, n-1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftChildVal = preorder[preStart+1];//preorder[preStart+1] can be right child root val if left child is null, there in no info can tell, so there are multiple answers, here is just one of them
        int leftChildIdx = postMap.get(leftChildVal);

        int leftSize = leftChildIdx - postStart + 1;

        TreeNode node = new TreeNode(rootVal);
        node.left = helper(preorder, preStart+1, preStart+leftSize, postorder, postStart, leftChildIdx);
        node.right = helper(preorder, preStart+leftSize+1, preEnd, postorder, leftChildIdx+1, postEnd-1);
        return node;
    }
}
