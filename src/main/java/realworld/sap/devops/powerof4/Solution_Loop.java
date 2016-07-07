package realworld.sap.devops.powerof4;

/**
 * Author: blueaken
 * Date: 7/7/16 09:45
 */
public class Solution_Loop {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        while (num != 1) {
            if (num % 4 != 0) {
                return false;
            } else {
                num /= 4;
            }
        }
        return true;
    }
}
