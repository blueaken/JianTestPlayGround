package interviewprep.morganstanley;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jianshen on 12/21/14.
 */
/*
* build a generic comparator with reflection
 */
public class GenericComparator<T> implements Comparator<T> {


    public static void main(String[] args){
        Student s1 = new Student("david");
        Student s2 = new Student("adam");

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);

        System.out.println("Before sort: " + list);

        Collections.sort(list, new GenericComparator<Student>("getName"));

        System.out.println("After sort: " + list);
    }

    private String property;

    public GenericComparator(String property){
        this.property = property;
    }

    @Override
    public int compare(Object o1, Object o2){
        Comparable o1Comparable = getComparable(o1);
        Comparable o2Comparable = getComparable(o2);

        return o1Comparable.compareTo(o2Comparable);
    }

    private Comparable getComparable(Object o){
        if (o instanceof Comparator){
            return (Comparable)o;
        }

        Method method = null;
        try{
            method = o.getClass().getMethod(property, new Class[]{});
        } catch (NoSuchMethodException e){
            e.printStackTrace();
        }

        Object invoke = null;
        try{
            invoke = method.invoke(o, new Class[]{});
        } catch (Exception e){
            e.printStackTrace();
        }
        return (Comparable)invoke;
    }

}

class Student
{
    private String name;
    Student(String name) {this.name = name;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String toString()
    {
        return new StringBuilder()
                .append("student name: ")
                .append(name)
                .toString();
    }
}
