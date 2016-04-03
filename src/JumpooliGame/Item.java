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
        this.dx = -1;
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
    public void updateItem(StartingPoint display, Ball b) {
        x += dx;
        collisionAvoid(b);

        Random random = new Random();
        if ( x < 0 - RADIUS ) {
            x = display.getWidth() + 2000 + random.nextInt(300);
            y = display.getHeight() - 40 - random.nextInt(400);
        }
    }

    /**
     * Ensures that we void all collisions of balls with any platform.
     *
     * @param ball
     */
    private void collisionAvoid(Ball ball) {
        int ballY = ball.getY();
        int ballX = ball.getX();
        int ballRadius = ball.getRADIUS();
        int a = x - ballX;
        int b = y - ballY;
        boolean hasCollided = ((double) (ballRadius + RADIUS) > Math.sqrt((double) a * a + (double) b * b));

        if ( hasCollided ) {
            performPowerUp();
            x = RADIUS * -1;
            y = RADIUS * -1;
        }
    }

    private void performPowerUp() {

    }

    /**
     * Paints the item on the screen
     *
     * @param g
     */
    public void paintItem(Graphics g) {
        g.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
    }
}
