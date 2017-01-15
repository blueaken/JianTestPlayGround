package interviewprep.source1.code70;

/**
 * Created by jianshen on 1/14/17.
 */
public class Person implements Comparable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("compareTo in Person");

        Person other = (Person) o;
        //compare name
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare > 0) {
            return 1;
        }
        if (nameCompare < 0) {
            return -1;
        }

        //compare age
        if (this.age > other.age) {
            return 1;
        }
        if (this.age < other.age) {
            return -1;
        }
        return 0;
    }
}

