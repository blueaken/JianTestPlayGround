package lintcode.matrix;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TheMaze2_LE_505 {
    /*
        - modified from 490 solution, can be further refactored, such as no need use Pair class, since we do not use set as
          visited container, instead using a distance 2D array directly. Since even if a cell is visited before, as far as cur
          distance is shorter than previous one, it can also be visited again.
        - refer to solution link
        - further read can be made on the Dijkstra Algorithm for interest, although Dijkstra is very unlikely asked in Amazon interview.
    */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        Pair<Integer, Integer> ori = new Pair<>(start[0], start[1]);
        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offerFirst(ori);

        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        //bfs
        while (queue.size() > 0) {
            Pair<Integer, Integer> cur = queue.pollLast();
            for (int i = 0; i < 4; i++) {
                int[] newPos = getNewPos(maze, cur, i);
                int newx = newPos[0];
                int newy = newPos[1];
                int dis = newPos[2];
                Pair<Integer, Integer> pos = new Pair<>(newx, newy);
                int curDis = distance[cur.getKey()][cur.getValue()] + dis;
                if (curDis < distance[newx][newy]) {
                    distance[newx][newy] = curDis;
                    queue.offerFirst(pos);
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private int[] getNewPos(int[][] maze, Pair<Integer, Integer> cur, int dir) {
        int curx = cur.getKey();
        int cury = cur.getValue();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int newx = curx + dirs[dir][0];
        int newy = cury + dirs[dir][1];
        int dis = 0;
        while (newx >= 0 && newx < maze.length && newy >= 0 && newy < maze[0].length
                && maze[newx][newy] == 0) {
            newx += dirs[dir][0];
            newy += dirs[dir][1];
            dis++;
        }
        newx -= dirs[dir][0];
        newy -= dirs[dir][1];

        return new int[]{newx, newy, dis};
    }
}
