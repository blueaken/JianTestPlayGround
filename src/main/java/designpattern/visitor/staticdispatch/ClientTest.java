package designpattern.visitor.staticdispatch;

import designpattern.visitor.model.BlackHorse;
import designpattern.visitor.model.Horse;
import designpattern.visitor.model.WhiteHorse;

/**
 * Author: blueaken
 * Date: 2/12/16 11:56 AM
 */
public class ClientTest {
    public void ride(Horse h){
        System.out.println("骑马");
    }

    public void ride(WhiteHorse wh){
        System.out.println("骑白马");
    }

    public void ride(BlackHorse bh){
        System.out.println("骑黑马");
    }

    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();
        ClientTest mozi = new ClientTest();
        mozi.ride(wh);
        mozi.ride(bh);
    }

}
