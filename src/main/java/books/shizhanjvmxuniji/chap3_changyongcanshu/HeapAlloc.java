package books.shizhanjvmxuniji.chap3_changyongcanshu;

/**
 * Created by jianshen on 6/1/17.
 */
public class HeapAlloc {
    public static void main(String[] args) {
        System.out.print("MaxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
        System.out.println("＝＝＝＝＝＝＝＝＝ seperator = =＝＝＝＝＝＝＝＝＝＝");
        byte[] b = new byte[2*1024*1024];
        System.out.println("分配了2M空间给数组");

        System.out.print("MaxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
        System.out.println("＝＝＝＝＝＝＝＝＝ seperator = =＝＝＝＝＝＝＝＝＝＝");
        b = new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");

        System.out.print("MaxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
        System.out.print("free mem=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
        System.out.print("total mem=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
    }
}
