package io.github.ClickerGame.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class Entity extends Actor {

    private transient Long maxLife;
    private transient Long life;
    private transient Double spawnChance;
    private TextureRegion texture;
    private boolean bigEntity;
    private int timesKilled;
    private String name;

    public Entity() {
    addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            onClick();
        }
    });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(getTexture(), getX(), getY(), getWidth(), getHeight());
    }

    public Long getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(Long maxLife) {
        this.maxLife = maxLife;
    }

    public Long getLife() {
        return life;
    }

    public void setLife(Long life) {
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

    public void setBigEntity() {
        this.bigEntity = (MathUtils.random(1000) <= 10);
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

    public Long getReducedHp(long damage){
        return getLife() - damage;
    }

    public abstract void onKill();

    public abstract void onClick();
}
