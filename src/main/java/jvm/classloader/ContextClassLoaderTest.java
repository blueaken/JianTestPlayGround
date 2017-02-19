package jvm.classloader;

import com.mysql.jdbc.Driver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by jianshen on 2/18/17.
 */
public class ContextClassLoaderTest {

    public static void main(String[] args) {
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Driver driver = (Driver) iterator.next();
            System.out.println("driver:" + driver.getClass() + ",loader:" + driver.getClass().getClassLoader());
        }
    }

}
