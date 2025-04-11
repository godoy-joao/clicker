package io.github.ClickerGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextButton;

/**
 * First screen of the application. Displayed after the application is created.
 */
public class GameScreen implements Screen {

    private SpriteBatch spriteBatch;
    private Stage stage;
    private VisLabel counterLabel;
    private long counter = 0;
    private int clickValue = 1;


    @Override
    public void show() {
        spriteBatch = new SpriteBatch();
        stage = new Stage(new ScreenViewport(), spriteBatch);
        Gdx.input.setInputProcessor(stage);

        VisUI.load();
        Table table = new Table();
        table.setFillParent(true);
        table.center();

        counterLabel = new VisLabel("Pontos: 0");

        VisTextButton clickButton = new VisTextButton("clique aqui");
        clickButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                counter += clickValue;
                counterLabel.setText("Pontos: " + counter);
            }
        });

        VisTextButton upgradeButton = new VisTextButton("Upgrade: 50 pontos");
        upgradeButton.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               if (counter >= 50) {
                   counter -= 50;
                   clickValue +=1;
                   counterLabel.setText("Pontos: "+counter);
               }
           }
        });

        table.add(counterLabel).padBottom(20).row();
        table.add(clickButton).width(200).height(70).padBottom(20).row();
        table.add(upgradeButton).width(200).height(60);

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        stage.dispose();
        spriteBatch.dispose();
    }
}
