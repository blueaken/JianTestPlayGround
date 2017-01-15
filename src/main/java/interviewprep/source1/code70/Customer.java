package interviewprep.source1.code70;

/**
 * Created by jianshen on 1/14/17.
 */
public class Customer extends Person implements Comparable{
    String address;

    public Customer(String name, int age, String address) {
        super(name, age);
        this.address = address;
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("compareTo in Customer");

        if (o instanceof Customer) {
            System.out.println("compare with Customer object");

            Customer other = (Customer) o;
            int superCompareResult = super.compareTo(o);

            //compare address if name and age are same
            if (superCompareResult == 0) {
                int addressCompare = this.address.compareTo(other.address);
                if (addressCompare > 0) {
                    return 1;
                } else if (addressCompare < 0) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return superCompareResult;
            }

        } else if (o instanceof Person){
            System.out.println("compare with Person object");
//                Person other = (Person) o;
                return super.compareTo(o);
        }

        return -1;
    }
}
