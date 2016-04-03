package JumpooliGame;

import java.awt.*;
import java.util.Random;

/**
 * WebGame
 * Created by Aria Pahlavan on Apr 2016.
 */
public class Item {

    private int x, y, dx;
    private final int RADIUS = 10;

    public Item() {
        this.dx = -2;
        this.x = 0;
        Random r = new Random();
        this.y = r.nextInt(400) + RADIUS;
    }

    public Item(int x) {
        this();
        this.x = x;
    }

    /**
     * Updates the position of the item after it moves to the left.
     *
     * @param display
     */
    public void updatePlatform(StartingPoint display, Ball b) {
        x += dx;
        collisionAvoid(b);

        Random random = new Random();
        if ( x < 0 - RADIUS ) {
            x = display.getWidth() + 2000 + random.nextInt(300);
//            y += random.nextInt(80);
        }
    }

    /**
     * Ensures that we void all collisions of balls with any platform.
     *
     * @param b
     */
    private void collisionAvoid(Ball b) {
        int ballY = b.getY();
        int ballX = b.getX();
        int ballRadius = b.getRADIUS();

        if ( ballY + ballRadius > y && ballY - ballRadius < y + height ) {
            if ( ballX > x && ballX < x + width ) {
                b.setY(y - ballRadius);
                b.setDy(b.getGameDy());
            }
        }

        if ( ballX + ballRadius > x && ballX - ballRadius < x + width ) {
            if ( ballY > y && ballY < y + height ) {
                b.setDx(b.getDx() * -1);
            }
        }
    }

    /**
     * Paints the item on the screen
     *
     * @param g
     */
    public void paintPlatform(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
    }
}
