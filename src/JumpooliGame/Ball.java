package JumpooliGame;

import java.awt.*;

/**
 * Ball object.
 * Created by Aria Pahlavan on Apr 2016.
 */
public class Ball {
    private int x = 400;
    private int y = 25;
    private double dx = 0;  //initial sped in x direction
    private double dy = 0;  //initial sped in y direction
    private final int RADIUS = 20;
    private double gravity = 9.8;
    private final double ENERGY_LOSS = 1;
    private final double FRICTION = 0.95;
    private double dt = 0.2;
    private final double SPEED_LIMIT = 20;
    private double gameDy = -75;

    public Ball() {
    }

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getGravity() {
        return gravity;
    }

    public int getRADIUS() {
        return RADIUS;
    }

    public double getGameDy() {
        return gameDy;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Adds to left direction velocity if the speed limit won't be reached.
     */
    public void moveLeft() {
        if ( Math.abs(dx - 1) < SPEED_LIMIT ) {
            dx -= 1;
        }
    }


    /**
     * Adds to right direction velocity if the speed limit won't be reached.
     */
    public void moveRight() {
        if ( dx + 1 < SPEED_LIMIT ) {
            dx += 1;
        }
    }

    /**
     * Updates the position of the ball, as well as the x direction and y direction velocity.
     *
     * @param display
     */
    public void updateBallPosition(StartingPoint display) {
        if ( x + dx > display.getWidth() - RADIUS - 1 ) {
            x = display.getWidth() - RADIUS - 1;
            dx = -dx;
        }
        if ( x + dx < 0 + RADIUS ) {
            x = 0 + RADIUS;
            dx = -dx;
        } else
            x += dx;

        if ( y == display.getHeight() - RADIUS - 1 ) {
            dx *= FRICTION;
            if ( Math.abs(dx) < 0.5 ) dx = 0;
        }

        if ( y > display.getHeight() - RADIUS - 1 ) {
            y = display.getHeight() - RADIUS - 1;
            dy *= ENERGY_LOSS;
            if ( dy < 2 ) dy = 0;

            dy = gameDy;
        } else {

            //velocity formula: i.e. v = v0 + a*t
//                dy = dy + (int)(gravity*dt);
            dy += gravity * dt;

            //displacement formula: i.e. d = v0*t + 1/2*a*t^2
//                y = y + (int) (dy * dt + 0.5 * gravity * dt * dt);
            y += dy * dt + .5 * gravity * dt * dt;
        }
    }

    /**
     * Paints the ball on the screen
     *
     * @param g
     */
    public void paintBalls(Graphics g) {
        g.setColor(Color.cyan);
        g.fillOval(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2);
    }
}
