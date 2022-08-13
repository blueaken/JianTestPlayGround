package lintcode.matrix;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ShortestPathBinaryMatrix_LE_1091 {
    /*
        - basically a BFS, utilize javafx.util.Pair class for position comparison
    */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        //use javafx.util.Pair class again, so as to use its equal method for Hashset class
        Pair<Integer, Integer> ori = new Pair<>(0, 0);
        Deque<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offerFirst(ori);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(ori);

        int[] dx = {1,0,-1,0,1,1,-1,-1};
        int[] dy = {0,-1,0,1,1,-1,-1,1};

        //bfs
        int path = 1;
        while (queue.size() > 0) {
            int size = queue.size();
            //process current layer
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = queue.pollFirst();
                int curx = cur.getKey();
                int cury = cur.getValue();

                if (curx == n-1 && cury == n-1) {
                    return path;
                }

                for (int j = 0; j < 8; j++) {
                    int newx = curx + dx[j];
                    int newy = cury + dy[j];
                    if (newx < 0 || newx == n || newy < 0 || newy == n || grid[newx][newy] == 1) {
                        continue;
                    }

                    Pair<Integer, Integer> newCell = new Pair<>(newx, newy);
                    if (!visited.contains(newCell)) {
                        visited.add(newCell);
                        queue.offerLast(newCell);
                    }
                }
            }
            path++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix_LE_1091 solution = new ShortestPathBinaryMatrix_LE_1091();
//        int[][] grid = {{0,1},{1,0}};//2
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}}; //4
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}
