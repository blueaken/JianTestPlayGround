package lintcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion_LE_1268 {
    /*
        - brute force is a good choice, because the length of string is less than 1000.
        - Time O(M*N), M - length of searchWord, N - length of products array
    */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String cur = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            int count = 3;
            for (int j = 0; j < products.length; j++) {
                if (count > 0 && products[j].indexOf(cur) != -1) {
                    list.add(products[j]);
                    count--;
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        SearchSuggestion_LE_1268 solution = new SearchSuggestion_LE_1268();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
//        [
            //["mobile","moneypot","monitor"],
            //["mobile","moneypot","monitor"],
            //["mouse","mousepad"],
            //["mouse","mousepad"],
            //["mouse","mousepad"]
//]

        System.out.println(solution.suggestedProducts(products, searchWord).toString());

    }
}
