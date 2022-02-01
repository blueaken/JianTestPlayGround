package lintcode.heap;

import java.util.*;

class Movie {
    int id;
    int rating;

    Movie (int id, int rating) {
        this.id = id;
        this.rating = rating;
    }
}

public class TopKMovie_808 {
    /**
     * @param rating: the rating of the movies
     * @param G: the realtionship of movies
     * @param S: the begin movie
     * @param K: top K rating
     * @return: the top k largest rating moive which contact with S
     */
    //Idea: 从S出发DFS的同时维护一个大小为K的priority queue即可。
    //Ref - https://www.lintcode.com/problem/808/solution/25910
    public List<Integer> topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
        PriorityQueue<Movie> heap = new PriorityQueue<>(K, new Comparator<Movie>() {
            @Override
            public int compare (Movie a, Movie b) {
                return a.rating - b.rating;
            }
        });

        boolean[] visited = new boolean[rating.length];
        dfs(S, S, K, G, rating, visited, heap);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            if (heap.size() > 0) {
                Movie cur = heap.poll();
                res.add(cur.id);
            }
        }
        return res;
    }

    private void dfs (int curId, int S, int K, int[][] G, int[] rating, boolean[] visited, PriorityQueue<Movie> heap) {
        if(visited[curId] == true) {
            return;
        }
        visited[curId] = true;
        if (curId != S) {
            heap.offer(new Movie(curId, rating[curId]));
            if (heap.size () > K) {
                heap.poll();
            }
        }
        for (int i = 0; i < G[curId].length; i++) {
            dfs(G[curId][i], S, K, G, rating, visited, heap);
        }
    }

    public static void main(String[] args) {
//        int[] rating = {10,20,30,40};
//        int[][] G = {{1,3},{0,2},{1},{0}};
//        int S = 0;
//        int K = 2;

        int[] rating = {10,20,30,40,50,60,70,80,90};
        int[][] G = {{1,4,5},{0,2,3},{1,7},{1,6,7},{0},{0},{3},{2,3},{}};
        int S = 5;
        int K = 3;

        TopKMovie_808 solution = new TopKMovie_808();
        System.out.println(solution.topKMovie(rating, G, S, K));
    }

}
