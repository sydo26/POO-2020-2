package objects;

import game.models.entity.Player;
import game.util.DataGameGraphics;
import game.util.GameGraphics;

public class BallPlayer extends Player {

    private double defaultSize;

    private double speedX;
    private double speedY;

    public BallPlayer(String name, String displayName, double x, double y, double size) {
        super(name, displayName, x, y, size, size);
        this.defaultSize = size;
        this.speedX = 0;
        this.speedY = 0;
    }

    @Override
    public void update(DataGameGraphics data) {
        this.speedX = ((data.mouseX() - position.x) / 80);
        this.speedY = ((data.mouseY() - position.y) / 80);

        double posX = position.x != data.mouseX() ? position.x + speedX : data.mouseX();
        double posY = position.y != data.mouseY() ? position.y + speedY : data.mouseY();

        size.w = position.x != data.mouseX()
                ? defaultSize + Math.min(Math.abs((speedX + speedY) * 10), defaultSize * 1.1)
                : defaultSize;
        size.h = defaultSize;

        position.x = posX;
        position.y = posY;

    }

    @Override
    public void draw(GameGraphics g) {

        g.fill((int) Math.floor(Math.min(Math.abs(speedX * 100), 255)),
                (int) Math.floor(Math.min(Math.abs(speedY * 100), 255)),
                (int) Math.floor(Math.min(Math.abs(speedX + speedY) * 100, 255)));
        g.ellipse(position.x, position.y, size.w, size.h, g.mouseX(), g.mouseY());
    }

}
