/**
 * this class creates a PhotonTorpedo that update and draw itself
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Missle extends GameObject {
    //fields
    private Control control;
    private GameState state;
    private Point source;
    private Point target;
    private Path path;
    private double pathPercentage;
    private GameObject enemy;

    public Missle (Control control, GameState state, Point source, Point target, GameObject enemy)
    {
        // constructor
        /**
         * initializes control, state, source, target, and enemy. Enemy is the target that the SpaceStation knows about
         * source is the missle. enemy relates to the target so that the spacestation knows about it.
         */
        this.control = control;
        this.state = state;
        this.source = source;
        this.target = target;
        this.enemy = enemy;
        this.pathPercentage = 0.0;

        path = new Path();
        path.add(source.x, source.y);
        path.add(target.x, target.y);
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
        // increase the path percentage by a fixed amount
        pathPercentage += 0.07;
        // get the location of the enemy on the path at the updated path percentage
        Point loc = path.convertToCoordinates(pathPercentage);
        // calculate the distance between the enemy location and the target
        double distance = loc.distance(target);
        // check if the enemy has reached the end of the path
        if (pathPercentage >= 1.00)
        {
            //set the expired flag on both the enemy object and this object to true

            enemy.hasExpired = true;
            hasExpired = true;
            if (state.getMoney() <= 1000)
                state.addMoney(10);
        }

    }

    @Override
    public void draw(Graphics g) {
        BufferedImage missle = control.getImage("missile-transparent-background-3d-rendering-illustration_494250-19756.jpeg");
        Point loc = path.convertToCoordinates(pathPercentage);
        g.drawImage(missle, loc.x, loc.y, null);
    }
}
