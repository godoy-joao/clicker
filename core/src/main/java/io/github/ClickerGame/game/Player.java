package io.github.ClickerGame.game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    public static String name;
    public static long level;
    public static Long dps;
    public static Long baseDamage;
    public static Map<String, Effect> effects = new HashMap<>();
    public static Long damage;
    public static long prestigeLevel;
    public static long gold;

    public static Long getDamage() {
        return 2L;
    }

}
