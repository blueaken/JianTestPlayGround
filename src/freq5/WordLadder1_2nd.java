package freq5;

import java.util.*;

/**
 * Author: blueaken
 * Date: 8/21/14 9:34 下午
 */
public class WordLadder1_2nd {
    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));

        System.out.println(ladderLength(start, end, dict));
    }

    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict.isEmpty() ) return 0;

        Queue queue = new LinkedList();
        queue.offer(start);
        dict.remove(start);

        int wordLen = start.length();
        int ladderLength = 1;

        String current, temp;
        while (!queue.isEmpty()){
            current = (String)queue.remove();
            for (int i = 0; i < wordLen; i++){
                for (char c = 'a'; c <= 'z' ; c++){
                    if (current.charAt(i) == c) continue;

                    temp = replace(current, i, c);
                    if (temp.equalsIgnoreCase(end)){
                        return ladderLength + 1;
                    }

                    if (dict.contains(temp)){
                        dict.remove(temp);
                        queue.offer(temp);
                    }
                }
            }
            ladderLength ++;
        }

        return 0;
    }

    private static String replace(String current, int pos, char c){
        StringBuilder sb = new StringBuilder(current);
        sb.setCharAt(pos, c);
        return sb.toString();
    }
}
