/**

 The "Background" class represents the background image in a graphical environment.
 It extends the "GameObject" superclass and implements the "Animatable" interface.
 */

package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Generator extends GameObject
{
    // instance variables

    private Control control;
    private GameState state;
    private double countDownToNextAsteroid;

    /**
     Constructor for the Background class.
     @param control a reference to a Control object.
     @param state a reference to a GameState object.
     */

    public Generator(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        countDownToNextAsteroid = 2.0;
    }

    /**
     Does not update the state of the Background object.
     @param timeElapsed the time elapsed since the last update, in seconds.
     */

    @Override
    public void update(double timeElapsed)
    {
        countDownToNextAsteroid -= timeElapsed;

        if (countDownToNextAsteroid <= 0)
        {
            countDownToNextAsteroid = 0.5;
            state.addGameObject(new Asteroid(control, state));
        }
    }

    /**
     Renders the image of the Background object on the screen using the specified Graphics object.
     @param g the Graphics object used to draw the object.
     */

    @Override
    public void draw(Graphics g)
    {
    }
    // how long till my next comet
}