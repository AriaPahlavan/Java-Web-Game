package JumpooliGame;

import java.awt.*;

/**
 * Ball
 * Created by Aria Pahlavan on Apr 2016.
 */
public class Ball {
    int x = 400;
    int y = 25;
    double dx = 15;  //initial sped in x direction
    double dy = 0;  //initial sped in y direction
    int radius = 20;
    double gravity = 9.8;
    double energyloss = 0.65;
    double xFriction = 0.95;
    double dt = 0.2;

    public void updateBallPosition(StartingPoint display) {
        if ( x + dx > display.getWidth() - radius - 1 ) {
            x = display.getWidth() - radius - 1;
            dx = -dx;
        }
        if ( x + dx < 0 + radius ) {
            x = 0 + radius;
            dx = -dx;
        } else
            x += dx;

        if ( y == display.getHeight() - radius - 1 ) {
            dx *= xFriction;
            if ( Math.abs(dx) < 0.5 ) dx = 0;
        }

        if ( y > display.getHeight() - radius - 1 ) {
            y = display.getHeight() - radius - 1;
            dy *= energyloss;
            if ( dy < 2 ) dy = 0;

            dy = -dy;
        } else {

            //velocity formula: i.e. v = v0 + a*t
//                dy = dy + (int)(gravity*dt);
            dy += gravity * dt;

            //displacement formula: i.e. d = v0*t + 1/2*a*t^2
//                y = y + (int) (dy * dt + 0.5 * gravity * dt * dt);
            y += dy * dt + .5 * gravity * dt * dt;
        }
    }

    public void paintBalls(Graphics g) {
        g.setColor(Color.cyan);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
