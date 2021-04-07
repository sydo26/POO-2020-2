package scenes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.interfaces.SceneManager;
import game.models.Scene;
import game.util.DataGameGraphics;
import game.util.GameGraphics;
import game.util.Vector2D;
import objects.BallMonster;
import objects.BallPlayer;

import java.awt.geom.*;
import java.awt.*;

public class GameRunning extends Scene {

    double points;

    BallPlayer player;
    List<BallMonster> monsters;

    int idMonster = 0;

    @Override
    public void setup(GameGraphics g) {
        this.monsters = new ArrayList<>();

        this.points = 0;
        this.player = new BallPlayer("sydo26", "Sydo26", g.getScreenSize().getWidth() / 2,
                g.getScreenSize().getHeight() / 2, 50);
        g.frameRate(10);
        g.shapeCenter(true);
    }

    @Override
    public void update(DataGameGraphics data) {

        // System.out.println(monsters.size());
        this.player.update(data);

        if (monsters.size() < 20) {
            double size = 30;
            double x = (new Random()).nextInt((int) data.width());
            double y = (new Random()).nextInt((int) data.height() / 2);

            BallMonster monster = new BallMonster("monster" + idMonster, "Monster " + idMonster++, x, -y, size);
            monster.setTargetPlayer(this.player);

            this.monsters.add(monster);
        }

        List<BallMonster> removeMonsters = new ArrayList<>();
        for (BallMonster m : monsters) {

            if (!m.isAlive()) {
                removeMonsters.add(m);
            } else {
                m.update(data);
            }
        }

        for (BallMonster m : removeMonsters) {
            monsters.remove(m);
        }

    }

    private double angle;

    private double x = 200;
    private double y = 200;
    private double width = 100;
    private double height = 50;

    @Override
    public void draw(GameGraphics g, SceneManager manager) {
        // g.background(Color.DARK_GRAY);

        // if (g.collideEllipseAndPoint(g.mouseDraggedX(), g.mouseDraggedY(), x, y,
        // width, height)) {

        // this.y = g.mouseDraggedY();
        // this.x = g.mouseDraggedX();

        // }

        // if (g.collideEllipseAndEllipse(x, y, width, height, g.width() / 2, g.height()
        // / 2, 100, 200)) {
        // g.fill(Color.RED);
        // }
        // g.ellipse(g.width() / 2, g.height() / 2, 100, 200);
        // g.fill(100, 10, 155);
        // g.ellipse(x, y, width, height);

        this.angle += 0.01;
        Vector2D pos = Vector2D.getRotatePosition(g.mouseX() - (g.width() / 2), g.mouseY() - (g.height() / 2), angle);

        // if (g.collideEllipseAndPoint(pos.x, pos.y, 0, 0, 200, 100)) {
        // g.fill(150, 100, 100);
        // }

        // g.translate(g.width() / 2, g.height() / 2);
        // g.rotate(angle);
        // g.ellipse(0, 0, 200, 100);
        // g.rotate(-angle);
        // g.translate(-g.width() / 2, -g.height() / 2);

        for (BallMonster monster : monsters)
            monster.draw(g);

        this.player.draw(g);

    }

}
