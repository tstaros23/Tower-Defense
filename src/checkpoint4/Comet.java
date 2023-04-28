package checkpoint4;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comet extends GameObject implements Targetable
{
    // instance variables

    private Control control;
    private GameState state;
    private double age;
    private double pathPercentage;
    private GameObject explosion;

    /**
     * Constructs a new Comet object with the specified Control and GameState.
     * @param control The Control object of the game
     * @param state The GameState object of the game
     */

    public Comet(Control control, GameState state, GameObject explosion)
    {
        this.control = control;
        this.state = state;
        this.explosion = explosion;
        pathPercentage = 0.0;
    }
    /**
     * Updates the position of the comet based on the amount of time elapsed.
     * @param timeElapsed The amount of time elapsed since the last update
     */
    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += (0.00016) * timeElapsed;
        age += timeElapsed;
        // System.out.println(pathPercentage);

        if (pathPercentage >= 1.00)
        {
            // Remove and add
            state.subtractCityCount(1);
            state.addGameObject(new Explosion(control, state));
            hasExpired = true;
            explosion.hasExpired = true;
        }
    }
    /**
     * Draws the comet at its current position.
     * @param g The Graphics object used to draw the comet
     */
    @Override
    public void draw(Graphics g)
    {
        BufferedImage comet = control.getImage("comet.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(comet, loc.x - comet.getWidth()/2, loc.y - comet.getHeight()/2, null);
    }

    @Override
    public Point getLocation() {
        return control.getPath().convertToCoordinates(pathPercentage);
    }
}
