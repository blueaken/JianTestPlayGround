package lintcode.math;

public class AngleBetweenHandsOfAClock_LE_1344 {
    public double angleClock(int hour, int minutes) {
        int oneMin = 6;
        int oneHour = 30;

        double minHand = (double)minutes * oneMin;
        double hourHand = (hour % 12 + minutes / 60.0) * oneHour;

        double diff = Math.abs(hourHand - minHand);
        return  Math.min(diff, 360 - diff);
    }
}
