/**
 * this class creates a Flame object that updates and draw itself
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Flame extends GameObject {
    //fields
    private Control control;
    private GameState state;
    private int time = 1000;
    private int width = 40;
    private int height = 40;
    private long lastUpdatedTime = 0;
    private double interval = 5;

    public Flame (Control control, GameState state)
    {
        // constructor
        /**
         * initializes the control and state of the class
         */
        this.control = control;
        this.state = state;
    }
    /**
     * If 20 milliseconds of time has elapsed during the update, the flame image expires
     *
     *
     * @param timeElapsed the time elapsed since the last update, in seconds
     */
    @Override
    public void update(double timeElapsed) {
        time -= timeElapsed; // time is set to 1000 amd timeElapsed is subtracted each update
        if (time <= 300)
            hasExpired = true;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdatedTime >= interval)
        {
            lastUpdatedTime = currentTime;
            height += 1;
            width -= 5;
        }
    }
    /**
     * Draws an flame image at the last point of the path and sets the width and height of the image
     * @param g the Graphics object used to draw the object.
     */
    @Override
    public void draw(Graphics g) {
        BufferedImage explosion = control.getImage("Flaming.jpeg");
        int xInteger = control.getPath().getX(control.getPath().getPointCount() -1);
        int yInteger = control.getPath().getY(control.getPath().getPointCount() -1);
        g.drawImage(explosion, xInteger - 10, yInteger -10, width, height, null);
    }
}
