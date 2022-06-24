package lintcode.prefixsum;

public class MinHealthBeatGame_LE_2214_P1 {
    public long minimumHealth(int[] damage, int armor) {
        long health = 1L, max = 0;
        for (int i = 0; i < damage.length; i++) {
            health += damage[i];
            max = Math.max(max, damage[i]);
        }

        //armor should be used in the max damage level
        health -= Math.min(max, armor);
        return health;
    }

    public static void main(String[] args) {
        MinHealthBeatGame_LE_2214_P1 solution = new MinHealthBeatGame_LE_2214_P1();
        int[] damage = {2, 7, 4, 3};
        int armor = 4;
        //13

        System.out.println(solution.minimumHealth(damage, armor));
    }
}
