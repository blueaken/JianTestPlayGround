package designpattern.behavior.observer.concept;

/**
 * Created by jianshen on 2/4/17.
 */
public class Subject extends Observable{
    private int state;

    public Subject(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public void changeState(int newState) {
        this.state = newState;
        notifyObservers();
    }
}
