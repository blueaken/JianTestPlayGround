package ninechapter_algorithm.chapter1_strstr_to_search_problems.optional.restoreipaddress.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: blueaken
 * Date: 6/20/16 09:58
 */
public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        rec(result, s, new ArrayList<String>(), 0);
        return result;
    }

    private void rec(ArrayList<String> result, String s, List<String> list, int index) {
        if (list.size() == 4) {
            if (index == s.length()) {
                result.add(getStringFromList(list));
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String cur = s.substring(index, i + 1);
            if (isValidIp(cur)) {
                list.add(cur);
                rec(result, s, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isValidIp(String s) {
        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        long l = Long.valueOf(s);
        return l >= 0 && l <= 255;
    }

    private String getStringFromList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
