package sourcecode.spring.aop.javaproxy;

/**
 * @author jianshen
 */
public class MyAOP implements IMyAOP {
    public void print(String name){
        System.out.println("Hello " + name);
    }

    public void write(String something){
        System.out.println("Write " + something);
    }
}
