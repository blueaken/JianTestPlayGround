package lintcode.graph;

import java.util.*;

public class EvaluateDivision_LE_399 {
    /*
        - it is actually a graph question
        - 有DFS和Union Find两种解法，ref 花花 https://www.youtube.com/watch?v=UwpvInpgFmo
    */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            if (!graph.containsKey(u)) {
                graph.put(u, new HashMap<String, Double>());
            }
            if (!graph.containsKey(v)) {
                graph.put(v, new HashMap<String, Double>());
            }
            graph.get(u).put(v, values[i]);
            graph.get(v).put(u, 1 / values[i]);
        }

        //go through queries
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                ans[i] = -1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            ans[i] = dfs(graph, u, v, visited);
        }
        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String u, String v, Set<String> visited) {
        if (u.equals(v)) {
            return 1.0;
        }
        visited.add(u);
        Map<String, Double> neighbors = graph.get(u);

        for (String next : neighbors.keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            double val = dfs(graph, next, v, visited);
            if (val > 0) {
                return val * neighbors.get(next);
            }
        }
        return -1.0; // if no edge exists
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        List<String> equation3 = new ArrayList<>();
        equation3.add("a");
        equation3.add("d");
        equations.add(equation1);
        equations.add(equation2);
        equations.add(equation3);

        double[] values = {2.0,3.0,4.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        List<String> query5 = new ArrayList<>();
        query5.add("x");
        query5.add("x");
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);

        EvaluateDivision_LE_399 solution = new EvaluateDivision_LE_399();
        System.out.println(Arrays.toString(solution.calcEquation(equations, values, queries)));
    }
}
