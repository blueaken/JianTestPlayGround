package lintcode.binarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingProblem_1552 {
    /**
     * @param a: the Parking Record
     * @return: The max number of cars
     */
    //Similar to 919, use minHeap to filter可以重复停的车辆，剩下的就是需要同时时停的数量
    public int getMax(int[][] a) {
        // Write your code here
        if (a == null || a.length == 0 || a[0] == null) {
            return -1;
        }

        Arrays.sort(a, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });

        Queue<Integer> heap = new PriorityQueue<>();
        heap.offer(a[0][1]);
        for (int i = 1; i < a.length; i++) {
            //filter invalid case
            if (a[i][0] >= a[i][1]) {
                continue;
            }

            if (heap.peek() <= a[i][0]) {
                heap.poll();
            }
            heap.offer(a[i][1]);
        }
        return heap.size();
    }

    public static void main(String[] args) {
//        int[][] a = new int [][]{
//                {8, 9},
//                {4, 6},
//                {3, 7},
//                {6, 8}
//        };

        int[][] a = new int [][]{
                {1, 9},
                {2, 8},
                {3, 7},
                {4, 6},
                {5, 5}
        };

        ParkingProblem_1552 solution = new ParkingProblem_1552();
        System.out.println(solution.getMax(a));
    }
}
