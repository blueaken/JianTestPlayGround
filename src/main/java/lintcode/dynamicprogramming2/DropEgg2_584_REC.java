package lintcode.dynamicprogramming2;

public class DropEgg2_584_REC {
    /**
     * @param eggs: the number of eggs
     * @param floors: the number of floors
     * @return: the number of drops in the worst case
     */
    // Ref - https://www.youtube.com/watch?v=3hcaVyX00_4
    public int dropEggs2(int eggs, int floors) {
        // write your code here
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {
            //cur solutions equals - 1 + Max of (egg breaks case - get the eggs-1, floors-1 value AND egg not breaks - get the egg, floors - i value)
            int cur = 1 + Math.max(dropEggs2(eggs-1, i-1), dropEggs2(eggs, floors - i));
            min = Math.min(min, cur);
        }

        return min;
    }

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 6;
        DropEgg2_584_REC solution = new DropEgg2_584_REC();
        System.out.println(solution.dropEggs2(eggs, floors));
    }
}
