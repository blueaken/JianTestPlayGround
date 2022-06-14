package lintcode.math;

public class RectangleOverlap_LE_836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //if rec1's right border <= rec2's left border and vice verse
        if (rec1[2] <= rec2[0] || rec2[2] <= rec1[0]) {
            return false;
        }

        //if rec1's upper border <= rec2's bottom border and vice verse
        if (rec1[3] <= rec2[1] || rec2[3] <= rec1[1]) {
            return false;
        }

        return true;
    }
}
