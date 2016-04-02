package JumpooliGame;

import java.applet.Applet;
import java.awt.*;


public class WebGame extends Applet implements Runnable {

    int x = 1;
    int y = 1;
    int dx = 4;
    int dy = 3;
    int radius = 30;


    private Image i;
    private Graphics doubleG;

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
        while ( true ) {
            x += dx;
            y += dy;
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
    public void update(Graphics g) {
        if ( i == null ) {
            i = createImage(this.getWidth(), this.getHeight());
            doubleG = i.getGraphics();
        }

        doubleG.setColor(getBackground());
        doubleG.fillRect(0, 0, this.getWidth(), this.getHeight());

        doubleG.setColor(getForeground());
        paint(doubleG);

        g.drawImage(i, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}

