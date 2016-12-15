package annotation.fruit;

import java.lang.annotation.*;

/**
 * 水果名称注解
* @author jianshen on 12/14/16
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}

