package lintcode.greedy;

public class FindTheCelebrity_LE_277 {
    /*
        - ref https://www.youtube.com/watch?v=QDehNYXlCAg&t=4s
        - Brute Force - O(N^2), to tell if a is celebrity,
          need 2 conditions for every other people b: !know(a, b) && know(b, a)
        - Optimize, each round drop 1, after n - 1 comparion, only 1 candidate left
        ========================
        P1 11.02.2022
        type - greedy
        ========================
    */
    public int findCelebrity(int n) {
        //find a candidate by one pass (make sure other people not celebrity)
        int can = 0;
//        for (int others = 1; others < n; others++) {
//            if (knows(can, others)) {
//                can = others;
//            }
//        }
//
//        //check previous relationship which maybe dropped in earlier comparation
//        for (int others = 0; others < n; others++) {
//            if (can == others) {
//                continue;
//            }
//
//            if (knows(can, others) || !knows(others, can)) {
//                return -1;
//            }
//        }
        return can;
    }
}
