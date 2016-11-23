package designpattern.visitor.model;

/**
 * Author: blueaken
 * Date: 2/12/16 11:56 AM
 */
public class BlackHorse extends Horse {
    @Override
    public void eat() {
        System.out.println("黑马吃草");
    }
}
