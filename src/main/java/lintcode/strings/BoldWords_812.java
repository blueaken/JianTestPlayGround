package lintcode.strings;

public class BoldWords_812 {
    /**
     * @param words: the words
     * @param S: the string
     * @return: the string with least number of tags
     */
    //Ref - https://www.cxymm.net/article/leyi520/108646666
    public String boldWords(String[] words, String S) {
        // Write your code here
        //init an array to record bold positions
        boolean[] bold = new boolean[S.length()];
        for (String word : words) {
            int startIdx = S.indexOf(word);
            while (startIdx != -1) {
                for (int i = startIdx; i < startIdx + word.length(); i++) {
                    bold[i] = true;
                }
                startIdx = S.indexOf(word, startIdx + 1); //in case existing more than one word in S
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean toBold = false;
        for (int i = 0; i < S.length(); i++) {
            if (bold[i]) {
                if (!toBold) {
                    toBold = true;
                    sb.append("<b>");
                }
                sb.append(S.charAt(i));
            } else {
                if (toBold) {
                    toBold = false;
                    sb.append("</b>");
                }
                sb.append(S.charAt(i));
            }
        }
        if (toBold) { //in case last position is also key
            toBold = false;
            sb.append("</b>");
        }

        return sb.toString();
    }
}
