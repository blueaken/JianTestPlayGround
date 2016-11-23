package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.constructbstwithinorderandpreorder;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 4/20/16 10:26 AM
 */
public class Solution {

    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || preorder.length == 0
                || inorder == null || inorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        //map the position of inorder array
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode helper(int[] preorder, int preL, int preR, int[]inorder, int inL, int inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preL]);
        int rootIdx = map.get(preorder[preL]);

        int leftLen = rootIdx - inL;

        node.left = helper(preorder, preL + 1, preL + leftLen, inorder, inL, rootIdx - 1, map);
        node.right = helper(preorder, preL + leftLen + 1, preR, inorder, rootIdx +1, inR, map);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6,8,7};
        int[] inorder = {4,2,5,1,6,8,3,7};

        Solution solution = new Solution();
        solution.buildTree(preorder, inorder);
    }
}
