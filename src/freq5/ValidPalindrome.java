package freq5;

/**
 * @author jianshen
 */
public class ValidPalindrome {
    //level 2
    public static void main(String[] args){
        String validPalindrom = "A man, a plan, a canal: Panama";
        String inValidPalindrom = "race a car";
        String testBoundary = ".,";

        System.out.println(isPalindrome(validPalindrom));
        System.out.println(isPalindrome(inValidPalindrom));
        System.out.println(isPalindrome(testBoundary));
    }

    /*
    * 第一次就成功了，但又觉得可以做一些改进：把input string先小写字母化，可以节省对每个char的小写字母化的cost;
    * 是否需要每次都continue? -还是需要的，不然就在循环内加判是否出界的logic
    * 改进一下，“榨干每个训练动作的价值” from <囚徒健身>
     */
    //
    public static boolean isPalindrome(String s) {
        if (s == null) return true;

        char[] arr = s.toLowerCase().toCharArray();
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

            if (arr[start++] == arr[end--]) continue;
            return false;
        }

        return true;
    }

    // first try
//    public static boolean isPalindrome(String s) {
//        if (s == null) return true;
//
//        char[] arr = s.toCharArray();
//        int start = 0;
//        int end = arr.length -1;
//
//        while (start < end){
//            if (!Character.toString(arr[start]).matches("[a-zA-Z0-9]")) {
//                start++;
//                continue;
//            }
//
//            if (!Character.toString(arr[end]).matches("[a-zA-Z0-9]")) {
//                end--;
//                continue;
//            }
//
//            if (Character.toLowerCase(arr[start++]) == Character.toLowerCase(arr[end--])) continue;
//            return false;
//        }
//
//        return true;
//    }
}
