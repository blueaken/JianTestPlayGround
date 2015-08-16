package leetcode.medium.wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jshe18 on 8/15/15.
 */
public class Solution {
    public static void main(String[] args) {

        HashMap<String,Double> map = new HashMap<String,Double>();
        ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);

        map.put("A",99.5);
        map.put("B",67.4);
        map.put("C",67.4);
        map.put("D",67.3);
        map.put("F",67.4);
        map.put("X",67.4);

//        map.put("A",1d);
//        map.put("B",1d);
//        map.put("C",67d);
//        map.put("D",99.5d);


        System.out.println("unsorted map: "+map);
        sorted_map.putAll(map);
        System.out.println("results: "+sorted_map);
//
//        System.out.println("************************");
//        System.out.println();
//
//        map.put("A",1d);
//        map.put("B",1d);
//        map.put("C",67d);
//        map.put("D",99.5d);
//
//        System.out.println("unsorted map: "+map);
//        sorted_map.putAll(map);
//        System.out.println("results: "+sorted_map);

    }

    List<String> countWords(String filename) throws IOException{
        List<String> records = new ArrayList<String>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null){
                records.add(line);
            }

            Map<String, Integer> map = new HashMap<String, Integer>();
            for (String record : records){
                String[] temp = record.split(" ");
                Integer current;
                if (temp.length >0) {
                    for (String s : temp){
                        current = map.get(s);
                        if (current == null){
                            map.put(s, 1);
                        } else{
                            map.put(s, current+1);
                        }
                    }
                }
            }

            //use solution suggested above
//            MapIntegerValueComparator mapIntegerValueComparator =  new MapIntegerValueComparator(map);
//            TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(mapIntegerValueComparator);

            List<String> output = new ArrayList<String>();
            Integer tempVal = 0;
            Integer max = 0;
            while (map.size() > 0){
                String maxKey = null;
                for (String key : map.keySet()){
                    tempVal = map.get(key);
                    if (tempVal > max){
                        max = tempVal;
                        maxKey = key;
                    }
                }
                output.add(maxKey);
                map.remove(maxKey);
                max = 0;
            }

            return output;

        }
        catch (Exception e){
            System.out.println("Exception occured.");
            e.printStackTrace();
        }
        finally{
            reader.close();
        }

        return null;
    }

}

class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}

class MapIntegerValueComparator implements Comparator<String> {

    Map<String, Integer> base;
    public MapIntegerValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
