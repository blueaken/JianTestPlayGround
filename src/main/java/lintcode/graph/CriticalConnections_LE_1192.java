package lintcode.graph;

import java.util.*;

public class CriticalConnections_LE_1192 {
    /*
        ref - https://www.youtube.com/watch?v=mKUsbABiwBI
        Note - 1st submit has a strange error, the test case 16 failed, ref to a similar java solution link - https://leetcode.jp/leetcode-1192-critical-connections-in-a-network-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
             - finally found my first dfs signature mixed the "Integer" and "int" declaration together "private int dfs(Integer node, Integer par, int rank)" after changed to "private int dfs(int node, int par, int rank)", this test case passed
            - but the declaration of Wrapper class type and primitive type should not matter, not sure why, and just marked here
    */
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] jump;
    List<List<Integer>> ans = new ArrayList();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (n < 2) {
            return ans;
        }

        //Build the graph & Default rank for unvisited nodes is "MAX Integer value"
        jump = new int[n];
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<>());
            this.jump[i] = Integer.MAX_VALUE;
        }

        for (List<Integer> edge : connections) {
            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
        }

        //assume Node 0's parent node is -1
        dfs(0, -1, 0);

        return ans;
    }

    private int dfs(int node, int par, int rank) {
        jump[node] = rank;
        for (Integer neighbor : this.graph.get(node)) {
            if (neighbor == par) {
                //if neighbor is parent then just continue to avoid loop
                continue;
            } else if (jump[neighbor] == Integer.MAX_VALUE) {
                //not yet reached node
                int recursiveRank = dfs(neighbor, node, rank + 1);
                jump[node] = Math.min(jump[node], recursiveRank);
            } else {
                //if neighbor has been visited and not parent, get the lower rank as current rank
                jump[node] = Math.min(jump[node], jump[neighbor]);
            }
        }

        //if current node's rank value unchanged after DFS, then a critical path identified
        if (jump[node] == rank && par != -1) {
            ans.add(Arrays.asList(par, node));
        }

        return jump[node];
    }

    public static void main(String[] args) {
        CriticalConnections_LE_1192 solution = new CriticalConnections_LE_1192();
        int n = 4;
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);

        List<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(2);

        List<Integer> edge3 = new ArrayList<>();
        edge3.add(2);
        edge3.add(0);

        List<Integer> edge4 = new ArrayList<>();
        edge4.add(1);
        edge4.add(3);

        List<List<Integer>> connections = new ArrayList<>();
        connections.add(edge1);
        connections.add(edge2);
        connections.add(edge3);
        connections.add(edge4);
        //expect [[1,3]]

        System.out.println(solution.criticalConnections(n, connections));
    }
}
