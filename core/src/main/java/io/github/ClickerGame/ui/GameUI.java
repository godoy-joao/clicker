package io.github.ClickerGame.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.tabbedpane.Tab;
import com.kotcrab.vis.ui.widget.tabbedpane.TabbedPane;
import io.github.ClickerGame.manager.GameManager;

import static com.kotcrab.vis.ui.widget.tabbedpane.TabbedPane.*;

public class GameUI {
    private static Stage stage;
    private VisUI visUI;
    private VisTable root;
    private Label levelLabel;
    private Label monsterHpLabel;
    private TabbedPane tabbedPane;
    private VisTable enemy;

    public GameUI(SpriteBatch batch, Viewport viewport) {
        VisUI.load();
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);
        levelLabel = new VisLabel();
        monsterHpLabel = new VisLabel();
        root = new VisTable();
        root.setFillParent(true);
        buildLayout(viewport);
        stage.addActor(root);
    }


    private void createMonsterDisplay() {
        float centerX = (stage.getViewport().getWorldWidth() - GameManager.currentEnemy.getWidth()) / 2f;
        float centerY = (stage.getViewport().getWorldHeight() - GameManager.currentEnemy.getHeight()) / 2f;

        GameManager.currentEnemy.setPosition(centerX, centerY);

        stage.addActor(GameManager.currentEnemy);
    }

    private void createSidebarTabs() {
        root.add().width(250).top();

        tabbedPane = new TabbedPane();
        Tab itemsTab = new Tab(false, false) {
            @Override
            public String getTabTitle() {
                return "Itens";
            }

            @Override
            public Table getContentTable() {
                VisTable content = new VisTable();
                content.add(new VisLabel("Lista de Itens")).top().left();
                // Aqui você adiciona botões de compra, etc.
                return content;
            }
        };

        Tab heroesTab = new Tab(false, false) {
            @Override
            public String getTabTitle() {
                return "Heróis";
            }

            @Override
            public Table getContentTable() {
                VisTable content = new VisTable();
                content.add(new VisLabel("Lista de Heróis")).top().left();
                // Aqui você adiciona botões de compra, etc.
                return content;
            }
        };

        tabbedPane.add(itemsTab);
        tabbedPane.add(heroesTab);

        root.add(tabbedPane.getTable()).right().top();
    }

    public void updateUI() {

        levelLabel.setText("Fase: " + GameManager.getLevel());
        monsterHpLabel.setText("Vida: " + GameManager.currentEnemy.getLife() + " / " + GameManager.currentEnemy.getMaxLife());
        enemy.removeActorAt(0, true);
        enemy.add(GameManager.currentEnemy);
    }

    public void draw() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        VisUI.dispose();
    }

    private void buildLayout(Viewport viewport) {
        VisTable root = new VisTable();
        root.setFillParent(true);

        // ---------- TOP BAR ----------
        VisTable topBar = new VisTable();

        topBar.add(levelLabel).expandX();

        root.row().top().expandX();
        root.add(topBar).colspan(10).fillX().center();
        root.add().height((float) viewport.getScreenHeight() / 5).width(0);

        // ---------- MIDDLE BAR ----------
        VisTable leftPane = new VisTable();
        leftPane.add(new VisLabel("Esquerda")).left();

        enemy = new VisTable();
        enemy.add(GameManager.currentEnemy);

        VisTable rightPane = new VisTable();
        rightPane.add(new VisLabel("Direita")).right();

        VisTable middleSize = new VisTable();

        root.row().expand().fill();

        root.add(middleSize).width(0).height(((float) viewport.getScreenHeight() / 5) * 3);
        root.add(leftPane).width(viewport.getWorldWidth() * 0.25f);
        root.add(enemy).width(viewport.getWorldWidth() * 0.50f);
        root.add(rightPane).width(viewport.getWorldWidth() * 0.25f);

        // ---------- BOTTOM BAR ----------
        VisTable bottomBar = new VisTable();
        bottomBar.add(monsterHpLabel).expandX().center();
        root.row().bottom().expandX().padTop(10);
        root.add().height((float) viewport.getScreenHeight() / 5).width(0);
        root.add(bottomBar).colspan(3).fillX().top();


        stage.addActor(root);
    }

    public static Stage getStage() {
        return stage;
    }
}
