package io.github.ClickerGame.manager;

import io.github.ClickerGame.entity.Enemy;
import io.github.ClickerGame.entity.Hero;
import io.github.ClickerGame.entity.Item;
import io.github.ClickerGame.game.DamageSource;

import java.util.List;
import java.util.Map;

public class GameManager {

    public static List<Item> playerItems;
    public static List<Hero> playerHeroes;
    public static Enemy currentEnemy;
    public static Map<String, DamageSource> damageSourceList;
    private static long level;


    public static long getLevel() {
        return level;
    }
    public static void setLevel(long newLevel){
        level = newLevel;
    }
    public static void skipLevels(long skips) {
        level +=skips;

    }
}
