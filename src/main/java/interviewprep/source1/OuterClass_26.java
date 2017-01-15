package interviewprep.source1;

/**
 * Created by jianshen on 1/10/17.
 */
public class OuterClass_26 {

    String a = "A";
    String b = "B";
    String c = "C";


    class InnerClass{
        int x;
        public String getA(){
            return a; // access the variable a from outer class
        }
    }

    public static class StaticInnerClass{
        int x;
//        public String getA(){
//            return a; // cannot access the non static variable from outer class
//        }
    }

    public String stringConCat(){
        return a + b + c;
    }
}


class Test{

    public static void main(String args[]) {

        OuterClass_26.StaticInnerClass staticClass = new OuterClass_26.StaticInnerClass();
        OuterClass_26 outer = new OuterClass_26();
        OuterClass_26.InnerClass inner = outer.new InnerClass();

        System.out.println(inner.getA()); // This will print "A"
    }
}
