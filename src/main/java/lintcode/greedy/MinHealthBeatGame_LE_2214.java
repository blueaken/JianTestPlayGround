package lintcode.greedy;

public class MinHealthBeatGame_LE_2214 {
    public long minimumHealth(int[] damage, int armor) {

        //add all the damages
        long health = 1;
        long max = 0;
        for (int i = 0; i < damage.length; i++) {
            health += damage[i];
            max = Math.max(max, damage[i]);
        }

        //armor need to use at the max damage level for best result
        health -= Math.min(max, armor);

        return health;
    }
}
