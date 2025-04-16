package io.github.ClickerGame.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class BuyableEntity extends Actor {

    private String name;
    private String description;
    private transient Double value;
    private Integer level;
    private TextureRegion texture;
    private Double baseValue;

    public Double setValue() {
        value = baseValue * (level * 1.33);

        return 1.0;
    }

}
