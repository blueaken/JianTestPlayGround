package lintcode.string;

public class SlowestKey_LE_1629 {
    /*
        - 一开始题意理解错了，不需要把每个同样note的duration加起来，只需要一段段比较
    */
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int l = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int t = releaseTimes[i] - releaseTimes[i - 1];
            char cur = keysPressed.charAt(i);
            if (t > l) {
                ans = cur;
                l = t;
            } else if (t == l) {
                if ((cur - 'a') > (ans - 'a')) {
                    ans = cur;
                }
            }
        }
        return ans;
    }
}
