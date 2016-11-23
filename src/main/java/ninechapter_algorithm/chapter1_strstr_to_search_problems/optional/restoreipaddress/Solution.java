package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.restoreipaddress;

import java.util.ArrayList;

/**
 * Author: blueaken
 * Date: 3/30/16 2:03 PM
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

        rec(s, result, new ArrayList<String>(), 0);
        return result;
    }

    private static void rec (String s, ArrayList<String> result, ArrayList<String> list, int start) {
        if (list.size() == 4 && start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (String ip : list) {
                sb.append(ip);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length() && i <= start+2; i++) {
            String cur = s.substring(start, i+1);
            if (isValidIP(cur)) {
                list.add(cur);
                rec(s, result, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isValidIP(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        int i = Integer.valueOf(s);
        return i >= 0 && i <= 255;
    }

    private static boolean contains4Ips(String temp) {
        return temp.split(".").length == 4;
    }

    public static void main(String[] args) {
        String test = "25525511135";
        System.out.println(restoreIpAddresses(test));
    }
}
