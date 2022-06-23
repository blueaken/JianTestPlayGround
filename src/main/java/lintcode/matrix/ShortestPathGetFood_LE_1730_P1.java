package lintcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGetFood_LE_1730_P1 {
    /*
        - BFS till reach food cell
        - refactor to make cleaner process steps, ref - https://leetcode.com/problems/shortest-path-to-get-food/discuss/1127459/JAVA-BFS-Clean-Solution
    */
    public int getFood(char[][] grid) {

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int move = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                if(grid[row][col] == '#') return move;
                for (int j = 0; j < 4; j++) {
                    int newRow = row + dx[j];
                    int newCol = col + dy[j];
                    if (newRow < 0 || newRow == grid.length || newCol < 0 || newCol == grid[0].length
                        || grid[newRow][newCol] == 'X' || grid[newRow][newCol] == '*' || visited[newRow][newCol]) {
                        continue;
                    }
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            move++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPathGetFood_LE_1730_P1 solution = new ShortestPathGetFood_LE_1730_P1();
//        char[][] grid = {
//                {'X','X','X','X','X','X'},
//                {'X','*','O','O','O','X'},
//                {'X','O','O','#','O','X'},
//                {'X','X','X','X','X','X'}
//        };
//        //3

        char[][] grid = {
                {'X','X','X','X','X','X','X','X'},
                {'X','*','O','X','O','#','O','X'},
                {'X','O','O','X','O','O','X','X'},
                {'X','O','O','O','O','#','O','X'},
                {'X','X','X','X','X','X','X','X'}
        };
        //6

        System.out.println(solution.getFood(grid));
    }
}
