package lintcode.stack;

import java.util.Stack;

public class MockHanoiTower_227 {
    private Stack<Integer> disks;
    /*
     * @param i: An integer from 0 to 2
     */
    public MockHanoiTower_227(int i) {
        // create three towers
        disks = new Stack<>();
    }

    /*
     * @param d: An integer
     * @return: nothing
     */
    public void add(int d) {
        // Add a disk into this tower
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }
    }

    /*
     * @param t: a tower
     * @return: nothing
     */
    public void moveTopTo(MockHanoiTower_227 t) {
        // Move the top disk of this tower to the top of t.
        t.add(disks.pop());
    }

    /*
     * @param n: An integer
     * @param destination: a tower
     * @param buffer: a tower
     * @return: nothing
     */
    // Ref - https://www.youtube.com/watch?v=YstLjLCGmgg
    public void moveDisks(int n, MockHanoiTower_227 destination, MockHanoiTower_227 buffer) {
        // Move n Disks from this tower to destination by buffer tower
        if (n > 0) {
            moveDisks(n - 1, buffer, destination); //// 以目标杆为中介，从起始杆将1至n-1号盘移至中间杆
            moveTopTo(destination); //将起始杆里的第n号盘移动到目标杆
            buffer.moveDisks(n - 1, destination, this); //以起始杆为中介，从中间杆将1至n-1号盘移至目标杆
        }
    }

    /*
     * @return: Disks
     */
    public Stack<Integer> getDisks() {
        // write your code here
        return disks;
    }

    public static void main(String[] args) {
        /**
         * Your Tower object will be instantiated and called as such:
         */
        int n = 3;
        MockHanoiTower_227[] towers = new MockHanoiTower_227[3];
        for (int i = 0; i < 3; i++) {
         towers[i] = new MockHanoiTower_227(i);
        }
        for (int i = n - 1; i >= 0; i--) {
         towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);
        for (int i = 0; i < 3; i++) {
            System.out.println("Tower" + i + ": " + towers[i].getDisks().toString());
        }
    }
}
