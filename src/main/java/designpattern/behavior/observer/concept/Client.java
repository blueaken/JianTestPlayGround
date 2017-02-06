package designpattern.behavior.observer.concept;

/**
 * Created by jianshen on 2/4/17.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject(3);

        Observer observer1 = new Observer();
        subject.attach(observer1);

        subject.changeState(5);
    }
}
