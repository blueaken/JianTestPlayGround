package leetcode.medium.convertsortedarraytobinarysearchtree.second;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 2/11/16 2:04 PM
 */
public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return rec(nums, 0, nums.length-1);
    }

    private static TreeNode rec(int[] data, int start, int end){
        if (start>end) return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(data[mid]);
        node.left = rec(data, start, mid-1);
        node.right = rec(data, mid+1, end);

        return node;
    }

    public static void main(String[] args){
        int[] sortedArr = {1,2,3,4,5,6,7,8,9};
        TreeNode bst = sortedArrayToBST(sortedArr);

        realworld.emc.printbinarysearchtree.Solution.printBinaryTree(bst);
    }
}
