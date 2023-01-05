package lintcode.heap.labuladong;

import java.util.PriorityQueue;

public class SeatReservationManager_LE_1845 {
    /**
     1.5.2023
     - try with PriorityQueue solution
     */

    PriorityQueue<Integer> heap = new PriorityQueue<>();

    public SeatReservationManager_LE_1845(int n) {
        for (int i = 1; i <= n; i++) {
            heap.offer(i);
        }
    }

    public int reserve() {
        return heap.poll();
    }

    public void unreserve(int seatNumber) {
        heap.offer(seatNumber);
    }
}
