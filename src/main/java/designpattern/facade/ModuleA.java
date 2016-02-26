package designpattern.facade;

/**
 * Author: blueaken
 * Date: 2/26/16 2:59 PM
 */
public class ModuleA {
    public void testA(){
        System.out.println("调用ModuleA中的testA方法");
    }

    /**
     * 提供给子系统外部使用的方法
     */
    public void a1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    public void a2(){};
    public void a3(){};
}
