package edu.hitsz.shootstrategy;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;


import java.util.List;
import java.util.LinkedList;

public class CircleShootStrategy implements IShootStrategy {
    public List<BaseBullet> generateBullet(int getLocX, int getLocY, int getSpeedX, int getSpeedY, int getShootNum, int getDirect, int getPower, boolean isHero) {
        List<BaseBullet> res = new LinkedList<>();
        int y = getLocY + getDirect * 2;  // 初始y坐标，稍微偏移
        double angleStep = Math.PI / (getShootNum + 1); // 计算角度步长

        for (int i = 1; i <= getShootNum; i++) {
            double angle = angleStep * i; // 计算当前子弹的发射角度
            // 根据角度计算子弹的速度分量
            int speedX = (int) (Math.cos(angle) * getSpeedY) * getDirect; // 水平速度分量
            int speedY = (int) (Math.sin(angle) * getSpeedY) * getDirect; // 垂直速度分量

            // 根据角色类型创建子弹实例
            BaseBullet bullet;
            if (isHero) {
                bullet = new HeroBullet(getLocX, y, speedX, speedY, getPower);
            } else {
                bullet = new EnemyBullet(getLocX, y, speedX, speedY, getPower);
            }
            res.add(bullet); // 添加到结果列表
        }
        for (int i = 1; i <= getShootNum; i++) {
            double angle = angleStep * i; // 计算当前子弹的发射角度
            // 根据角度计算子弹的速度分量
            int speedX = (int) (Math.cos(angle) * getSpeedY) * (-getDirect); // 水平速度分量
            int speedY = (int) (Math.sin(angle) * getSpeedY) * (-getDirect); // 垂直速度分量

            // 根据角色类型创建子弹实例
            BaseBullet bullet;
            if (isHero) {
                bullet = new HeroBullet(getLocX, y, speedX, speedY, getPower);
            } else {
                bullet = new EnemyBullet(getLocX, y, speedX, speedY, getPower);
            }
            res.add(bullet); // 添加到结果列表
        }
        return res;
    }
}
