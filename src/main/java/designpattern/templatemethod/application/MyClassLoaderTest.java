package designpattern.templatemethod.application;

/**
 * Created by jianshen on 12/3/16.
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> clazz = classLoader.loadClass("designpattern.templatemethod.application.MyClassLoaderTest");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof ClassLoaderTest);
    }

}
