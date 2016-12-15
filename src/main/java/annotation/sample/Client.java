package annotation.sample;

import java.lang.reflect.Method;

/**
 * Created by jianshen on 12/14/16.
 */
public class Client {
    public static void main(String[] args) throws Exception{
        // 提取到被注解的方法Method，这里用到了反射的知识
        Method method = Class.forName("annotation.sample.OneClass").getDeclaredMethod("oneMethod");
        // 从Method方法中通过方法getAnnotation获得我们设置的注解
        Sample sampleAnnotation = method.getAnnotation(Sample.class);

        // 得到注解的俩参数
        System.out.println(sampleAnnotation.parameter1());
        System.out.println(sampleAnnotation.parameter2());
    }
}
