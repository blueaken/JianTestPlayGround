package lintcode.string;

public class ReverseWordsInAString_LE_151 {
    /**
     3.16.2023
     ref 东哥 template
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // clean up extra spaces of the original string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0 && sb.charAt(sb.length()-1) != ' ') {
                sb.append(' ');
            }
        }
        // clean up trailing 0 if any
        if (sb.charAt(sb.length()-1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }

        char[] arr = sb.toString().toCharArray();
        int n = arr.length;
        reverse(arr, 0, n-1);

        // reverse each word
        int i = 0;
        for (int j = i; j < n; j++) {
            if (j + 1 == n || arr[j+1] == ' ') {
                // find a word
                reverse(arr, i, j);
                // set i to the start of next word
                i = j + 2;
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
