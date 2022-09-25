package lintcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

import javafx.util.Pair;

public class HitCounter_LE_362_P1 {
    /*
        P1
        - a queue helps in this problem
        - use a Pair object to keep the counter of each timestamp, to achieve O(1) on both hit & gethits
    */

    Deque<Pair<Integer, Integer>> counter; //Pair<timestamp, count>
    int total;
    public HitCounter_LE_362_P1() {
        this.counter = new ArrayDeque<>();
        this.total = 0;
    }

    public void hit(int timestamp) {
        if (this.counter.isEmpty() || this.counter.peekLast().getKey() != timestamp) {
            Pair<Integer, Integer> p = new Pair<>(timestamp, 1);
            this.counter.addFirst(p);
        } else {
            int newVal = this.counter.pollLast().getValue() + 1;
            Pair<Integer, Integer> p = new Pair<>(timestamp, newVal);
            this.counter.addFirst(p);
        }
        total++;
    }

    public int getHits(int timestamp) {
        while (!this.counter.isEmpty()) {
            int diff = timestamp - this.counter.peekLast().getKey();
            if (diff >= 300) {
                Pair<Integer, Integer> p = this.counter.pollLast();
                this.total -= p.getValue();
            } else {
                break;
            }
        }
        return this.total;
    }
}
