package lintcode.colleciton.selected.phase3_and_phase4_array;

public class ATOI_54 {
    /**
     * @param s: A string
     * @return: An integer
     */
    public static int atoi(String s) {
        // write your code here
        if (s == null) return 0;

        s = s.trim();
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;

        int curPos = 0;
        boolean isNeg = false;
        if (arr[0] == '+') {
            curPos = 1;
        }
        if (arr[0] == '-') {
            curPos = 1;
            isNeg = true;
        }

        Long value = 0L;
        for (int i = curPos; i < arr.length; i++) {
            if (arr[i] > '9' || arr[i] < '0') {
                break;
            }
            value = value * 10 + (arr[i] - '0');
            if (value > Integer.MAX_VALUE) {
                break;
            }
        }

        if (isNeg) {
            value = -1 * value;
        }

        if (value > Integer.MAX_VALUE) {
            value = Long.valueOf(Integer.MAX_VALUE);
        }
        if (value < Integer.MIN_VALUE) {
            value = Long.valueOf(Integer.MIN_VALUE);
        }

        return value.intValue();
    }

    public static void main(String[] args) {
//        String input = "-234";
        String input = "1.0";
        System.out.println(atoi(input));
    }
}
