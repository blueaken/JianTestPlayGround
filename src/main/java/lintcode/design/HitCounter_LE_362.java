package lintcode.design;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter_LE_362 {
    /*
        ref the solution link of Deque, for Time of both hit() and getHits() to achieve O(1)
    */

    Deque<Pair<Integer, Integer>> hit;
    int total;

    public HitCounter_LE_362() {
        this.hit = new ArrayDeque<>();
        int total = 0;
    }

    public void hit(int timestamp) {
        if (this.hit.isEmpty() || this.hit.getLast().getKey() != timestamp) {
            hit.addFirst(new Pair<>(timestamp, 1));
        } else {
            int preVal = this.hit.getLast().getValue();
            this.hit.removeLast();
            this.hit.addFirst(new Pair<>(timestamp, preVal + 1));
        }
        total++;
    }

    public int getHits(int timestamp) {
        while (!this.hit.isEmpty()) {
            int diff = timestamp - this.hit.getLast().getKey();
            if (diff >= 300) {
                this.total -= this.hit.getLast().getValue();
                this.hit.removeLast();
            } else {
                break;
            }
        }
        return this.total;
    }

    public static void main(String[] args) {
        HitCounter_LE_362 solution = new HitCounter_LE_362();
        solution.hit(1);
        solution.hit(2);
        solution.hit(3);
        System.out.println(solution.getHits(4));
        solution.hit(300);
        System.out.println(solution.getHits(300));
        System.out.println(solution.getHits(301));
    }
}
