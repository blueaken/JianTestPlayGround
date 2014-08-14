package freq5;

/**
 * @author jianshen
 */
public class ValidPalindrome {
    //level 2
    public static void main(String[] args){
        String validPalindrom = "A man, a plan, a canal: Panama";
        String inValidPalindrom = "race a car";

        System.out.println(isPalindrome(validPalindrom));
        System.out.println(isPalindrome(inValidPalindrom));
    }

    public static boolean isPalindrome(String s) {
        if (s == null) return true;

        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length -1;

        while (start < end){
            if (!Character.toString(arr[start]).matches("[a-zA-Z0-9]")) {
                start++;
                continue;
            }

            if (!Character.toString(arr[end]).matches("[a-zA-Z0-9]")) {
                end--;
                continue;
            }

            if (Character.toLowerCase(arr[start++]) == Character.toLowerCase(arr[end--])) continue;
            return false;
        }

        return true;
    }
}
