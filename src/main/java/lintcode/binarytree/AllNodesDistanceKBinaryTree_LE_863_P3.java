package lintcode.binarytree;

import type.TreeNode;

import java.util.*;

public class AllNodesDistanceKBinaryTree_LE_863_P3 {
    /*
        P2
        - read prev notes, using dfs build parent map then BFS
        - Time is O(N) + O(N) = O(N)
        =============
        P3 11.14.2022
        =============
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par = new HashMap<>();
        traverse(root, null, par);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int dist = 0;

        List<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            if (dist == k) {
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
                break;
            }

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }
                TreeNode parent = par.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            dist++;
        }
        return res;

    }

    private void traverse(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> par) {
        if (node == null) {
            return;
        }
        par.put(node, parent);
        traverse(node.left, node, par);
        traverse(node.right, node, par);
    }
}
