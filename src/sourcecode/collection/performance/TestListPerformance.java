package sourcecode.collection.performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author jianshen
 */
public class TestListPerformance {
    public static final int N = 50000;
    public static List values;

    static{
        Integer vals[]=new Integer[N];
        Random r=new Random();
        for(int i=0,currval=0;i<N;i++){
            vals[i] = new Integer(currval);
            currval+=r.nextInt(100)+1;
        }
        values= Arrays.asList(vals);
    }

    static long getHeavyLookupPerformance(List lst){
        long start=System.currentTimeMillis();
        for(int i=0;i<N;i++){
            int index= Collections.binarySearch(lst, values.get(i));
            if(index!=i)
                System.out.println("***错误***");
        }
        return System.currentTimeMillis()-start;
    }

    static long getHeavyInsertPerformance(List list){
        long start=System.currentTimeMillis();
        Object o = new Object();
        for(int i=0;i<N;i++)
            list.add(0, o);
        return System.currentTimeMillis()-start;
    }

    public static void main(String args[]){
        System.out.println("ArrayList time cost for heavy lookup task: " + getHeavyLookupPerformance(new ArrayList(values)));
        System.out.println("LinkedList time cost for heavy lookup task: " + getHeavyLookupPerformance(new LinkedList(values)));
        System.out.println("************************  separator line  **************************");
        System.out.println("ArrayList time cost for heavy insert task: " + getHeavyInsertPerformance(new ArrayList()));
        System.out.println("LinkedList time cost for heavy insert task: " + getHeavyInsertPerformance(new LinkedList()));
        System.out.println("************************  separator line  **************************");
        System.out.println("looks ArrayList insert performance getting improved in Java 1.6");
    }
}
