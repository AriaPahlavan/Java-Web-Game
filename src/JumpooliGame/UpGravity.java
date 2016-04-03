package JumpooliGame;

import java.awt.*;

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
        g.setColor(Color.RED);
        super.paintItem(g);
    }
}
