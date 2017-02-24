package books.shizhanjvmxuniji.chap2_jibenjiegou;

/**
 * Created by jianshen on 2/22/17.
 */
public class SimpleArgs {
    //note: add vm parament and argument into the IntelliJ configuration fist
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数" + (i+1) + ": " + args[i]);
        }
        System.out.println("-Xmx: "+Runtime.getRuntime().maxMemory()/1000/1000 +"M");
    }
}
