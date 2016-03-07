package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 11:47 AM
 */
public class IronSword implements AttachStrategy {
    @Override
    public void attackTarget(Monster monster){
        monster.notify(50);
    }
}
