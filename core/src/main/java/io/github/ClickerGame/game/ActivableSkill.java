package io.github.ClickerGame.game;

import java.util.List;

public abstract class ActivableSkill {

    private String name;
    private boolean active;
    private double cooldown;
    private long lastUsage;
    private long usageCount;
    private List<Effect> effects;

    public ActivableSkill(String name, boolean active, double cooldown, long lastUsage, long usageCount, List<Effect> effects) {
        this.name = name;
        this.active = active;
        this.cooldown = cooldown;
        this.lastUsage = lastUsage;
        this.usageCount = usageCount;
        this.effects = effects;
    }

    public abstract void activate();

    public ActivableSkill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getCooldown() {
        return cooldown;
    }

    public void setCooldown(double cooldown) {
        this.cooldown = cooldown;
    }

    public long getLastUsage() {
        return lastUsage;
    }

    public void setLastUsage(long lastUsage) {
        this.lastUsage = lastUsage;
    }

    public long getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(long usageCount) {
        this.usageCount = usageCount;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }
}
