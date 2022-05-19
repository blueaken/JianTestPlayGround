package lintcode.string;

public class ReorganizeString_LE_767 {
    /*
      ref discussion -
        1. count letter appearance and store in hash[i]
        2. find the letter with largest occurence.
        3. put the letter into even index numbe (0, 2, 4 ...) char array
        4. put the rest into the array (need to handle duplicate maxcount case, so use hash[i], instead of HashMap)

      Time - O(N)
    */
    public String reorganizeString(String s) {
        // count letter appearance and find the letter with largest occurence.
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            hash[idx]++;
        }

        //find the letter with largest occurence.
        int maxCount = 0, letter = -1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > maxCount) {
                maxCount = hash[i];
                letter = i;
            }
        }
        if (maxCount * 2 > s.length() + 1) {
            return "";
        }

        //put the letter into even index numbe (0, 2, 4 ...) char array
        char[] res = new char[s.length()];
        int idx = 0;
        while (idx <= 2 * (maxCount - 1)) {
            res[idx] = (char)(letter + 'a');
            hash[letter]--;
            idx += 2;
        }

        //put the rest into the array (need to handle duplicate maxcount case, so use hash[i], instead of HashMap)
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= s.length()) {
                    idx = 1;
                }
                res[idx] = (char)(i + 'a');
                hash[i]--;
                idx += 2;
            }
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        ReorganizeString_LE_767 solution = new ReorganizeString_LE_767();
//        String s = "aab";//aba
//        String s = "aaab";//""
//        String s = "aabb";//abab
//        String s = "baaba";//ababa
        String s = "eqmeyggvp"; //epeqgvgym, duplicate maxCount case
        System.out.println(solution.reorganizeString(s));
    }
}
