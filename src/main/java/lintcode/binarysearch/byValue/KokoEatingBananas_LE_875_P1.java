package lintcode.binarysearch.byValue;

public class KokoEatingBananas_LE_875_P1 {
    /**
     12.09.2022
     ref 东哥 post
     ===============
     3.19.2023
     P1
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 在每小时吃k个香蕉的速度下，吃完所有piles所需要的时间
    private int f(int[] piles, int k) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            int cur = piles[i];
            hours += cur / k;
            if (cur % k > 0) {
                hours++;
            }
        }
        return hours;
    }
}
