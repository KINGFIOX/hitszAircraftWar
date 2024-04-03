package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;

import java.util.LinkedList;
import java.util.List;

/**
 * 抽象类
 */
public abstract class EnemyAircraft extends AbstractAircraft {

    /* ---------- ---------- 子弹 ---------- ---------- */

    /**
     * 子弹一次发射数量
     */
    protected int shootNum = 1; // FIXME CONFIG

    /**
     * 子弹伤害
     */
    protected int power = 10; // FIXME CONFIG

    /**
     * 子弹射击方向 (向上发射：1，向下发射：-1)
     */
    protected int direction = 1;


    @Override
    public List<BaseBullet> shoot() {
        return new LinkedList<>();
    }


    /* ---------- ---------- 分数 ---------- ---------- */

    // 敌人的分数（ 悬赏人头 ）
    private int score;

    public int getScore() {
        return this.score;
    }

    /* ---------- ---------- 构造函数 ---------- ---------- */


    public EnemyAircraft(int locationX, int locationY, int speedX, int speedY, int hp, int _score) {
        super(locationX, locationY, speedX, speedY, hp);
        this.score = _score;
    }

    /* ---------- ---------- 飞行一格 ---------- ---------- */


    /**
     * enemy
     */
    @Override
    public void forward() {
        super.forward();  // 调用 AbstractFlyingObject 的 forward
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT) {
            vanish();
        }
    }

}
