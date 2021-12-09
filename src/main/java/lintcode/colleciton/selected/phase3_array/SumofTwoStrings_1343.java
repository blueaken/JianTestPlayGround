package lintcode.colleciton.selected.phase3_array;

public class SumofTwoStrings_1343 {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return the sum of two strings
     */
    public String SumofTwoStrings(String A, String B) {
        // write your code here
        int posA = A.length() - 1;
        int posB = B.length() - 1;

        String result = "";
        while (posA >= 0 && posB >= 0) {
            int temp = (A.charAt(posA--) - '0') + (B.charAt(posB--) - '0');
            result = temp + result;
        }

        if (posA >= 0) {
            result = A.substring(0, posA + 1) + result;
        }

        if (posB >= 0) {
            result = B.substring(0, posB + 1) + result;
        }

        return result;
    }
}
