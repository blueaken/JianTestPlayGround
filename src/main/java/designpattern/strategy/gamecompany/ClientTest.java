package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 12:03 PM
 */
public class ClientTest {
    public static void main(String[] args) {
        //生成怪物
        Monster monster1 = new Monster("小怪A", 50);
        Monster monster2 = new Monster("小怪B", 50);
        Monster monster3 = new Monster("关主", 200);
        Monster monster4 = new Monster("最终Boss", 1000);

        //生成角色
        Role role = new Role();

        //木剑攻击
        role.setWeapon(new WoodSword());
        role.attack(monster1);

        //铁剑攻击
        role.setWeapon(new IronSword());
        role.attack(monster2);
        role.attack(monster3);

        //魔剑攻击
        role.setWeapon(new MagicSword());
        role.attack(monster3);
        role.attack(monster4);
        role.attack(monster4);
        role.attack(monster4);
        role.attack(monster4);
        role.attack(monster4);
        role.attack(monster4);
        role.attack(monster4);
    }
}
