package JumpooliGame;

import java.applet.Applet;
import java.awt.*;


public class StartingPoint extends Applet implements Runnable {

    private Image i;
    private Graphics doubleG;

    @Override
    public void init() {
        setSize(800, 800);
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

    }
}

