package JumpooliGame;

import java.applet.Applet;
import java.awt.*;


public class WebGame extends Applet implements Runnable {

    int x = 400;
    int y = 25;
    double dx = 0;  //initial sped in x direction
    double dy = 0;  //initial sped in y direction
    int radius = 20;
    double gravity = 15;
    double energyloss = 0.65;
    double dt = 0.2;
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
            if ( x + dx > this.getWidth() - radius - 1 ) {
                x = this.getWidth() - radius - 1;
                dx = -dx;
            }
            if ( x + dx < 0 + radius ) {
                x = 0 + radius;
                dx = -dx;
            } else
                x += dx;

            if ( y > this.getHeight() - radius - 1 ) {
                y = this.getHeight() - radius - 1;
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

