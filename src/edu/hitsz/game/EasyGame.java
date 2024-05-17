package edu.hitsz.game;

import edu.hitsz.application.ImageManager;
import edu.hitsz.observe.EnemyAircraftGenerator;
import edu.hitsz.observe.PropGenerator;

public class EasyGame extends AbstractGame {
    @Override
    protected void initBackground() {
        this.bg = ImageManager.BACKGROUND_IMAGE2;
    }

    @Override
    protected void initEnemyGen() {
        int mob_hp = 30;
        int elite_hp = 100;
        int elite_plus_hp = 100;
        this.enemyGenerator = new EnemyAircraftGenerator(mob_hp, elite_hp, elite_plus_hp);
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
}
