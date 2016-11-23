package designpattern.visitor.dynamicdispatch;

import designpattern.visitor.model.BlackHorse;
import designpattern.visitor.model.Horse;
import designpattern.visitor.model.WhiteHorse;

/**
 * Author: blueaken
 * Date: 2/12/16 12:03 PM
 */
public class ClientTest {

    public static void main(String[] args) {
        Horse wh = new WhiteHorse();
        Horse bh = new BlackHorse();

        wh.eat();
        bh.eat();
    }
}
