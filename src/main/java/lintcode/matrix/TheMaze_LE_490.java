package lintcode.matrix;

//import javafx.util.Pair;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TheMaze_LE_490 {
    /*
        - bfs, ref https://www.youtube.com/watch?v=UjuD1r72lXM
    */
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//
//        Pair<Integer, Integer> ori = new Pair<>(start[0], start[1]);
//        Set<Pair<Integer, Integer>> visited = new HashSet<>();
//        visited.add(ori);
//        Deque<Pair<Integer, Integer>> queue = new LinkedList<>();
//        queue.offerFirst(ori);
//
//        while (queue.size() > 0) {
//            Pair<Integer, Integer> cur = queue.pollLast();
//            for (int i = 0; i < 4; i++) {
//                Pair<Integer, Integer> newPos = getNewPos(maze, cur, i);
//                if (visited.contains(newPos)) {
//                    continue;
//                }
//
//                int newx = newPos.getKey();
//                int newy = newPos.getValue();
//                if (newx == destination[0] && newy == destination[1]) {
//                    return true;
//                }
//                visited.add(newPos);
//                queue.offerFirst(newPos);
//            }
//        }
//
//        return false;
//    }
//
//    private Pair<Integer, Integer> getNewPos(int[][] maze, Pair<Integer, Integer> cur, int dir) {
//        int curx = cur.getKey();
//        int cury = cur.getValue();
//
//        int[] dx = {0,0,1,-1};
//        int[] dy = {1,-1,0,0};
//
//        int newx = curx + dx[dir];
//        int newy = cury + dy[dir];
//        while (newx >= 0 && newx < maze.length && newy >= 0 && newy < maze[0].length && maze[newx][newy] == 0) {
//            newx += dx[dir];
//            newy += dy[dir];
//        }
//
//        newx -= dx[dir];
//        newy -= dy[dir];
//        return new Pair<Integer, Integer>(newx, newy);
//    }
}
