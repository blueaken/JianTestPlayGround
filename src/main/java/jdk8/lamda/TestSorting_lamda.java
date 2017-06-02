package jdk8.lamda;

import type.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shenjian on 2017/6/2.
 */
public class TestSorting_lamda {
    public static void main(String[] args) {
        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs) {
            System.out.println(developer);
        }

        //sort by age
        //lambda here!
        listDevs.sort((Developer o1, Developer o2)->o1.getAge()-o2.getAge());

        System.out.println();
        System.out.println("After Sort");
        //java 8 only, lambda also, to print the List
        listDevs.forEach((developer)->System.out.println(developer));

    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("bruce", new BigDecimal("70000"), 33));
        result.add(new Developer("max", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));

        return result;

    }
}
