package designpattern.behavior.observer.push_model;

/**
 * Author: blueaken
 * Date: 3/1/16 10:02 PM
 */
public class ConcreteObserver implements Observer {
    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
        /**
         * 更新观察者的状态，使其与目标的状态保持一致
         */
        observerState = state;
        System.out.println("Observer 状态为："+observerState);
    }
}
