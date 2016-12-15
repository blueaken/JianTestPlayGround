package annotation.sample;

/**
 * Created by jianshen on 12/14/16.
 */

import java.lang.annotation.*;

/**
 * 定义一个注解
 */
@Target(ElementType.METHOD) // 这是一个对方法的注解，还可以是包、类、变量等很多东西
@Retention(RetentionPolicy.RUNTIME) // 保留时间，一般注解就是为了框架开发时代替配置文件使用，JVM运行时用反射取参数处理，所以一般都为RUNTIME类型
@Documented // 用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化
public @interface Sample {

    // 定义注解的参数，类型可以为基本类型以及String、Class、enum、数组等，default为默认值
    String parameter1() default "";
    int parameter2() default -1;

}
