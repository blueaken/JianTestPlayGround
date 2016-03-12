package designpattern.adapter.objectmodel;

import designpattern.adapter.ruzhishen_classmodel.Saint;

/**
 * Author: blueaken
 * Date: 3/12/16 10:56 AM
 */
//Adaptee
public class Ruzhishen extends Saint {
    public void fight() {
        //拳打镇关西；
        //大闹五台山；
        //大闹桃花村；
        //火烧瓦官寺；
        //倒拔垂杨柳；
    }

    public String getName(){
        return "鲁智深";
    }
}
