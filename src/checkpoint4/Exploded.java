/**
 * this class creates an Exploded object that updates and draw itself
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Exploded extends GameObject {
    //fields
    private Control control;
    private GameState state;
    private int time = 1000;
    //private int width = 40;
    //private int height = 40;
    //private long lastUpdatedTime = 0;
    //private double interval = 5;

    public Exploded (Control control, GameState state)
    {
        // constructor
        /**
         * initializes the control and state of the class
         */
        this.control = control;
        this.state = state;
    }
    /**
     * If 20 milliseconds of time has elapsed during the update, the exploded image expires
     *
     *
     * @param timeElapsed the time elapsed since the last update, in seconds
     */
    @Override
    public void update(double timeElapsed) {
        time -= timeElapsed; // time is set to 1000 amd timeElapsed is subtracted each update
        if (time <= 100) // if time is less than 300 milliseconds, then expire the object
            hasExpired = true;
//        long currentTime = System.currentTimeMillis();
//        if (currentTime - lastUpdatedTime >= interval)
//        {
//            lastUpdatedTime = currentTime;
//            height += 10;
//            width += 10;
//        }
    }

    /**
     * Draws an exploded image at the last point of the path and sets the width and height of the image
     * @param g the Graphics object used to draw the object.
     */

    @Override
    public void draw(Graphics g) {
        BufferedImage explosion = control.getImage("exploded.png");
        int xInteger = control.getPath().getX(control.getPath().getPointCount() -1);
        int yInteger = control.getPath().getY(control.getPath().getPointCount() -1);
        g.drawImage(explosion, xInteger - 15, yInteger - 15, 40, 40, null);
    }
}
