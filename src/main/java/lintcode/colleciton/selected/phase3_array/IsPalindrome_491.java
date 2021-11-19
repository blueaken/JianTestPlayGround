package lintcode.colleciton.selected.phase3_array;

public class IsPalindrome_491 {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public static boolean isPalindrome(int num) {
        // write your code here
        int div = 1;
        while (num / div >= 10) div *= 10;
        while (num > 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right) return false;

            num = num - left * div;
            num /= 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
//        int input = 1234;
//        int input = 121;
        int input = 1;
//        System.out.println(input / 1000);
        System.out.println(isPalindrome(input));
    }
}
