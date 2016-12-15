package annotation.sample;

/**
 * Created by jianshen on 12/14/16.
 * 一个用到了自定义的注解的类
 */
public class OneClass {
    @Sample(parameter1="YES", parameter2=10000)
    public void oneMethod () {
    }
}
