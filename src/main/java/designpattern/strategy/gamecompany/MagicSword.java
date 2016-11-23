package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 11:48 AM
 */
public class MagicSword implements AttachStrategy{
    @Override
    public void attackTarget(Monster monster){
        int hitPoint = Math.random() < 0.5 ? 100 : 200;

        monster.notify(hitPoint);
    }
}
