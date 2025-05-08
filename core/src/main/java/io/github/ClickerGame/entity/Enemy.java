package io.github.ClickerGame.entity;

import io.github.ClickerGame.manager.GameManager;
import io.github.ClickerGame.manager.ResourceManager;

import java.util.Random;

public class Enemy extends Entity {

    private Random r = new Random();
    public static String[] enemyList = {
            "cranio",
            "fantasma",
            "minhoca",
            "geleia",
            "morto-vivo"
    };

    public Enemy() {
        this.setName(enemyList[r.nextInt(enemyList.length)]);
        double lifeBase = (GameManager.getLevel() * 5);
        long lifeValue = (long) (lifeBase + (lifeBase * (r.nextDouble(lifeBase) + 1)));
        this.setMaxLife(lifeValue);
        this.setLife(getMaxLife());
        this.setBigEntity();
        this.setTexture(ResourceManager.getEnemyTexture(this.getName()));

    }

    @Override
    public void onKill() {

    }

}
