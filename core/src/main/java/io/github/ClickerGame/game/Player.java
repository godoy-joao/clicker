package io.github.ClickerGame.game;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    public static String name;
    public static long level;
    public static double dps;
    public static double baseDamage;
    public static Map<String, Effect> effects = new HashMap<>();
    public static double damage = level * baseDamage;
    public static long prestigeLevel;
    public static long gold;

}
