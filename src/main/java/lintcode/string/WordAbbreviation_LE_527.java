package lintcode.string;

import java.util.*;

public class WordAbbreviation_LE_527 {
    /**
     11.29.2022
     ref huifeng guan video - https://www.youtube.com/watch?v=G-0QGOGea5M
     - solve with mock process of string
     - the key is how to write elegant code of this mock process with the suitable data structure and logic process
     - note the Java solution need some refactor from Huifeng's C++ solution
     */
    public List<String> wordsAbbreviation(List<String> words) {
        String[] res = new String[words.size()];
        List<Integer> working = new ArrayList<>(); //need index position in the return list
        for (int i = 0; i < words.size(); i++) {
            working.add(i);
        }

        Map<String, List<Integer>> map = new HashMap<>(); //abbr, mapping words index
        int level = 1;
        while (working.size() > 0) {
            for (Integer idx : working) {
                String curWord = words.get(idx);
                String abbr = getAbbr(curWord, level);
                List<Integer> cur = map.getOrDefault(abbr, new ArrayList<>());
                cur.add(idx);
                map.put(abbr, cur);
            }
            working.clear(); //clear working list after one round of abbr

            //loop the map key entry with iterator object, since the map entry will be modified in the loop
            Iterator<String> itr = map.keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next();
                List<Integer> cur = map.get(key);
                if (cur.size() > 1) {
                    //find multiple words mapping same abbr, need next round of work
                    for (Integer idx : cur) {
                        working.add(idx);
                    }
                } else {
                    res[cur.get(0)] = key;
                }
                itr.remove();  // call Iterator remove method to clear map entry
            }
            level++;
        }
        return Arrays.asList(res);
    }

    private String getAbbr(String word, int level) {
        int n = word.length();
        if (n - level < 3) {
            return word;
        }

        String temp = word.substring(0, level);
        temp += n - temp.length() -1;
        temp += word.charAt(n-1);

        if (temp.length() == word.length()) {
            return word;
        } else {
            return temp;
        }
    }
}
