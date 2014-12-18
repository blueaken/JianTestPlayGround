package sourcecode.spring.aop.cglib;

/**
 * @author jianshen
 */
public class MyAOP {

    public void print(String name){
        System.out.println("Hello " + name);
    }

    public void write(String something){
        System.out.println("Write " + something);
    }
}
