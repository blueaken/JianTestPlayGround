package lintcode.strings;

public class AddBinary_408 {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        String res = "";
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res = String.valueOf(sum % 2) + res;
            carry = sum / 2;
        }
        if (carry > 0) {
            res = "1" + res;
        }

        return res;
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        AddBinary_408 solution = new AddBinary_408();
        System.out.println(solution.addBinary(a, b));
    }
}
