package lintcode.binarytree.serialization;

import type.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_LE_652 {
    /**
     11.08.2022
     ref东哥post
     - 子树问题使用post traverse
     - 通过后序遍历构造序列化String来了解自身的结构 + 通过HashMap来发现存在相同结构而且返回1次
     */
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    private String serialize(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = serialize(node.left);
        String right = serialize(node.right);
        String myself = left + "," + right + "," + node.val;

        int freq = map.getOrDefault(myself, 0);
        //same duplicate subtrees should only record once
        if (freq == 1) {
            res.add(node);
        }

        map.put(myself, freq+1);
        return myself;
    }
}
