package ninechapter_system_design.chapter3_ood_design.singleton;

/**
 * Author: blueaken
 * Date: 3/22/16 4:41 AM
 */
public class Solution_Double_Checked_Null {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution_Double_Checked_Null instance = null;

    public static Solution_Double_Checked_Null getInstance() {
        // write your code here
        if (instance == null) {
            synchronized (Solution_Double_Checked_Null.class) {
                if (instance == null) {
                    instance = new Solution_Double_Checked_Null();
                }
            }
        }
        return instance;
    }
}
