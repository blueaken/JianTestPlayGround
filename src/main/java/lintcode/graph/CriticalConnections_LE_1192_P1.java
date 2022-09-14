package lintcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnections_LE_1192_P1 {
    /*
        P1
        - read previous note and video again and do it
======================================================================
        ref - https://www.youtube.com/watch?v=mKUsbABiwBI
        Note - 1st submit has a strange error, the test case 16 failed, ref to a similar java solution link - https://leetcode.jp/leetcode-1192-critical-connections-in-a-network-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
             - finally found my first dfs signature mixed the "Integer" and "int" declaration together "private int dfs(Integer node, Integer par, int rank)" after changed to "private int dfs(int node, int par, int rank)", this test case passed
            - but the declaration of Wrapper class type and primitive type should not matter, not sure why, and just marked here
=======================================================================
    */

    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] jump;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        jump = new int[n];

        //build graph and init jump value all to INF
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            jump[i] = Integer.MAX_VALUE;
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1, 0); //assume node 0's parent is -1
        return ans;
    }

    private int dfs(int node, int parent, int rank) {
        //first need to init current node's rank
        jump[node] = rank;
        for (Integer neighbor : graph.get(node)) {
            //skip parent to avoid infinite loop
            if (neighbor == parent) {
                continue;
            }
            if (jump[neighbor] == Integer.MAX_VALUE) {
                //unreached node
                int recRank = dfs(neighbor, node, rank + 1);
                jump[node] = Math.min(jump[node], recRank);
            } else {
                //visited node
                jump[node] = Math.min(jump[node], jump[neighbor]);
            }
        }

        //note - need to skip node 0
        if (jump[node] == rank && parent != -1) {
            //rank unchange after dfs, then a critical path found
            List<Integer> t = new ArrayList<>();
            t.add(node);
            t.add(parent);
            ans.add(t);
        }

        return jump[node];
    }
}
