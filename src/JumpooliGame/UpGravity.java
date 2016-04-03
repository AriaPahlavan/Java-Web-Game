package JumpooliGame;

import java.awt.*;
import java.util.Random;

/**
 * WebGame
 * Created by Aria Pahlavan on Apr 2016.
 */
public class UpGravity extends Item {
    public UpGravity(int x) {
        super(x);
    }

    @Override
    public void paintItem(Graphics g) {
        Random r = new Random();
        switch (r.nextInt(4)) {
            case 0:
                g.setColor(Color.RED);
                break;
            case 1:
                g.setColor(Color.BLUE);
                break;
            case 2:
                g.setColor(Color.WHITE);
                break;
            case 3:
                g.setColor(Color.PINK);
                break;
            case 4:
                g.setColor(Color.magenta);
                break;
        }
        super.paintItem(g);
    }
}
