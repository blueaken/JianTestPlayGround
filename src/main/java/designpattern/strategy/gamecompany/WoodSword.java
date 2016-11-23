package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 11:45 AM
 */
public class WoodSword implements AttachStrategy {

    @Override
    public void attackTarget(Monster monster){
        monster.notify(20);
    }
}
