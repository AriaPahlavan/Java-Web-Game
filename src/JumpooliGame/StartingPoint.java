package JumpooliGame;

import java.applet.Applet;
import java.awt.*;


public class StartingPoint extends Applet implements Runnable {

    Ball b;
    Ball b2;
    private Image i;
    private Graphics doubleG;

    @Override
    public void init() {
        b = new Ball();
        b2 = new Ball(250, 250);
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
            b.updateBallPosition(this);
            b2.updateBallPosition(this);

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
        b.paintBalls(g);
        b2.paintBalls(g);
    }
}

