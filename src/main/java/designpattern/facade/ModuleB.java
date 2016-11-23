package designpattern.facade;

/**
 * Author: blueaken
 * Date: 2/26/16 2:59 PM
 */
public class ModuleB {
    public void testB(){
        System.out.println("调用ModuleB中的testB方法");
    }

    /**
     * 提供给子系统外部使用的方法
     */
    public void b1(){};

    /**
     * 子系统内部模块之间相互调用时使用的方法
     */
    public void b2(){};
    public void b3(){};
}
