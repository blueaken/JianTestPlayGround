package designpattern.command.basemodel;

/**
 * Author: blueaken
 * Date: 3/3/16 10:04 PM
 */
public class Receiver {
    /**
     * 真正执行命令相应的操作
     */
    public void action(){
        System.out.println("执行操作");
    }
}
