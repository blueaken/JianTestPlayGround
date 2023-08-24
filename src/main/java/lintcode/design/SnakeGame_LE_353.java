package lintcode.design;

//import javafx.util.Pair;

import java.util.*;

public class SnakeGame_LE_353 {

    /*
        8.13.222
        - the advantage using javafx.util.Pair class is there is no need to override equals() for the hashmap, as far as the key and value equals then 2 Pair object is default equal.
        =============
        8.24.23
        =============
     */
    int m, n;
    LinkedList<Integer> body;
    Set<Integer> bodySet;
    LinkedList<Integer> food;
    boolean isAlive;

    public SnakeGame_LE_353(int width, int height, int[][] food) {
        this.m = height;
        this.n = width;
        this.body = new LinkedList<>();
        this.bodySet = new HashSet<>();
        this.food = new LinkedList<>();
        this.isAlive = true;

        this.body.addLast(encode(0, 0));
        this.bodySet.add(encode(0, 0));
        for (int[] f : food) {
            this.food.addLast(encode(f[0], f[1]));
        }
    }

    int encode(int x, int y) {
        return x * n + y;
    }

    public int move(String direction) {
        if (!isAlive) {
            return -1;
        }

        int head = body.getFirst();
        int row = head / n, col = head % n;

        switch(direction) {
            case "U":
                row--;
                break;
            case "D":
                row++;
                break;
            case "L":
                col--;
                break;
            case "R":
                col++;
                break;
        }

        // if hit wall
        if (row < 0 || row == m || col < 0 || col == n) {
            isAlive = false;
            return -1;
        }

        int newPos = encode(row, col);

        // move one step
        body.addFirst(newPos);
        if (food.size() > 0 && newPos == food.getFirst()) {
            // eat a food and keep the tail
            food.removeFirst();
        } else {
            // remove the tail
            int tail = body.removeLast();
            bodySet.remove(tail);
        }

        // if bite itself
        if (bodySet.contains(newPos)) {
            isAlive = false;
            return -1;
        }

        bodySet.add(newPos);

        // score is the length of body
        return body.size() - 1;
    }

    public static void main(String[] args) {
        int width = 3;
        int height = 2;
        int[][] food = {{1,2},{0,1}};
        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
        System.out.println(solution.move("R"));//0
        System.out.println(solution.move("D"));//0
        System.out.println(solution.move("R"));//1
        System.out.println(solution.move("U"));//1
        System.out.println(solution.move("L"));//2
        System.out.println(solution.move("U"));//-1

//        int width = 2;
//        int height = 2;
//        int[][] food = {{0,1}};
//        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
//        System.out.println(solution.move("R"));//1
//        System.out.println(solution.move("D"));//0, food array used out case


//        int width = 3;
//        int height = 3;
//        int[][] food = {{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}};
//        SnakeGame_LE_353 solution = new SnakeGame_LE_353(width, height, food);//null
//        System.out.println(solution.move("R"));//1
//        System.out.println(solution.move("R"));//2
//        System.out.println(solution.move("D"));//3
//        System.out.println(solution.move("D"));//4
//        System.out.println(solution.move("L"));//5
//
//        System.out.println(solution.move("L"));//6
//        System.out.println(solution.move("U"));//7, new head is previous tail case
//        System.out.println(solution.move("U"));//7
//        System.out.println(solution.move("R"));//7
//        System.out.println(solution.move("R"));//7
//
//        System.out.println(solution.move("D"));//7
//        System.out.println(solution.move("D"));//7
//        System.out.println(solution.move("L"));//7
//        System.out.println(solution.move("L"));//7
//        System.out.println(solution.move("U"));//7
//
//        System.out.println(solution.move("R"));//7
//        System.out.println(solution.move("U"));//7
//        System.out.println(solution.move("L"));//7
//        System.out.println(solution.move("D"));//-1

    }
}
