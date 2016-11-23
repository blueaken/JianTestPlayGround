package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.constructbstwithinorderandpreorder.second;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 6/29/16 09:26
 */
public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return rec(preorder, 0, preorder.length -1, 0, inorder.length - 1, inMap);
    }

    private TreeNode rec(int[] preorder, int preL, int preR, int inL, int inR,
                         Map<Integer, Integer> inMap) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int current = preorder[preL];
        TreeNode node = new TreeNode(current);
        int inIndex = inMap.get(current);

        int leftInL = inL;
        int leftInR = inIndex - 1;
        int leftLen = leftInR - leftInL + 1;
        int leftPreL = preL + 1;
        int leftPreR = leftPreL + leftLen - 1;

        int rightInL = inIndex + 1;
        int rightInR = inR;
        int rightPreL = leftPreR + 1;
        int rightPreR = preR;

        node.left = rec(preorder, leftPreL, leftPreR, leftInL, leftInR, inMap);
        node.right = rec(preorder, rightPreL, rightPreR, rightInL, rightInR, inMap);
        return node;
    }
}
