package lintcode.string;

public class ReorganizeString_LE_767_P2 {
    /*
      ref discussion -
        1. count letter appearance and store in hash[i]
        2. find the letter with largest occurrence.
        3. put the letter into even index number (0, 2, 4 ...) char array
        4. put the rest into the array (need to handle duplicate maxcount case, so use hash[i], instead of HashMap)

      Time - O(N)
      ====================
      P2 11.01.2022
      ====================
    */
    public String reorganizeString(String s) {
        int n = s.length();

        //count letter appearance and store in hash[i]
        int[] hash = new int[26];
        for (int i = 0; i < n; i++) {
            int letter = s.charAt(i) - 'a';
            hash[letter]++;
        }

        //find the letter with largest occurrence.
        int maxCount = 0, letter = -1;
        for (int i = 0; i < 26; i++) {
            if (hash[i] > maxCount) {
                maxCount = hash[i];
                letter = i;
            }
        }
        if (2 * maxCount > n + 1) {
            return "";
        }

        //put the letter into even index number (0, 2, 4 ...) char array
        char[] res = new char[n];
        int idx = 0;
        while (hash[letter] > 0) {
            char maxL = (char)(letter + 'a');
            res[idx] = maxL;
            hash[letter]--;
            idx += 2;
        }

        //put the rest into the array (need to handle duplicate maxcount case, so use hash[i], instead of HashMap)
        for (int i = 0; i < 26; i++) {
            char curL = (char)(i + 'a');
            while (hash[i] > 0) {
                if (idx >= n) {
                    idx = 1;
                }
                res[idx] = curL;
                hash[i]--;
                idx += 2;
            }
        }
        return String.valueOf(res);
    }
}
