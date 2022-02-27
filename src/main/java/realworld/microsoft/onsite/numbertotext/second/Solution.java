package realworld.microsoft.onsite.numbertotext.second;

public class Solution {
    private static final String[] specialNames = {
            "",
            " thousand",
            " million",
            " billion",
            " trillion",
            " quadrillion",
            " quintillion"
    };

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public String convert(int number) {
        if (number == 0) {
            return "zero";
        }

        String prefix = "";
        if (number < 0) {
            prefix = "negative";
            number = -number;
        }

        String current = "";
        int place = 0;
        do {
            int tmp = number % 1000;
            if (tmp != 0) {
                String tmpString = convertLessThanOneThousand(tmp);
                current = tmpString + specialNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    private String convertLessThanOneThousand (int tmp) {
        String cur;
        if (tmp % 100 < 20) {
            cur = numNames[tmp % 100];
            tmp /= 100;
        } else {
            cur = numNames[tmp % 10];
            tmp /= 10;

            cur = tensNames[tmp % 10] + cur;
            tmp /= 10;
        }

        if (tmp == 0) {
            return cur;
        } else {
            return numNames[tmp] + " hundred" + cur;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

//        System.out.println("*** " + obj.convert(123));
//        System.out.println("*** " + obj.convert(123456789));
        System.out.println("*** " + obj.convert(-55));
    }
}
