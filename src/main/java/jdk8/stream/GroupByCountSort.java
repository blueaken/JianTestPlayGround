package jdk8.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by shenjian on 2017/6/16.
 */
public class GroupByCountSort {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        //Group by a List and display the total count of it
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println(result);

        //Sort a map and add to finalMap
        Map<String, Long> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);

    }
}
