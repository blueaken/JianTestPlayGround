package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrieMap<V> {

    // ASCII 码个数
    private static final int R = 256;

    // 当前存在 Map 中的键值对个数
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        Map<Character, TrieNode> children;
    }

    // Trie 树的根节点
    private TrieNode<V> root = null;

    /***** 增/改 *****/

    // 在 Map 中添加 key
    public void put(String key, V val) {
        if (containsKey(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }

    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieNode<>();
        }
        if (i == key.length()) {
            node.val = val;
            return node;
        }

        char c = key.charAt(i);
        node.children.put(c, put(node.children.get(c), key, val, i+1));
        return node;
    }

    /***** 删 *****/

    // 删除键 key 以及对应的值
    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        root = remove(root, key, 0);
        size--;
    }

    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null) {
            return null;
        }
        if (i == key.length()) {
            node.val = null;
        } else {
            char c = key.charAt(i);
            node.children.put(c, remove(node.children.get(c), key, i+1));
        }

        // 后序位置，递归路径上的节点可能需要被清理
        if (node.val != null) {
            return node;
        }

        // 检查该 TrieNode 是否还有后缀
        for (int c = 0; c < R; c++) {
            if (node.children.containsKey(c)) {
                return node;
            }
        }

        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }

    /***** 查 *****/

    // 搜索 key 对应的值，不存在则返回 null
    // get("the") -> 4
    // get("tha") -> null
    public V get(String key) {
        // 从 root 开始搜索 key
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            // x 为空或 x 的 val 字段为空都说明 key 没有对应的值
            return null;
        }
        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    // containsKey("tea") -> false
    // containsKey("team") -> true
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // 在 Map 的所有键中搜索 query 的最短前缀
    // shortestPrefixOf("themxyz") -> "the"
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                return query.substring(0, i);
            }

            // 向下搜索
            char c = query.charAt(i);
            p = p.children.get(c);
        }
        if (p != null && p.val != null) {
            // 如果 query 本身就是一个键
            return query;
        }
        return "";
    }

    // 在 Map 的所有键中搜索 query 的最长前缀
    // longestPrefixOf("themxyz") -> "them"
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        int max_len = 0;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                max_len = i;
            }

            // 向下搜索
            char c = query.charAt(i);
            p = p.children.get(c);
        }
        if (p != null && p.val != null) {
            // 如果 query 本身就是一个键
            return query;
        }
        return query.substring(0, max_len);
    }

    // 搜索所有前缀为 prefix 的键
    // keysWithPrefix("th") -> ["that", "the", "them"]
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }

        //DFS
        traverse(x, new StringBuilder(prefix), res);
        return res;
    }

    // 遍历以 node 节点为根的 Trie 树，找到所有键
    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) {
            // 到达 Trie 树底部叶子结点
            return;
        }

        if (node.val != null) {
            // 找到一个 key，添加到结果列表中
            res.add(path.toString());
        }

        for (char c = 0; c < R; c++) {
            //用回溯法遍历
            if (node.children.containsKey(c)) {
                path.append(c);
                traverse(node.children.get(c), path, res);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    // 判断是和否存在前缀为 prefix 的键
    // hasKeyWithPrefix("tha") -> true
    // hasKeyWithPrefix("apple") -> false
    public boolean hasKeyWithPrefix(String prefix) {
        // 只要能找到一个节点，就是存在前缀
        return getNode(root, prefix) != null;
    }

    // 通配符 . 匹配任意字符，搜索所有匹配的键
    // keysWithPattern("t.a.") -> ["team", "that"]
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node == null) {
            // 树枝不存在，匹配失败
            return;
        }
        if (i == pattern.length()) {
            // pattern匹配完成
            if (node.val != null) {
                res.add(path.toString());
            }
        }

        char c = pattern.charAt(i);
        if (c == '.') {
            // 多叉树（回溯算法）遍历框架
            for (char j = 0; j < R; j++) {
                path.append(j);
                traverse(node.children.get(j), path, pattern, i+1, res);
                path.deleteCharAt(path.length()-1);
            }
        } else {
            path.append(c);
            traverse(node.children.get(c), path, pattern, i+1, res);
            path.deleteCharAt(path.length()-1);
        }
    }

    // 通配符 . 匹配任意字符，判断是否存在匹配的键
    // hasKeyWithPattern(".ip") -> true
    // hasKeyWithPattern(".i") -> false
    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }

    private boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        if (node == null) {
            return false;
        }
        if (i == pattern.length()) {
            return node.val != null;
        }

        char c = pattern.charAt(i);
        if (c == '.') {
            // 多叉树（回溯算法）遍历框架
            for (char j = 0; j < R; j++) {
                if(hasKeyWithPattern(node.children.get(j), pattern, i+1)) {
                    return true;
                };
            }
        } else {
            return hasKeyWithPattern(node.children.get(c), pattern, i+1);
        }
        return false;
    }

    // 返回 Map 中键值对的数量
    public int size() {
        return size;
    }

    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        // 从节点 node 开始搜索 key
        for (int i = 0; i < key.length(); i++) {
//            if (p == null) {
//                // 无法向下搜索
//                return null;
//            }
            // 向下搜索
            char c = key.charAt(i);
            if (p.children.containsKey(c)) {
                p = p.children.get(c);
            } else {
                return null;
            }
//            p = p.children.get(c);
        }
        return p;
    }
}
