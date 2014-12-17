package freq5;

import java.util.*;

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

    // read Jiaxin's post: http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html
    // and it makes sense to me! Using graph BFS to solve it. The shortest path is guaranteed by BFS.
    public static int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;

        while (!queue.isEmpty()) {
            int count = queue.size();

            // Check each adjacent string
            for (int i = 0; i < count; i++) {
                String current = queue.poll();
                // Check if there's adjacent string
                for (int j = 0; j < current.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == current.charAt(j)) {
                            continue;
                        }

                        String temp = replace(current, j, c);
                        if (temp.equals(end)) {
                            return length + 1;
                        }

                        if (dict.contains(temp)) {
                            queue.offer(temp);
                            dict.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private static String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    //my first try - can find a ladder but not the shortest length
//    public static int ladderLength(String start, String end, Set<String> dict) {
//        Set<String> ladder = new HashSet<String>();
//        ladder.add(start);
//
//        String prevLadder = start;
//        boolean found = false;
//
//        while (dict.size() != 0){
//            String nextLadder = findNextLadder(prevLadder, dict);
//            if (nextLadder != null) {
//                ladder.add(nextLadder);
//                if (isOneCharDiff(nextLadder, end)){
//                    ladder.add(end);
//                    found = true;
//                    break;
//                }
//                prevLadder = nextLadder;
//                dict.remove(nextLadder);
//            }
//        }
//
//        if (found)
//            return ladder.size();
//        else
//            return 0;
//    }
//
//    private static String findNextLadder(String prev, Set<String> dict){
//        for (String s : dict){
//            if (isOneCharDiff(prev, s)){
//                return s;
//            }
//        }
//        return null;
//    }
//
//    private static boolean isOneCharDiff (String a, String b){
//        if (a == null || b == null) return false;
//
//        int count=0;
//        for (int i=0; i<a.length(); i++){
//            if (a.charAt(i) != b.charAt(i)) count++;
//            if (count > 1) return false;
//        }
//
//        if (count == 1) return true;
//        else return false;
//    }
}
