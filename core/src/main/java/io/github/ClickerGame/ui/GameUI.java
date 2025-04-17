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
    private Stage stage;
    private VisUI visUI;
    private VisTable root;
    private Label levelLabel;
    private Label monsterHpLabel;
    private TabbedPane tabbedPane;

    public GameUI(SpriteBatch batch, Viewport viewport) {
        VisUI.load();
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        root = new VisTable();
        root.setFillParent(true);
        stage.addActor(root);

        createTopBar();
        createMonsterDisplay();
        createSidebarTabs();
    }

    private void createTopBar() {
        VisTable topBar = new VisTable();
        topBar.top().pad(10);

        levelLabel = new VisLabel("Fase: 1");
        monsterHpLabel = new VisLabel("Vida: 100 / 100");

        topBar.add(levelLabel).left().padRight(20);
        topBar.add(monsterHpLabel).left();

        root.row();
        root.add(topBar).expandX().top().colspan(2);
    }

    private void createMonsterDisplay() {
        root.row();

        root.add().expand().fill();
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

    public void updateUI( int currentHp, int maxHp) {
        levelLabel.setText("Fase: " + GameManager.);
        monsterHpLabel.setText("Vida: " + currentHp + " / " + maxHp);
    }

    public void draw() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
        VisUI.dispose();
    }

    public Stage getStage() {
        return stage;
    }
}
