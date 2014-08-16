package freq5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author jianshen
 */
public class WordLadder {
    //level 3
    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));

        int ladderLength = ladderLength(start, end, dict);
        System.out.println(ladderLength);
    }

    public static int ladderLength(String start, String end, Set<String> dict) {
        Set<String> ladder = new HashSet<String>();
        ladder.add(start);

        String prevLadder = start;
        boolean found = false;

        while (dict.size() != 0){
            String nextLadder = findNextLadder(prevLadder, dict);
            if (nextLadder != null) {
                ladder.add(nextLadder);
                if (isOneCharDiff(nextLadder, end)){
                    ladder.add(end);
                    found = true;
                    break;
                }
                prevLadder = nextLadder;
                dict.remove(nextLadder);
            }
        }

        if (found)
            return ladder.size();
        else
            return 0;
    }

    private static String findNextLadder(String prev, Set<String> dict){
        for (String s : dict){
            if (isOneCharDiff(prev, s)){
                return s;
            }
        }
        return null;
    }

    private static boolean isOneCharDiff (String a, String b){
        if (a == null || b == null) return false;

        int count=0;
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }

        if (count == 1) return true;
        else return false;
    }
}
