package lintcode.binarytree;

import type.MultiTreeNode;
import type.TreeNodeResultType_LC;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive3_619 {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return dfs (root).max_length;
    }

    private TreeNodeResultType_LC dfs (MultiTreeNode node) {
        if (node == null) {
            return new TreeNodeResultType_LC(0,0,0);
        }

        Map<MultiTreeNode, TreeNodeResultType_LC> resultTypeMap = new HashMap<>();
        for (MultiTreeNode child : node.children) {
            resultTypeMap.put(child, dfs(child));
        }

        //每一轮递归这3个值都要重置
        int up = 0;
        int down = 0;
        int max_length = 1;

        for (MultiTreeNode child : node.children) {
            if (child != null && (child.val - node.val) == 1) {
                up = Math.max(up, resultTypeMap.get(child).max_up + 1);
            }
            if (child != null && (node.val - child.val) == 1) {
                down = Math.max(down, resultTypeMap.get(child).max_down + 1);
            }
        }

        // 此时的 max_length 代表不经过 root 结点的各子树max_length中的最大值
        // 然后和经过 root 计算出来的长度比较看哪个大
        for (MultiTreeNode child : node.children) {
            max_length = Math.max(max_length, resultTypeMap.get(child).max_length);
        }

        //经过 root 计算出来的长度
        int length = up + 1 + down;
        length = Math.max(length, max_length);
        return new TreeNodeResultType_LC(length, up, down);
    }
}