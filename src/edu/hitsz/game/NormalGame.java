package edu.hitsz.game;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.ImageManager;
import edu.hitsz.config.CONFIG;
import edu.hitsz.observe.BossNotifier;
import edu.hitsz.observe.EnemyAircraftGenerator;
import edu.hitsz.observe.PropGenerator;

import java.lang.reflect.Field;

public class NormalGame extends AbstractGame {

    @Override
    protected void initBackground() {
        this.bg = ImageManager.BACKGROUND_IMAGE4;
    }

    @Override
    protected void initEnemyGen() {
        int mob_hp = 30;
        int maxScore_mob = 10;
        int elite_hp = 100;
        int maxScore_elite = 30;
        int elite_plus_hp = 100;
        int maxScore_elite_plus = 50;
        this.enemyGenerator = new EnemyAircraftGenerator(mob_hp, maxScore_mob, elite_hp, maxScore_elite, elite_plus_hp, maxScore_elite_plus);
    }

    @Override
    protected void initHero() {
        int hp = 1000;
        int shootNum = 8;
        int power = 50;

        this.heroAircraft = new HeroAircraft(
                CONFIG.Windows.WINDOW_WIDTH / 2,
                CONFIG.Windows.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight(),
                0, 0, hp);

        // java 没有 友元，太难过了
        try {
            Field shootNumField = HeroAircraft.class.getDeclaredField("shootNum");
            shootNumField.setAccessible(true);
            shootNumField.set(this.heroAircraft, shootNum);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field powerField = HeroAircraft.class.getDeclaredField("power");
            powerField.setAccessible(true);
            powerField.set(this.heroAircraft, power);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initBossNotifier() {
        int hp = 400;
        this.bossNotifier = new BossNotifier(hp);
    }


    @Override
    protected void initPropGen() {
        int maxScore = 100;
        int dura_bullet = 5;
        int dura_bullet_plus = 5;
        int probability_blood = 25;
        int probability_bomb = 25;
        int probability_bullet = 25;
        int probability_bullet_plus = 25;
        int maxBlood = 250;
        int maxBomb = 25;
        this.propGenerator = new PropGenerator(
                maxScore,
                maxBlood,
                probability_blood,
                maxBomb,
                probability_bomb,
                dura_bullet,
                probability_bullet,
                dura_bullet_plus,
                probability_bullet_plus
        );
    }

    @Override
    protected void initConfig() {

        /* 随着时间，难度增加 */
        CONFIG.Enemy.MOB_HP_UPGRADE = 5;
        CONFIG.Enemy.ELITE_HP_UPGRADE = 10;
        CONFIG.Enemy.ELITE_PLUS_HP_UPGRADE = 15;
        CONFIG.Enemy.BOSS_HP_UPGRADE = 50;

        CONFIG.Enemy.BOSS_SHOOT_NUMBER = 20;
        CONFIG.Enemy.BOSS_EVERY_SCORE = 2000;
        CONFIG.Enemy.BOSS_DROP_NUMBER = 3;

        CONFIG.Enemy.ENEMY_BULLET_POWER = 10;


        /* 这个一定是这样的 */
        CONFIG.Game.speedX[0] = -2;
        CONFIG.Game.speedX[1] = 2;
        CONFIG.Game.speedY[0] = 5;
        CONFIG.Game.speedY[1] = 14;
    }


}
