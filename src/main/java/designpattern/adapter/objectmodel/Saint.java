package designpattern.adapter.objectmodel;

import designpattern.adapter.ruzhishen_classmodel.Monk;

/**
 * Author: blueaken
 * Date: 3/12/16 11:04 AM
 */
//Adapter
public abstract class Saint implements Monk {

    private Ruzhishen ruzhishen;

    public Saint(Ruzhishen ruzhishen) {
        this.ruzhishen = ruzhishen;
    }

    /**
     * 源类Adaptee没有方法sampleOperation2
     * 因此由适配器类需要补充此方法
     */
    public void eatVegen() {}
    public void readBible() {}
    public void practiceZen() {}

    /**
     * 源类Adaptee有方法sampleOperation1
     * 因此适配器类直接委派即可
     */
    public void fight() {
        this.ruzhishen.fight();
    }
    public String getName() {
        return null;
    }
}