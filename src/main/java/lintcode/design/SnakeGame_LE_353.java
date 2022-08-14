package lintcode.design;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SnakeGame_LE_353 {
    int width;
    int height;
    int score;
    int[][] food;
    int foodIdx;
    Map<Pair<Integer, Integer>, Boolean> map;
    Deque<Pair<Integer, Integer>> snake;

    /*
        - the advantage using javafx.util.Pair class is there is no need to override equals() for the hashmap,
        as far as the key and value equals then 2 Pair object is default equal.
     */
    public SnakeGame_LE_353
            (int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.score = 0;
        this.food = food;
        this.foodIdx = 0;

        this.snake = new ArrayDeque<>();
        //init at position (0,0)
        Pair ori = new Pair<>(0, 0);
        snake.offerFirst(ori);
        this.map = new HashMap<>();
        map.put(ori, true);
    }

    public int move(String direction) {
        Pair<Integer, Integer> head = snake.peekFirst();
        int newrow = head.getKey();
        int newcol = head.getValue();

        //calc the new head position
        if (direction.equals("U")) {
            newrow--;
        }
        if (direction.equals("D")) {
            newrow++;
        }
        if (direction.equals("L")) {
            newcol--;
        }
        if (direction.equals("R")) {
            newcol++;
        }

        //if cross boundary
        if (newrow < 0 || newrow == this.height || newcol < 0 || newcol == this.width) {
            return -1;
        }
        //if bite self
        Pair<Integer, Integer> newHead = new Pair<Integer, Integer>(newrow, newcol);
        Pair<Integer, Integer> tail = snake.peekLast();
        int tailrow = tail.getKey();
        int tailcol = tail.getValue();
        if (map.containsKey(newHead) && !(newrow == tailrow && newcol == tailcol)) {
            //new head hit current tail pos is OK since the tail pos is going to update while move
            return -1;
        }

        //start move process
        //1 - if move hit food
        if (foodIdx < food.length && newrow == food[foodIdx][0] && newcol == food[foodIdx][1]) {
            snake.offerFirst(newHead);
            map.put(newHead, true);
            this.score++;
            this.foodIdx++;
        } else {
            //2 - move without food
            snake.offerFirst(newHead);
            snake.pollLast();
            map.remove(tail); //note: need to remove tail first in map in case the new head is the tail
            map.put(newHead, true);
        }

        return this.score;
    }

    public static void main(String[] args) {
//        int width = 3;
//        int height = 2;
//        int[][] food = {{1,2},{0,1}};
//        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
//        System.out.println(solution.move("R"));//0
//        System.out.println(solution.move("D"));//0
//        System.out.println(solution.move("R"));//1
//        System.out.println(solution.move("U"));//1
//        System.out.println(solution.move("L"));//2
//        System.out.println(solution.move("U"));//-1

//        int width = 2;
//        int height = 2;
//        int[][] food = {{0,1}};
//        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
//        System.out.println(solution.move("R"));//1
//        System.out.println(solution.move("D"));//0, food array used out case


        int width = 3;
        int height = 3;
        int[][] food = {{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}};
        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
        System.out.println(solution.move("R"));//1
        System.out.println(solution.move("R"));//2
        System.out.println(solution.move("D"));//3
        System.out.println(solution.move("D"));//4
        System.out.println(solution.move("L"));//5

        System.out.println(solution.move("L"));//6
        System.out.println(solution.move("U"));//7, new head is previous tail case
        System.out.println(solution.move("U"));//7
        System.out.println(solution.move("R"));//7
        System.out.println(solution.move("R"));//7

        System.out.println(solution.move("D"));//7
        System.out.println(solution.move("D"));//7
        System.out.println(solution.move("L"));//7
        System.out.println(solution.move("L"));//7
        System.out.println(solution.move("U"));//7

        System.out.println(solution.move("R"));//7
        System.out.println(solution.move("U"));//7
        System.out.println(solution.move("L"));//7
        System.out.println(solution.move("D"));//-1

    }
}
