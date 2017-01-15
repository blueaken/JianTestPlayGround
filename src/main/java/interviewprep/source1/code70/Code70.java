package interviewprep.source1.code70;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jianshen on 1/14/17.
 */
public class Code70 {

    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(new Person("p1", 34));
        set.add(new Customer("c1", 37, "address 1"));
        set.add(new Person("p2", 38));
        set.add(new Customer("c2", 39, "address 2"));

        System.out.println(set.size());
    }
}
