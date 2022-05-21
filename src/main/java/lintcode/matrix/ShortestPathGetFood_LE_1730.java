package lintcode.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathGetFood_LE_1730 {
    /*
        - BFS till reach food cell
    */
    public int getFood(char[][] grid) {
        //find the start point
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new Point(i,j));
                    break;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 0;
        boolean found = false;
        while (!found && queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newrow = cur.x + dx[j];
                    int newcol = cur.y + dy[j];
                    if (newrow >=0 && newrow < grid.length && newcol >= 0 && newcol < grid[0].length
                            && grid[newrow][newcol] != 'X' && grid[newrow][newcol] != '*') {
                        //check if new position is food cell
                        if (grid[newrow][newcol] == '#') {
                            found = true;
                            break;
                        }
                        //mark visited position
                        grid[newrow][newcol] = 'X';
                        //explore neighbors
                        queue.offer(new Point(newrow, newcol));
                    }
                }
            }
            count++;
        }

        return found ? count : -1;
    }

    class Point {
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ShortestPathGetFood_LE_1730 solution = new ShortestPathGetFood_LE_1730();
//        char[][] grid = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
//        //3

        char[][] grid = {{'X','X','X','X','X','X','X','X'},
                        {'X','*','O','X','O','#','O','X'},
                        {'X','O','O','X','O','O','X','X'},
                        {'X','O','O','O','O','#','O','X'},
                        {'X','X','X','X','X','X','X','X'}};
        //6

        System.out.println(solution.getFood(grid));
    }
}
