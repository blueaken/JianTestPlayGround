package lintcode.binarytree;

import java.util.*;

import type.TreeNode;
import util.TreeNodeUtil;

public class AllNodesDistanceKBinaryTree_LE_863_AnnotateParent {
    /*
        Idea: the trick of this problem is TreeNode class does not record parent node, have to find a workaround. I think
        my solution is more precise than the ones from solution link.

        step 1. find the target node and record the nodes on the path
        step 2. search downwards from target node with distance k
        step 3.1 if the path size greater or equal to k, then add the pathToTarget.size() - k node to the result.
        step 3.2 otherwise, search downwards from root node with distance k - pathToTarget.size(), and exclude the one from
                 the pathToTarget.
        turns out there are many side cases in step 3, try another way -

        - the problem is the TreeNode class does not record parent node, how about build the parent relation of it, ref solution page - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solution/
        step 1. record parent node relationship via dfs - O(N) time
        step 2. bfs from the target node - O(N) time
        Space also O(N) for the map (O(N)) and dfs recursive call stack O(LogN), can be simplified to O(N)


     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par = new HashMap<>();
        dfs(root, null, par);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int move = 0;
        while(queue.size() > 0) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                if (move == k) {
                    List<Integer> res = new ArrayList<>();
                    for (TreeNode n : queue) {
                        res.add(n.val);
                    }
                    return res;
                } else {
                    queue.offer(null);
                    move++;
                }
            } else {
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.offer(cur.right);
                }

                TreeNode parent = par.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
        }

        return new ArrayList<Integer>();
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> par) {
        if (node != null) {
            par.put(node, parent);
            dfs(node.left, node, par);
            dfs(node.right, node, par);
        }
    }

    public static void main(String[] args) {
        AllNodesDistanceKBinaryTree_LE_863_AnnotateParent solution = new AllNodesDistanceKBinaryTree_LE_863_AnnotateParent();
        int[] input = {3,5,1,6,2,0,8,-999,-999,7,4};
        TreeNode root = TreeNodeUtil.buildTree(input);
        TreeNode target = solution.searchTarget(root,5);
        int k = 2;
        //[7, 4, 1]

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

        System.out.println(solution.distanceK(root, target, k).toString());
    }

    private TreeNode searchTarget(TreeNode root, int val) {
        TreeNode target = null;
        if (root != null) {
            if (root.val == val) {
                return root;
            }
            if (target == null) {
                target = searchTarget(root.left, val);
            }
            if (target == null) {
                target = searchTarget(root.right, val);
            }
        }
        return target;
    }
}
