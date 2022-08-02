package lintcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponents_LE_323 {
    /*
        - similar to 200 & 547
        - conver to a adjacent map, and the Time is O(V + E); Space is the same
    */

    Map<Integer, List<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        //build the map from the edges array
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            ans++;
            dfs(i, visited);
        }
        return ans;
    }

    private void dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        for (Integer neighbor : map.get(cur)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }
}
