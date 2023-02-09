package lintcode.trie.labuladong;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem_LE_1166 {
    /**
     2.8.2023
     - 基本上用TrieTree实现时间和空间效率最高，将东哥模板修改一下来做
     */

    TrieMap_LE_1166<Integer> map;

    public DesignFileSystem_LE_1166() {
        map = new TrieMap_LE_1166<>();
    }

    public boolean createPath(String path, int value) {
        if (map.contains(path)) {
            return false;
        }

        return map.put(path, Integer.valueOf(value)) != null;
    }

    public int get(String path) {
        Integer v = map.get(path);
        return v == null ? -1 : v;
    }

    public static void main(String[] args) {
        DesignFileSystem_LE_1166 solution = new DesignFileSystem_LE_1166();
//        System.out.println(solution.createPath("/a",1)); //true
//        System.out.println(solution.get("/a")); //1

        System.out.println(solution.createPath("/leet",1)); //true
        System.out.println(solution.createPath("/leet/code",2)); //true
        System.out.println(solution.get("/leet/code")); //2
        System.out.println(solution.createPath("/c/d",1)); //false, since /c does not exist yet
        System.out.println(solution.get("/c")); //-1, not existing yet

    }
}

class TrieMap_LE_1166<V> {
    private static class TrieNode<V> {
        V val = null;
        Map<String, TrieNode> children = new HashMap<>();
    }
    TrieNode root = new TrieNode<>();

    public TrieNode<V> put(String path, V val) {
        String[] components = path.split("/");
        return put(root, components, 1, val);
    }

    private TrieNode<V> put(TrieNode<V> node, String[] components, int pos, V val) {
        if (node == null) {
            if (pos < components.length) {
                return null;
            }
            node = new TrieNode<>();
        }
        if (pos == components.length) {
            node.val = val;
            return node;
        }

        String curComponent = components[pos];
        TrieNode<V> sub = put(node.children.get(curComponent), components, pos+1, val);
        if (sub != null) {
            node.children.put(curComponent, sub);
            return node;
        } else {
            return null;
        }

    }

    public boolean contains(String path) {
        return (get(path) != null);
    }

    public V get(String path) {
        TrieNode<V> x = getNode(root, path);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }

    // 从节点 node 开始搜索 path，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String path) {
        TrieNode<V> p = node;
        // 从节点 node 开始搜索 path
        String[] components = path.split("/");
        for (int i = 1; i < components.length; i++) {
            if (p == null) {
                // 无法向下搜索
                return null;
            }
            String currentComponent = components[i];
            p = p.children.get(currentComponent);
        }
        return p;
    }

}