package annotation.fruit;

/**
 * Created by jianshen on 12/14/16.
 */

import java.lang.annotation.*;

/**
 * 水果颜色注解
 * @author jianshen on 12/14/16
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     * @author jianshen on 12/14/16
     *
     */
    public enum Color{ BULE,RED,GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;

}

