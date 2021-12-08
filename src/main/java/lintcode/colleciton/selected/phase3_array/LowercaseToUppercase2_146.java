package lintcode.colleciton.selected.phase3_array;

public class LowercaseToUppercase2_146 {
    /**
     * @param letters: A string
     * @return: A string
     */
    public String lowercaseToUppercase2(String letters) {
        // write your code here
        if (letters.isEmpty()) return null;

        char[] arr = letters.toCharArray();
        for (int i = 0; i < letters.length(); i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
        return String.valueOf(arr);
    }
}
