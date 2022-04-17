package lintcode.multithread.variablemodification_2496;

//Idea - 由于是修改同一个变量，为了线程安全需要在操作时加锁或其他同步方式
public class VariableModification_2496 {
    private int i;
    // write your code

    public VariableModification_2496() {
        this.i = 0;
        // write your code

    }

    public synchronized void add1() throws Exception{
        // write your code
        i = Main.increase(i);
    }

    public synchronized void add2() throws Exception{
        // write your code
        i = Main.increase(i);
    }

    public synchronized void sub1() throws Exception{
        // write your code
        i = Main.decrease(i);
    }

    public synchronized void sub2() throws Exception{
        // write your code
        i = Main.decrease(i);
    }

    public int checkI(){
        return i;
    }
}
