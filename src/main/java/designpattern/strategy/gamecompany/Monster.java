package designpattern.strategy.gamecompany;

/**
 * Author: blueaken
 * Date: 3/7/16 11:35 AM
 */
public class Monster {
    private int hp;
    private String name;

    public Monster(String name, int hp) {
        this.hp = hp;
        this.name = name;
    }

    public void notify(int hitPoints) {
        this.hp -= hitPoints;
        if (200 == hitPoints) {
            System.out.println("出现暴击！！！");
        }
        System.out.println("攻击成功！怪物" + name + "损失" + hitPoints + "HP");

        if (hp <= 0) {
            System.out.println("攻击成功! 怪物" + name + "已死");
        }
    }
}
