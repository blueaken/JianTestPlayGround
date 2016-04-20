package ninechapter_algorithm.chapter3_binarytree_and_divideconquer.optional.constructbstwithinorderandpostorder;

import type.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 4/20/16 11:52 AM
 */
public class Solution {

    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || inorder.length == 0
                || postorder == null || postorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        //map the position of inorder array
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private TreeNode helper(int[] postorder, int postL, int postR, int[]inorder, int inL, int inR, Map<Integer, Integer> map) {
        if (inL > inR || postL > postR) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postR]);
        int rootIdx = map.get(postorder[postR]);

        int leftLen = rootIdx - inL;

        node.left = helper(postorder, postL, postL + leftLen - 1, inorder, inL, rootIdx - 1, map);
        node.right = helper(postorder, postL + leftLen, postR - 1, inorder, rootIdx +1, inR, map);
        return node;
    }

    public static void main(String[] args) {
        int[] postorder = {4,5,2,8,6,7,3,1};
        int[] inorder = {4,2,5,1,6,8,3,7};

        Solution solution = new Solution();
        solution.buildTree(inorder, postorder);
    }
}
