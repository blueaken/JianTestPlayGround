package ninechapter_algorithm.chapter9_graphic.optional.numberofislands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: blueaken
 * Date: 6/17/16 00:03
 */
public class Solution_BFS {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        int count = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void removeIsland(boolean[][]grid, int i, int j) {
        int[]dx = {1, -1, 0, 0};
        int[]dy = {0, 0, 1, -1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, j));
        while (queue.size() > 0) {
            Node cur = queue.poll();
            grid[cur.x][cur.y] = false;
            for (int m = 0; m < dx.length; m++) {
                int x = cur.x + dx[m];
                int y = cur.y + dy[m];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                        && grid[x][y]) {
                    queue.offer(new Node(x, y));
                }
            }
        }
        return;
    }
}

class Node {
    int x;
    int y;
    Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
