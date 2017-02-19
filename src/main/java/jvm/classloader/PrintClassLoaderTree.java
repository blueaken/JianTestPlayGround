package jvm.classloader;

/**
 * Created by jianshen on 2/18/17.
 */
public class PrintClassLoaderTree {

    public static void main(String[] args) {
        ClassLoader cl = PrintClassLoaderTree.class.getClassLoader();
        while (cl != null) {
            System.out.println(cl);
            cl = cl.getParent();
        }
    }
}
