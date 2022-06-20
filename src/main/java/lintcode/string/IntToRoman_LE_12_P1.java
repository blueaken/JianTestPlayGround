package lintcode.string;

public class IntToRoman_LE_12_P1 {
    /*
        1. there are multiple combinations of roman number to integer, choose the largest possible one.
        2. try solve it with just the 7 formal number without 6 additional 2 number combinations, just in case.
        3. can always hard code as much as possible Rom numbers, as Roman Number has a finite set, and get O(1) time.
    */
    /*
            Symbol       Value
            I             1
            V             5
            X             10
            L             50
            C             100
            D             500
            M             1000
     */
    public String intToRoman(int num) {
        int thou = num / 1000;
        int hun = (num % 1000) / 100;
        int ten = (num % 100) / 10;
        int one = num % 10;

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            while (thou > 0) {
                sb.append("M");
                thou--;
                num -= 1000;
            }
            while (hun > 0) {
                if (hun == 9) {
                    sb.append("CM");
                    hun -= 9;
                    num -= 900;
                } else if (hun >= 5) {
                    sb.append("D");
                    hun -= 5;
                    num -= 500;
                } else if (hun == 4) {
                    sb.append("CD");
                    hun -= 4;
                    num -= 400;
                } else {
                    sb.append("C");
                    hun--;
                    num -= 100;
                }
            }
            while (ten > 0) {
                if (ten == 9) {
                    sb.append("XC");
                    ten -= 9;
                    num -= 90;
                } else if (ten >= 5) {
                    sb.append("L");
                    ten -= 5;
                    num -= 50;
                } else if (ten == 4) {
                    sb.append("XL");
                    ten -= 4;
                    num -= 40;
                } else {
                    sb.append("X");
                    ten--;
                    num -= 10;
                }
            }
            while (one > 0) {
                if (one == 9) {
                    sb.append("IX");
                    one -= 9;
                    num -= 9;
                } else if (one >= 5) {
                    sb.append("V");
                    one -= 5;
                    num -= 5;
                } else if (one == 4) {
                    sb.append("IV");
                    one -= 4;
                    num -= 4;
                } else {
                    sb.append("I");
                    one--;
                    num--;
                }
            }
        }
        return sb.toString();
    }
}
