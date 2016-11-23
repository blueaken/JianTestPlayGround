package realworld.amazon.prep.findmostlybroughtItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: blueaken
 * Date: 3/23/16 2:46 PM
 */
public class Solution {
    public String findMostlyBroughtItem (String[] input, String inputProduct) {
        if (input == null) {
            return null;
        }
        String errorCode = "None";

        //init 2 maps - one for customer and one for product
        Map<String, List<String>> customerMap = new HashMap<>();
        Map<String, List<String>> productMap = new HashMap<>();
        List<String> products = new ArrayList<>();
        List<String> customers = new ArrayList<>();
        //todo: finish the work of init 2 maps

        //query the maps with the input products
        if (productMap.keySet().contains(inputProduct)){
            customers = productMap.get(inputProduct);
        } else {
            return errorCode;
        }

        Map<String, Integer> counter = new HashMap<>();
        for (String customer : customers) {
            products = customerMap.get(customer);
            for (String p : products) {
                if (!p.equalsIgnoreCase(inputProduct)) {
                    if (counter.keySet().contains(p)){
                        counter.put(p, counter.get(p) + 1);
                    } else {
                        counter.put(p, 1);
                    }
                }
            }
        }

        //find the max from the counter map and return product
        int max = 0;
        if (counter.keySet() == null) {
            return errorCode;
        } else {
            for (String p : counter.keySet()) {
                int temp = counter.get(p);
                max = Math.max(temp, max);
            }
        }

        return errorCode;
    }
}
