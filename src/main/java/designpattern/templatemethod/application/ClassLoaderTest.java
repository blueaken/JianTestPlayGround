package designpattern.templatemethod.application;

/**
 * Created by jianshen on 12/3/16.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass("designpattern.templatemethod.application.ClassLoaderTest");
        Object entity = clazz.newInstance();
        System.out.println(entity instanceof ClassLoaderTest);

    }
}
