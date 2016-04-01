package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.restoreipaddress.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 4/1/16 3:40 PM
 */
public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        rec (s, result, 0, new ArrayList<String>());
        return result;
    }

    private static void rec(String s, ArrayList<String> result, int start, ArrayList<String> list) {
        if (start == s.length()) {
            if (list.size() == 4) {
                result.add(buildStringFromList(list));
            }
            return;
        }

        for (int i = start; i < s.length() && i <= start+2; i++) {
            if (list.size() == 4) {
                break;
            }
            String cur = s.substring(start, i+1);
            if (isValidIP(cur)) {
                list.add(cur);
                rec(s, result, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }

    private static String buildStringFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private static boolean isValidIP(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        int i = Integer.valueOf(s);
        return i >= 0 && i <= 255;
    }

    public static void main(String[] args) {
        String test = "25525511135";
        System.out.println(restoreIpAddresses(test));
    }
}
