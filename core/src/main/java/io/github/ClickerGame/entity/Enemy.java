package io.github.ClickerGame.entity;

import com.badlogic.gdx.Game;
import io.github.ClickerGame.game.Player;
import io.github.ClickerGame.manager.GameManager;
import io.github.ClickerGame.manager.ResourceManager;
import io.github.ClickerGame.ui.GameUI;


import java.util.Random;

public class Enemy extends Entity {

    public static String[] enemyList = {
            "cranio",
            "fantasma",
            "minhoca",
            "geleia",
            "morto-vivo"
    };

    public Enemy() {
        super();
        Random r = new Random();
        this.setName(enemyList[r.nextInt(enemyList.length)]);
        double lifeBase = (GameManager.getLevel() * 5);
        long lifeValue = (long) (lifeBase + (lifeBase * (r.nextDouble(lifeBase) + 1)));
        this.setMaxLife(lifeValue);
        this.setLife(getMaxLife());
        this.setBigEntity();
        this.setTexture(ResourceManager.getEnemyTexture(this.getName()));
        this.setSize(400, 400);

        this.setVisible(true);

    }

    @Override
    public void onKill() {
        Player.gold += 5;
        removeListener(getListeners().first());
        GameManager.getNewEnemy();
        GameManager.setLevel(GameManager.getLevel() + 1);
    }

    @Override
    public void onClick() {
        setLife(getReducedHp(Player.getDamage()));
        if (getLife() <= 0) {
            onKill();
        }
    }

}
