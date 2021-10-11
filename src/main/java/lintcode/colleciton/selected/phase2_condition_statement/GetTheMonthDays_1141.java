package lintcode.colleciton.selected.phase2_condition_statement;

public class GetTheMonthDays_1141 {
    /**
     * @param year: a number year
     * @param month: a number month
     * @return: Given the year and the month, return the number of days of the month.
     */
    public static int getTheMonthDays(int year, int month) {
        // write your code here
        //Note: to tell lunar year，满足2个条件之一
        //1. 能被4整除，且不能被100整除
        //2. 能被400整除
        int dayNum[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ) {
            dayNum[2] = 29;
        }
        return dayNum[month];
    }

    public static void main(String[] args) {
        System.out.println(getTheMonthDays(1985, 2));
        System.out.println(getTheMonthDays(2000, 2)); //lunar year
    }

}
