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
    public void init() {
        setSize(400, 400);
        setBackground(Color.BLACK);
    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

