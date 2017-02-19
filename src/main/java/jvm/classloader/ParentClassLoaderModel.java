package jvm.classloader;

/**
 * Created by jianshen on 2/18/17.
 * The loadClass method below is a copy from JDK. It implements the parent model for classloader.
 */
public class ParentClassLoaderModel {
//    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//        //首先，检查请求的类是否已经被加载过了
//        Class c = findLoaderClass(name);
//        if (c == null) {
//            try {
//                if (parent != null) {
//                    c = parent.loadClass(name, false);
//                } else {
//                    c = findBootstrapClassOrNull(name);
//                }
//            } catch (ClassNotFoundException e) {
//                //如果抛出ClassNotFoundException说明父类加载器无法完成加载请求，下面会调用本身的findClass方法来加载
//            }
//
//            if (c == null) {
//                c = findClass(name);
//            }
//        }
//
//        if (resolve) {
//            resolveClass(c);
//        }
//
//        return c;
//    }
}
