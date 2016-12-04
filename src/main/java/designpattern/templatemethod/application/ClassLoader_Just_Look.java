package designpattern.templatemethod.application;

/**
 * Created by jianshen on 12/3/16.
 */
public abstract class ClassLoader_Just_Look {
    //这是一个重载方法
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        return loadClass(name, false);
//    }

    //这里就是父类算法的定义
//    protected synchronized Class<?> loadClass(String name, boolean resolve)
//            throws ClassNotFoundException
//    {
//        Class c = findLoadedClass(name);
//        if (c == null) {
//            try {
//                if (parent != null) {
//                    c = parent.loadClass(name, false);
//                } else {
//                    c = findBootstrapClass0(name);
//                }
//            } catch (ClassNotFoundException e) {
//                c = findClass(name);
//            }
//        }
//        if (resolve) {
//            resolveClass(c);
//        }
//        return c;
//    }

    //这里留了一个方法给子类选择性覆盖
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }
}
