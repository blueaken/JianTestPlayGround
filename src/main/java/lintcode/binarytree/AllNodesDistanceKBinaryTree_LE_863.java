package lintcode.binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import type.TreeNode;
import util.TreeNodeUtil;

public class AllNodesDistanceKBinaryTree_LE_863 {
    /*
        Idea: the trick of this problem is TreeNode class does not record parent node, have to find a workaround. I think
        my solution is more precise than the ones from solution link.

        step 1. find the target node and record the nodes on the path
        step 2. search downwards from target node with distance k
        step 3.1 if the path size greater or equal to k, then add the pathToTarget.size() - k node to the result.
        step 3.2 otherwise, search downwards from root node with distance k - pathToTarget.size(), and exclude the one from
                 the pathToTarget.

        Note: not ACed, it turns out very error prone and have some side case to consider. revisit later.
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> pathToTarget = new ArrayList<>();

        TreeNode targetNode = findTarget(root, target, pathToTarget);
        if (targetNode == null) {
            return res;
        }

        searchDownwards(targetNode, k, res);

        //search upwards
        if (pathToTarget.size() >= k) {
            res.add(pathToTarget.get(pathToTarget.size() - k));
        } else {
            int dis = k - pathToTarget.size();
            searchDownwards(root, dis, res);
            //remove nodes from path to target since they are already visited
            Set<Integer> visited = new HashSet<>(pathToTarget);
            visited.add(target.val);
            for (int i = 0; i < res.size(); i++) {
                if (visited.contains(res.get(i))) {
                    res.remove(i);
                }
            }
        }
        return res;
    }

    private void searchDownwards(TreeNode target, int k, List<Integer> res) {
        if (k == 0) {
            res.add(target.val);
            return;
        }
        if (target.left != null) {
            searchDownwards(target.left, k - 1, res);
        }
        if (target.right != null) {
            searchDownwards(target.right, k - 1, res);
        }

    }

    private TreeNode findTarget(TreeNode root, TreeNode target, List<Integer> pathToTarget) {
        if (root.val == target.val) {
            return root;
        }
        pathToTarget.add(root.val);
        TreeNode targetNode;
        if (root.left != null) {
            targetNode = findTarget(root.left, target, pathToTarget);
            if (targetNode != null) {
                return targetNode;
            }
        }
        if (root.right != null) {
            targetNode = findTarget(root.right, target, pathToTarget);
            if (targetNode != null) {
                return targetNode;
            }
        }
        //if miss then backtrace
        pathToTarget.remove(pathToTarget.size() - 1);
        return null;
    }

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree_LE_863 solution = new AllNodesDistanceKBinaryTree_LE_863();
//        int[] input = {3,5,1,6,2,0,8,-999,-999,7,4};
//        TreeNode root = TreeNodeUtil.buildTree(input);
//        TreeNode target = new TreeNode(5);
//        int k = 2;
//        //[7, 4, 1]

//        int[] input = {0,1,-999,3,2};
//        TreeNode root = TreeNodeUtil.buildTree(input);
//        TreeNode target = new TreeNode(2);
//        int k = 1;
//        //[1]

//        int[] input = {0,2,1,-999,-999,3};
//        TreeNode root = TreeNodeUtil.buildTree(input);
//        TreeNode target = new TreeNode(3);
//        int k = 3;
//        //[2]

        int[] input = {0,1,-999,-999,2,-999,3,-999,4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNode target = new TreeNode(3);
        int k = 0;
        //[7, 4, 1]

        System.out.println(solution.distanceK(root, target, k).toString());
    }
}
