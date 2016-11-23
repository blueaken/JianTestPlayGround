package leetcode.algorithm.medium.convertsortedarraytobinarysearchtree;

import type.TreeNode;

/**
 * Author: blueaken
 * Date: 9/30/15 9:14 AM
 */
public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null) return null;
        TreeNode bst = rec(nums, 0, nums.length-1);
        return bst;
    }

    static TreeNode rec(int[] nums, int start, int end){
        //close condition;
        if (start>end) return null;

        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = rec(nums, start, mid-1);
        node.right = rec(nums, mid+1, end);

        return node;
    }

    public static void main(String[] args){
        int[] sortedArr = {1,2,3,4,5,6,7,8,9};
        TreeNode bst = sortedArrayToBST(sortedArr);
    }

}
