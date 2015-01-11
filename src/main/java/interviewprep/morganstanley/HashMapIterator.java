package interviewprep.morganstanley;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jianshen on 1/11/15.
 */
public class HashMapIterator {
    public static void main(String[] args){
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "Y");
        hashMap.put("b", "E");
        hashMap.put("c", "S");
        hashMap.put("d", "S");
        hashMap.put("e", "W");

        int size = hashMap.size();

        //1. for loop with entrySet
        System.out.println("1. foreach loop with entrySet (Java 5)");
        for (Map.Entry<String, String> entry: hashMap.entrySet()){
            System.out.println("entry line: "  + entry.getKey() + " " + entry.getValue());
        }

        System.out.println("------------------");

        //2. for loop with keySet - less efficient
        System.out.println("2. foreach loop with keySet (Java 5)");
        for (String key: hashMap.keySet()){
            System.out.println("entry line: "  + key + " " + hashMap.get(key));
        }

        System.out.println("------------------");

        //3. while iterator loop with entrySet
        System.out.println("3. while iterator loop with entrySet (Java 4 and under)");
        Iterator entryIt = hashMap.entrySet().iterator();
        while (entryIt.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry<String, String>)entryIt.next();
            System.out.println("entry line: "  + entry.getKey() + " " + entry.getValue());
        }

        System.out.println("------------------");

        //4. while iterator loop with keySet
        System.out.println("4. while iterator loop with keySet (Java 4 and under)");
        Iterator keyIt = hashMap.keySet().iterator();
        while (keyIt.hasNext()){
            String key = (String)keyIt.next();
            System.out.println("entry line: "  + key + " " + hashMap.get(key));
        }

    }
}
