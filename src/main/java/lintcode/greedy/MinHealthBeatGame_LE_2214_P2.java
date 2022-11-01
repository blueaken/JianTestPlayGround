package lintcode.greedy;

public class MinHealthBeatGame_LE_2214_P2 {
    /*
        P2 11.01.2022
    */
    public long minimumHealth(int[] damage, int armor) {
        int n = damage.length;
        long ans = 1;
        int maxD = 0;
        for (int i = 0; i < n; i++) {
            maxD = Math.max(maxD, damage[i]);
            ans += damage[i];
        }

        //armor should be used in the max damage level
        ans -= Math.min(maxD, armor);

        return ans;
    }
}
