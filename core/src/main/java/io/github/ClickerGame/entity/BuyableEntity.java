package io.github.ClickerGame.entity;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class BuyableEntity {

    private String name;
    private String description;
    private transient Double value;
    private Integer level;
    private TextureRegion texture;
    private Double baseValue;

    public Double setValue() {
        Double value = 0.0;


        return 1.0;
    }

}
