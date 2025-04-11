package io.github.ClickerGame;

import com.badlogic.gdx.Game;
import io.github.ClickerGame.screens.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
