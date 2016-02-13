package designpattern.visitor.model;

/**
 * Author: blueaken
 * Date: 2/12/16 11:56 AM
 */
public class WhiteHorse extends Horse {
    @Override
    public void eat() {
        System.out.println("白马吃草");
    }
}
