package lintcode.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class AutocompleteSystem_LE_642 {
    Trie root;
    Trie cur;
    StringBuilder sb;

    /*
        - coding ref https://www.youtube.com/watch?v=NX68_rf_gxE
        - it is a design quesiton, many design trade off question can be thought
          ref 花花 https://www.youtube.com/watch?v=uIqvbYVBiCI & 九章令狐也讲过这种类型题
    */
    public AutocompleteSystem_LE_642(String[] sentences, int[] times) {
        root = new Trie();
        cur = root;
        sb = new StringBuilder();

        int size = sentences.length;
        for (int i = 0; i < size; i++) {
            root.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            root.insert(sb.toString(), 1);

            //reset & return
            cur = root;
            sb = new StringBuilder();
            return res;
        }

        sb.append(c);
        if (cur != null) {
            cur = cur.children.get(c);
        }

        if (cur == null) {
            return res;
        }
        for (Trie node : cur.top3) {
            res.add(node.sentence);
        }
        return res;
    }

    class Trie implements Comparable<Trie> {
        Map<Character, Trie> children;
        String sentence; //cache at the sentence end node
        int times;
        List<Trie> top3;

        Trie () {
            children = new HashMap<>();
            sentence = null;
            times = 0;
            top3 = new ArrayList<>();
        }

        @Override
        public int compareTo (Trie o) {
            //if 2 sentence has the same hot degree, use ascii code order (smaller ones appear first)
            if (this.times == o.times) {
                return this.sentence.compareTo(o.sentence);
            }
            //otherwise order by the hot degree (times), bigger one appear first
            return o.times - this.times;
        }

        public void update (Trie node) {
            if (!this.top3.contains(node)) {
                this.top3.add(node);
            }

            Collections.sort(this.top3);
            if (this.top3.size() > 3) {
                this.top3.remove(this.top3.size() - 1); //remove the last position
            }
        }

        public void insert(String sentence, int times) {
            Trie cur = this;
            List<Trie> nodeList = new ArrayList<>();
            for (char c : sentence.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
                nodeList.add(cur);
            }

            cur.sentence = sentence;
            cur.times += times;
            //update the current sentence node to the top3 list of each node along the path
            for (Trie node : nodeList) {
                node.update(cur);
            }
        }
    }

    public static void main(String[] args) {
//        String[] sentences = {"abc", "abbc", "a"};
//        int[] times = {3, 3, 3};
//        AutocompleteSystem_LE_642 solution = new AutocompleteSystem_LE_642(sentences, times);
//        System.out.println(solution.input('b')); //[]
//        System.out.println(solution.input('c')); //[]
//        System.out.println(solution.input('#')); //[]
//        System.out.println(solution.input('b')); //["bc"], note "bc" appear this time since last '#' is input
//        System.out.println(solution.input('c')); //["bc"]
//        System.out.println(solution.input('#')); //[]
//        System.out.println(solution.input('a')); //["a","abbc","abc"]
//        System.out.println(solution.input('b')); //["abbc","abc"]
//        System.out.println(solution.input('c')); //["abc"]
//        System.out.println(solution.input('#')); //[]
//        System.out.println(solution.input('a')); //["abc","a","abbc"], note the "abc" is hotter than "a" this time
//        System.out.println(solution.input('b')); //["abc","abbc"]
//        System.out.println(solution.input('c')); //["abc"]
//        System.out.println(solution.input('#')); //[]

        String[] sentences = {"abc"};
        int[] times = {3};
        AutocompleteSystem_LE_642 solution = new AutocompleteSystem_LE_642(sentences, times);
        System.out.println(solution.input('a')); //["abc"]
        System.out.println(solution.input('b')); //["abc"]
        System.out.println(solution.input('c')); //["abc"]
        System.out.println(solution.input('#')); //[]
    }
}
