package lintcode.string;

public class IntToEnglish_LE_273 {
    /*
        - follow hint and ref the previous MS onsite solution, build less than 1000 number string first, then loop each 1000 units, thousands -> million -> billion, so on and so forth
        - many side cases to consider, error prone
        - Time is O(N), N - number of digits
    */

    private static String[] ONES = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static String[] SPECIALS_1 = {"Hundred"};
    private static String[] SPECIALS_2 = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String prefix = "";
        if (num < 0) {
            prefix = "Negative";
            num = -num;
        }

        String current = "";
        int count = 0; //0 - 4
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int temp = num % 1000;
            if (temp > 0) {
                sb.insert(0, " ");
                sb.insert(0, SPECIALS_2[count]);
                sb.insert(0, " ");
                sb.insert(0, convertLessThanOneThousand(temp));
            }
            num /= 1000;
            count++;
        }
        current = sb.toString();

        return (prefix + " " + current).trim();
    }

    private String convertLessThanOneThousand(int num) {
        int hun = (num % 1000) / 100;
        int ten = (num % 100) / 10;
        StringBuilder sb = new StringBuilder();

        if (hun > 0) {
            sb.append(ONES[hun]);
            sb.append(" ");
            sb.append(SPECIALS_1[0]);
            sb.append(" ");
            num -= hun * 100;
        }
        if (ten >= 2) {
            sb.append(TENS[ten]);
            sb.append(" ");
            num -= ten * 10;
        }
        if (num > 0) {
            sb.append(ONES[num]);
        } else {//remove extra tailing space
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToEnglish_LE_273 solution = new IntToEnglish_LE_273();
//        int num = 67345689; //Sixty Seven Million Three Hundred Forty Five Thousand Six Hundred Eighty Nine
        int num = 500868;

        System.out.println(solution.numberToWords(num));
    }
}
