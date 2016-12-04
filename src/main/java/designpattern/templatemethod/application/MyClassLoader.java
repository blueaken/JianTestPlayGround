package designpattern.templatemethod.application;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jianshen on 12/3/16.
 */

public class MyClassLoader extends ClassLoader {

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            return super.loadClass(name);
        }
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

}