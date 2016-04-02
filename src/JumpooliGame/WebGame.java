package JumpooliGame;

import java.applet.Applet;
import java.awt.*;


public class WebGame extends Applet implements Runnable {

    int x = 1;
    int y = 1;
    int dx = 4;
    int dy = 3;
    int radius = 30;


    @Override
    public void run() {
        /**
         *
         * @Param
         */

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

