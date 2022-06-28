package lintcode.string;

public class IntToEnglish_LE_273_P1 {
    /*
        - follow hint and ref the previous MS onsite solution, build less than 1000 number string first, then loop each 1000 units, thousands -> million -> billion, so on and so forth
        - many side cases to consider, error prone
        - Time is O(N), N - number of digits
    */
    String[] Special = {"", "Thousand", "Million", "Billion", "Trillion"};
    String[] Special_1 = {"Hundred"};
    String[] Ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String prefix = "";
        if (num < 0) {
            prefix = "Negative";
            num = - num;
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (num > 0) {
            int temp = num % 1000;
            if (temp > 0) {
                sb.insert(0, " ");
                sb.insert(0, Special[count]);
                sb.insert(0, " ");
                sb.insert(0, convertLessThan1000(temp));
            }
            num /= 1000;
            count++;
        }

        return (prefix + " " + sb.toString()).trim();
    }

    private String convertLessThan1000(int num) {
        int hun = num / 100;
        int ten = (num % 100) / 10;

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (hun > 0) {
                sb.append(Ones[hun]);
                sb.append(" ");
                sb.append(Special_1[0]);
                sb.append(" ");
                num -= hun * 100;
            }
            if (ten >= 2) {
                sb.append(Tens[ten]);
                sb.append(" ");
                num -= ten * 10;
            }
            if (num > 0) {
                sb.append(Ones[num]);
                num -= num;
            } else {
                //if num is 0 then delete the trailing space
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntToEnglish_LE_273_P1 solution = new IntToEnglish_LE_273_P1();
        int num = 12345678;

        System.out.println(solution.numberToWords(num));
    }
}
