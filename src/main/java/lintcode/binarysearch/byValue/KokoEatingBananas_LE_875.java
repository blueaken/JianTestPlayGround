package lintcode.binarysearch.byValue;

public class KokoEatingBananas_LE_875 {
    /**
     12.09.2022
     ref 东哥 post
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000001;
        // //we are looking for min k, so search for left bound of the binary search
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

    //f(x) - when speed is x per hour, the total hours needed to finish the piles
    int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        //note hours may overflow
        return hours;
    }
}
