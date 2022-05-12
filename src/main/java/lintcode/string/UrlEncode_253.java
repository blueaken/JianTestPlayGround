package lintcode.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UrlEncode_253 {
    /**
     * @param base_url: the string of base_url
     * @param query_params: sequence of two-element tuples by query_params
     * @return: return a url query string
     */
    //Idea: 利用String的compareTo方法进行字典顺序排序，ref - https://www.lintcode.com/problem/253/solution/33835
    public String urlencode(String base_url, List<List<String>> query_params) {
        // write your code.
        if (base_url.length() == 0) {
            return null;
        }
        Collections.sort(query_params, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2) {
                return l1.get(0).compareTo(l2.get(0));
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(base_url);
        sb.append('?');
        for (List<String> query_param : query_params) {
            sb.append(query_param.get(0));
            sb.append('=');
            sb.append(query_param.get(1));
            sb.append('&');
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
