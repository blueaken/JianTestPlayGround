package ninechapter_system_design.chapter3_ood_design.singleton;

/**
 * Author: blueaken
 * Date: 3/22/16 4:34 AM
 */
public class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution instance = null;

    public static Solution getInstance() {
        // write your code here
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }

    public static void main(String[] args) {
        Solution a = Solution.getInstance();
        Solution b = Solution.getInstance();

        System.out.println(a==b);
    }
}
