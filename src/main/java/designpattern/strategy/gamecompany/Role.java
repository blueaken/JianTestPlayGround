package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 11:59 AM
 */
public class Role {
    //持有一个具体的策略对象
    private AttachStrategy weapon;

    /**
     * 构造函数，传入一个具体的策略对象或用setter更加灵活
     */
    public Role() {
    }

    public AttachStrategy getWeapon() {
        return weapon;
    }

    public void setWeapon(AttachStrategy weapon) {
        this.weapon = weapon;
    }

    /**
     * 策略方法
     */
    public void attack(Monster monster) {
        this.weapon.attackTarget(monster);
    }
}
