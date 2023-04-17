package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Comet extends GameObject
{
    // instance variables

    private Control control;
    private GameState state;
    private double pathPercentage;

    /**
     * Constructs a new Comet object with the specified Control and GameState.
     * @param control The Control object of the game
     * @param state The GameState object of the game
     */

    public Comet(Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
    }
    /**
     * Updates the position of the comet based on the amount of time elapsed.
     * @param timeElapsed The amount of time elapsed since the last update
     */
    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += 0.0015;

        // If the comet has reached the end of its path, remove it from the game
        // and add a new Comet object to the GameState.

        if (pathPercentage >= 1.00)
        {
            // Remove and add

            hasExpired = true;
            state.addGameObject(new Comet(control, state));
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
}
