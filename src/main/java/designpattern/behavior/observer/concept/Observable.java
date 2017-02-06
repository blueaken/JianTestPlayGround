package designpattern.behavior.observer.concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianshen on 2/4/17.
 */
public abstract class Observable {
    private List<IObserver> observers = new ArrayList<>();

    public void attach(IObserver o) {
        if (!observers.contains(o)) {
            observers.add(o);
            System.out.println("Observer attached.");
        }
    }

    public void detach(IObserver o) {
        if (observers.contains(o)) {
            observers.remove(o);
            System.out.println("Observer detached.");
        }
    }

    public void notifyObservers() {
        for (IObserver o : observers) {
            o.update(this);
        }
    }
}
