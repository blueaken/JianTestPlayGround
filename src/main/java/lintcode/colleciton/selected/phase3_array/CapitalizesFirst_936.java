package lintcode.colleciton.selected.phase3_array;

public class CapitalizesFirst_936 {
    /**
     * @param s: a string
     * @return: a string after capitalizes the first letter
     */
    //Key idea：通过过去一格检查是否空格，判断是否首字母
    public String capitalizesFirst(String s) {
        // Write your code here
        char[] arr = s.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
        return String.valueOf(arr);
    }
}
