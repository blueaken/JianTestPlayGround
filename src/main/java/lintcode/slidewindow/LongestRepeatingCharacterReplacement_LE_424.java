package lintcode.slidewindow;

public class LongestRepeatingCharacterReplacement_LE_424 {
    /**
     12.05.2022
     similar to 1004, the diff is need to count all 26 chars' case
     solve by 东哥 sliding window template
     */
    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0, right = 0;
        int[] windowCharLen = new int[26];
        // 记录窗口中字符的最多重复次数。记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
        int windowMaxCharLen = 0;

        while (right < s.length()) {
            int r = s.charAt(right) - 'A';
            right++;

            windowCharLen[r]++;
            windowMaxCharLen = Math.max(windowMaxCharLen, windowCharLen[r]);

            while (right - left - windowMaxCharLen > k) {
                int l = s.charAt(left) - 'A';
                left++;

                windowCharLen[l]--;
                // 这里不用更新 windowMaxCharLen, 因为只有 windowMaxCount 变得更大的时候才可能获得更长的重复子串，才会更新res
                // Huifeng Guan's comment: 因为我们移动左指针的起因是新字符s[j]的引入，它必然是一个非majority的字符（否则整个窗口应该会继续保持合法），而无论左指针弹出的是否majority元素，都不会得到更好的结果，最多持平，所以我们不需要更新结果。
            }

            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement_LE_424 solution = new LongestRepeatingCharacterReplacement_LE_424();
//        System.out.println(solution.characterReplacement("AABABBA", 1));
        System.out.println(solution.characterReplacement("AABABBA", 2));
    }
}
