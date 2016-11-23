package designpattern.facade;

/**
 * Author: blueaken
 * Date: 2/26/16 2:59 PM
 */
public class ModuleC {
    public void testC(){
        System.out.println("调用ModuleC中的testC方法");
    }

    /**
     * 提供给子系统外部使用的方法
     */
    public void c1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    public void c2(){};
    public void c3(){};
}
