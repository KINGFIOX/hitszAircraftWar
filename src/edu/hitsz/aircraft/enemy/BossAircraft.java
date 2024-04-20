package edu.hitsz.aircraft.enemy;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.prop.BaseProp;
import edu.hitsz.propfactory.PropGenerator;
import edu.hitsz.shootstrategy.CircleShootStrategy;
import edu.hitsz.shootstrategy.StraightShootStrategy;

import java.util.LinkedList;
import java.util.List;

public class BossAircraft extends EnemyAircraft {

    public BossAircraft(int locationX, int locationY, int speedX, int speedY, int hp, int score) {
        super(locationX, locationY, speedX, speedY, hp, score);
        this.shootStrategy = new CircleShootStrategy();
    }

    @Override
    public List<BaseProp> award() {
        List<BaseProp> res = new LinkedList<>();
        BaseProp p;
        for (int i = 0; i < 3; i++) {
            p = PropGenerator.generateProp(this.locationX, this.locationY);
            if (p != null) {
                res.add(p);
            }
        }
        return res;
    }

    public void forward() {
        locationX += speedX;
        locationY += speedY;

        if (locationX <= 0 || locationX >= Main.WINDOW_WIDTH) {
            // 横向超出边界后反向
            speedX = -speedX;
        }
        if (locationY <= 0 || locationY >= Main.WINDOW_HEIGHT / 4) {
            // 横向超出边界后反向
            speedY = -speedY;
        }
    }


    // 重写 boss 的走位
//    @Override
//    public void forward() {
//        locationX += this.random.nextInt(2 * speedX) - speedX;
//        locationX += this.random.nextInt(speedY);
//        // 这个就有点像是: 子弹撞到边界以后会反弹
//        // 不过我就寻思着: 应该没有 enemy 会横向走的吧
//        if (locationX <= 0 || locationX >= Main.WINDOW_WIDTH) {
//            // 横向超出边界后反向
//            speedX = -speedX;
//        }
//    }


    /**
     * @return
     * @brief boss 重写 boss 弹道
     */
    @Override
    public List<BaseBullet> shoot() {
        int bulletSpeed = 4;
        return shootStrategy.generateBullet(this.getLocationX(), this.getLocationY(), bulletSpeed, bulletSpeed,
                20, direction, power, false);
    }


}