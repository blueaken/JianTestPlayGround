package lintcode.math;

public class MultiplyStrings_LE_43 {
    /**
     1.23.2023
     ref 东哥 post
     */
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int mul = a * b;
                int p1 = i+j;
                int p2 = i+j+1;

                // note need count res[p1] as well
                int sum = mul + res[p2] + 10 * res[p1];
                res[p1] = sum /10;
                res[p2] = sum % 10;
            }
        }

        // remove heading zeros
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (i < res.length) {
            sb.append(res[i]);
            i++;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
