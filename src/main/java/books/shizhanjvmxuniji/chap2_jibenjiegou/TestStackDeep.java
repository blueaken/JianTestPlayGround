package books.shizhanjvmxuniji.chap2_jibenjiegou;

/**
 * Created by jianshen on 2/22/17.
 */
public class TestStackDeep {
    //private static int count = 0;
    private int count = 0;
    public void recursion() {
        this.count++;
        recursion();
    }

    public static void main(String[] args) {
        //note: set the VM option -Xss320k and -Xss640k and see the diff of stack calling depth
        //2873 vs 6969
        TestStackDeep testStackDeep = new TestStackDeep();
        try {
            testStackDeep.recursion();
        } catch (Throwable e) {
            System.out.println("depth of calling = " + testStackDeep.count);
            e.printStackTrace();
        }
    }
}
