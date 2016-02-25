package type;

/**
 * Author: blueaken
 * Date: 2/25/16 9:07 AM
 */
public class VersionControl {
    public static boolean isBadVersion(int n){
        if (n >= 0 && n < 10) {
            return false;
        }
        return true;
    }
}
