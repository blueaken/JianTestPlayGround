package jdk8.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shenjian on 2017/6/16.
 */
public class FilterNullValues {
    public static void main(String[] args) {
        Stream<String> language = Stream.of("java", "ruby", null, "php", null, "c#");

        //no null filter
        //List<String> result = language.collect(Collectors.toList());

        //with null filter
        //List<String> result = language.filter(x -> x!=null).collect(Collectors.toList());

        //with object filter
        List<String> result = language.filter(Objects::nonNull).collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
