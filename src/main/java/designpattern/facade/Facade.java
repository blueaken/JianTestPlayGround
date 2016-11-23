package designpattern.facade;

/**
 * Author: blueaken
 * Date: 2/26/16 3:01 PM
 */
public class Facade {
    ModuleA a = new ModuleA();
    ModuleB b = new ModuleB();
    ModuleC c = new ModuleC();

    //示意方法，满足客户端需要的功能
    public void test(){
        a.testA();
        b.testB();
        c.testC();
    }

    /**
     * 下面这些是A、B、C模块对子系统外部提供的方法
     */
    public void a1(){
        a.a1();
    }
    public void b1(){
        b.b1();
    }
    public void c1(){
        c.c1();
    }
}
