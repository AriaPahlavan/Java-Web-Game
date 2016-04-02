package JumpooliGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StartingPoint extends Applet implements Runnable, KeyListener {

    Ball b;
    Ball b2;
    private Image i;
    private Graphics doubleG;

    @Override
    public void init() {
        setSize(800, 800);
        setBackground(Color.BLACK);

        addKeyListener(this);
    }

    @Override
    public void start() {
        b = new Ball();
        b2 = new Ball(250, 250);
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

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                b.moveRight();
                break;
            case KeyEvent.VK_LEFT:
                b.moveLeft();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}

