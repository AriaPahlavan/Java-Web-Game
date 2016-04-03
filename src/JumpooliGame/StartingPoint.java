package JumpooliGame;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class StartingPoint extends Applet implements Runnable, KeyListener {

    Ball b;
    Platform[] p = new Platform[7];
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

        Random r = new Random();
        for ( int i = 0; i < p.length; i++ ) {
            p[i] = new Platform(getWidth() + 200 * r.nextInt(7), getHeight() - 40 - r.nextInt(400));
        }
        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        while ( true ) {
            for ( Platform platform : p )
                platform.updatePlatform(this, b);
            b.updateBallPosition(this);

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
        for ( Platform platform : p )
            platform.paintPlatform(g);
        b.paintBalls(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                b.moveRight();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
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

