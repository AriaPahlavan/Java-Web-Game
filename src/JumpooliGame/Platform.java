package JumpooliGame;

import java.awt.*;
import java.util.Random;

/**
 * WebGame
 * Created by Aria Pahlavan on Apr 2016.
 */
public class Platform {
    private int dx, x, y, width, height;

    public Platform() {
        this.dx = -1;
        this.x = 300;
        this.y = 300;
        this.width = 120;
        this.height = 40;
    }

    public Platform(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    /**
     * Updates the position of the platform after it moves to the left.
     *
     * @param display
     */
    public void updatePlatform(StartingPoint display, Ball b) {
        x += dx;
        collisionAvoid(b);

        Random random = new Random();
        if ( x < 0 - width ) {
            x = display.getWidth() + random.nextInt(500);
            y = display.getHeight() - 40 - random.nextInt(400);
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
        double ballDx = b.getDx();
        double ballDy = b.getDy();
        int ballRadius = b.getRADIUS();

        if ( ballX + ballRadius > x && ballDx > 0 && ballX <= x + (width / 2) ) {
            if ( ballY + (ballRadius) > y && ballY < (y + height) && ballX + ballRadius / 2 < x ) {
                System.out.println("1) y = " + y + ", ball y = " + ballY + ",  Ball dx = " + ballDx);
                b.setX(x - ballRadius - 1);
                b.setDx(b.getDx() * -1);
                System.out.println(b.getDx());
            }
        }

        if ( ballY + ballRadius > y && ballDy > 0 && ballY <= y + (height / 2) ) {
            if ( ballX + (ballRadius) > x && ballX < (x + width) ) {
                b.setY(y - ballRadius - 1);
                b.setDy(new Ball().GAME_Dy);
            }
        }

        if ( ballX - ballRadius < x + width && ballDx < 0 && ballX > x + (width / 2) ) {
            if ( ballY + (ballRadius) > y && ballY < (y + height) && ballX - ballRadius / 2 > x + width ) {
                System.out.println("2) x = " + x + ", b.x = " + ballX + ",  b.dx = " + ballDx);
                b.setX(x + width + ballRadius + 1);
                b.setDx((b.getDx() * -1));
                System.out.println(b.getDx());
            }
        }


        if ( ballY - ballRadius < y + height && ballDy < 0 && ballY > y + (height / 2) ) {
            if ( ballX + (ballRadius) > x && ballX < (x + width) ) {
                b.setY(y + height + ballRadius + 1);
                b.setDy(b.getDy() * -1);

            }
        }


//        if ( ballY + ballRadius > y && ballY - ballRadius < y + height ) {
//            if ( ballX > x && ballX < x + width ) {
//                b.setY(y - ballRadius);
//                b.setDy(b.getGAME_Dy());
//            }
//        }
//
//        if ( ballX + ballRadius > x && ballX - ballRadius < x + width ) {
//            if ( ballY > y && ballY < y + height ) {
//                b.setDx(b.getDx() * -1);
//            }
//        }
    }

    /**
     * Paints the platform on the screen
     *
     * @param g
     */

    public void paintPlatform(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }
}
