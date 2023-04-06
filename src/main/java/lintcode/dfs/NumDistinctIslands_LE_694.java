package lintcode.dfs;

//import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class NumDistinctIslands_LE_694 {
    /*
        - Ref the Solution video
        - 1. Use DFS find the number of islands
        - 2. Transfer each cell of the island coordinate from global to local, so as to tell if the shape of 2 islands are the same or not
        - 3. Stores the island local coordinate in the HashSet
        - 4. return the size the final HashSet

        The nice thing of this approach is to store the hash value of the island, and the hash is automatically filtered out the duplicate shape:

        Time - O(M * N), Space - O(M * N)

        - A further improvement is to store directions of the islands, instead of coordinates

    */
    private int curRow;
    private int curCol;

//    public int numDistinctIslands(int[][] grid) {
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        Set<Set<Pair<Integer, Integer>>> islands = new HashSet<>();
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    Set<Pair<Integer, Integer>> currentIsland = new HashSet<>();
//                    this.curRow = i;
//                    this.curCol = j;
//                    dfs (i, j, currentIsland, grid, visited);
//
//                    if (currentIsland.size() > 0) {
//                        islands.add(currentIsland);
//                    }
//                }
//            }
//        }
//        return islands.size();
//    }

//    private void dfs(int row, int col, Set<Pair<Integer, Integer>> currentIsland, int[][] grid, boolean[][] visited) {
//        if (row < 0 || row == grid.length || col < 0 || col == grid[0].length
//                || grid[row][col] == 0 || visited[row][col]) {
//            return;
//        }
//
//        visited[row][col] = true;
//        //store in local cor
//        currentIsland.add(new Pair (row - this.curRow, col - this.curCol));
//
//        dfs(row + 1, col, currentIsland, grid, visited);
//        dfs(row - 1, col, currentIsland, grid, visited);
//        dfs(row, col + 1, currentIsland, grid, visited);
//        dfs(row, col - 1, currentIsland, grid, visited);
//
//    }

//    public static void main(String[] args) {
//        NumDistinctIslands_LE_694 solution = new NumDistinctIslands_LE_694();
//        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
//        System.out.println(solution.numDistinctIslands(grid));
//    }
}
