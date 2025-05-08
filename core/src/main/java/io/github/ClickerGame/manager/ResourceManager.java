package io.github.ClickerGame.manager;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ResourceManager {

    public static TextureRegion getEnemyTexture(String enemyName) {
        try {
            Texture texture = new Texture("sprites/enemy/"+enemyName+".png");
            return new TextureRegion(texture,512,512);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
