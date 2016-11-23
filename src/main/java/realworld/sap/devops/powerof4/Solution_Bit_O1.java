package realworld.sap.devops.powerof4;

/**
 * Author: blueaken
 * Date: 7/7/16 09:49
 */
public class Solution_Bit_O1 {
    public boolean isPowerOfFour(int num) {
        //(num & (num - 1)) == 0 - tell if power of 2
        //(num & 0x55555555) != 0 - filter 1 on the odd positions
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
