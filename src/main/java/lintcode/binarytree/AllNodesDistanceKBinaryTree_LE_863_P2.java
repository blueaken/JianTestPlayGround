package lintcode.binarytree;

import java.util.*;

import type.TreeNode;

public class AllNodesDistanceKBinaryTree_LE_863_P2 {
    /*
        P2
        - read prev notes, using dfs build parent map then BFS
        - Time is O(N) + O(N) = O(N)
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> par = new HashMap<>(); //node, parent
        dfs(root, null, par);

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int move = 0;

        List<Integer> res = new ArrayList<>();
        while (queue.size() > 0) {
            if (move == k) {
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
                break;
            }

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.pollLast();
                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.offerFirst(cur.left);
                    visited.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.offerFirst(cur.right);
                    visited.add(cur.right);
                }
                TreeNode parent = par.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    queue.offerFirst(parent);
                    visited.add(parent);
                }
            }
            move++;
        }
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> par) {
        if (node != null) {
            par.put(node, parent);
            dfs(node.left, node, par);
            dfs(node.right, node, par);
        }
    }
}
