package io.github.ClickerGame.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Entity extends Actor {

    private transient Double maxLife;
    private transient Double life;
    private transient TextureRegion texture;
    private boolean bigEntity;
    private int timesKilled;
    private String name;

    public Entity() {

    }

    public Double getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Double maxLife) {
        this.maxLife = maxLife;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public void setTexture(TextureRegion texture) {
        this.texture = texture;
    }

    public boolean isBigEntity() {
        return bigEntity;
    }

    public void setBigEntity(boolean bigEntity) {
        this.bigEntity = bigEntity;
    }

    public int getTimesKilled() {
        return timesKilled;
    }

    public void setTimesKilled(int timesKilled) {
        this.timesKilled = timesKilled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
