package designpattern.behavior.observer.concept;

/**
 * Created by jianshen on 2/4/17.
 */
public class Observer implements IObserver{
    @Override
    public void update(Observable o) {
        System.out.println("New state is: " + ((Subject)o).getState());
    }
}
