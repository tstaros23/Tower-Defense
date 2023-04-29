/**
 * this class creates a PhotonTorpedo that update and draw itself
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends GameObject {
    //fields
    private Control control;
    private GameState state;
    //private int width = 40;
    //private int height = 40;
    //private long lastUpdatedTime = 0;
    //private double interval = 5;

    public Explosion (Control control, GameState state)
    {
        // constructor
        this.control = control;
        this.state = state;
    }
    /**
     * Updates the state of the enemy object based on the given elapsed time.
     * Increases the pathPercentage by 0.07, updates the location of the enemy object
     * on the path, calculates the distance to the target, and checks if the enemy has
     * reached the end of the path.
     *
     * @param timeElapsed the time elapsed since the last update, in seconds
     */
    @Override
    public void update(double timeElapsed) {
        if (timeElapsed >= 20)
            hasExpired = true;
//        long currentTime = System.currentTimeMillis();
//        if (currentTime - lastUpdatedTime >= interval)
//        {
//            lastUpdatedTime = currentTime;
//            height += 10;
//            width += 10;
//        }
    }

    @Override
    public void draw(Graphics g) {
        BufferedImage explosion = control.getImage("pngegg.png");
        int xInteger = control.getPath().getX(control.getPath().getPointCount() -1);
        int yInteger = control.getPath().getY(control.getPath().getPointCount() -1);
        g.drawImage(explosion, xInteger, yInteger, 40, 40, null);
    }
}
