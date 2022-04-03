package lintcode.dynamicprogramming2;

public class DropEgg2_584 {
    /**
     * @param eggs: the number of eggs
     * @param floors: the number of floors
     * @return: the number of drops in the worst case
     */
    // Ref - https://www.youtube.com/watch?v=3hcaVyX00_4
    public int dropEggs2(int eggs, int floors) {
        // write your code here
        int[][] res = new int[eggs+1][floors+1];
        for (int i = 1; i <= floors; i++) {
            res[1][i] = i;
        }
        int cur;

        //dp
        for (int i = 2; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                res[i][j] = Integer.MAX_VALUE;
                if (i > j) {
                    //when eggs more than floors
                    res[i][j] = res[i-1][j];
                } else {
                    for(int k = 1; k <= j ; k++){
                        cur = 1 + Math.max(res[i-1][k-1], res[i][j-k]);
                        res[i][j] = Math.min(res[i][j], cur);
                    }
                }
            }
        }
        return res[eggs][floors];
    }

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 6;
        DropEgg2_584 solution = new DropEgg2_584();
        System.out.println(solution.dropEggs2(eggs, floors));
    }
}
