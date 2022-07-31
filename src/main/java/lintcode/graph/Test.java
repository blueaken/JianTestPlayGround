package lintcode.graph;

import java.util.*;

public class Test {
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
        dfs(0, -1,0);

        return ans;
    }

    public int dfs(int node, int par, int rank){
        jump[node] = rank;
        for(Integer neighbor: graph.get(node)){
            if(neighbor == par){
                //if neighbor is parent then just continue to avoid loop
                continue;
            }else if(jump[neighbor] == Integer.MAX_VALUE){
                //not yet reached node
                int recursiveRank = dfs(neighbor, node, rank + 1);
                jump[node] = Math.min(jump[node], recursiveRank);
            }else{
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
        Test solution = new Test();
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
