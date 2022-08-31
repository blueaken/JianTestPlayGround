package lintcode.design;

import java.util.PriorityQueue;

public class SequentiallyOrdinalRankTracker_LE_2102 {
    /*
        - similar to 295. Find Median from Data Stream, use 2 heaps to avoid repeat sorting and hit time perf

        - We define 2 heaps - large (min heap) and small (max heap).
        - The large heap is always of the size 'rank'. The 'rank' is the number of times 'get' has been invoked.

        - On each 'add' call, we add the item into large heap, if the size of large heap is greater than 'rank', we pop the large heap's top to the small heap.



        - On each 'get' call, rank increases by 1, and we return the top max heap item. At the same time, we add this max heap top item to the min heap, since it has been used.

        - Time of both 'get' and 'add' is O(logN)
    */

    class SOR {
        String name;
        int score;

        SOR (String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    PriorityQueue<SOR> large;
    PriorityQueue<SOR> small;
    int rank;

    public SequentiallyOrdinalRankTracker_LE_2102() {
        small = new PriorityQueue<SOR>((a, b) -> {
            int diff = b.score - a.score;
            if (diff == 0) {
                return a.name.compareTo(b.name);
            } else {
                return diff;
            }
        });

        large = new PriorityQueue<SOR>((a, b) -> {
            int diff = a.score - b.score;
            if (diff == 0) {
                return b.name.compareTo(a.name);
            } else {
                return diff;
            }
        });

        rank = 0;
    }

    public void add(String name, int score) {
        SOR cur = new SOR(name, score);
        large.offer(cur);
        if (large.size() > rank) {
            small.offer(large.poll());
        }
    }

    public String get() {
        //get the ith best from small
        large.offer(small.poll());
        //incr rank now so large can hold more for every get call
        rank++;
        return large.peek().name;
    }

    /* dry run -
        rk     0        1         2         3           4       5        6
        lg
               bra3    bra3      bra3      bra3       bra3
                                 alps2     alps2      orl3
                                           bra2       alps2
        sm
               bra2    alps2     bra2      orl2       bra2
                       bra2      orl2                 orl2

        get   bra3               alps2     bra2
    */


    public static void main(String[] args) {
        SequentiallyOrdinalRankTracker_LE_2102 solution = new SequentiallyOrdinalRankTracker_LE_2102();
        solution.add("bradford", 2);
        solution.add("branford", 3);
        System.out.println(solution.get()); // The sorted locations, from best to worst, are: branford, bradford.
        solution.add("alps", 2);
        System.out.println(solution.get());              // Sorted locations: branford, alps, bradford.
        // Note that alps precedes bradford even though they have the same score (2).
        // This is because "alps" is lexicographically smaller than "bradford".
        // Return the 2nd best location "alps", as it is the 2nd time get() is called.
        solution.add("orland", 2);
        System.out.println(solution.get());              // Sorted locations: branford, alps, bradford, orland.
        // Return "bradford", as it is the 3rd time get() is called.
        solution.add("orlando", 3);
        System.out.println(solution.get());              // Sorted locations: branford, orlando, alps, bradford, orland.
        // Return "bradford", as the 4th time rank
        solution.add("alpine", 2);
        System.out.println(solution.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        // Return "bradford", as the 5th time rank
        System.out.println(solution.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        // Return "orland", as the 6th time rank
    }
}
