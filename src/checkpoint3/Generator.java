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
    private double countDownToNextComet;
    private int asteroidCount;
    private int cometCount;
    private int numberOfAsteroids;
    private int numberOfComets;

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
        // time the game has passed
        countDownToNextComet = 2.0;
        countDownToNextAsteroid = 2.0;
        asteroidCount = 0;
        cometCount = 0;
        numberOfAsteroids = 5;
        numberOfComets = 2;
    }

    /**
     Does not update the state of the Background object.
     @param timeElapsed the time elapsed since the last update, in seconds.
     */

    @Override
    public void update(double timeElapsed)
    {
        countDownToNextAsteroid -= timeElapsed;
        countDownToNextComet -= timeElapsed;

        if (countDownToNextAsteroid <= 0)
        {
            countDownToNextAsteroid = 300.0;
            state.addGameObject(new Asteroid(control, state));
            asteroidCount++;
            if (asteroidCount == numberOfAsteroids)
            {
                countDownToNextAsteroid = countDownToNextAsteroid * 5;
                asteroidCount = 0;
                numberOfAsteroids++;
            }
        }
        if (countDownToNextComet <= 0)
        {
            countDownToNextComet = 300.0;
            state.addGameObject(new Comet(control, state));
            cometCount++;
            if (cometCount == numberOfComets)
            {
                countDownToNextComet = countDownToNextComet * 5;
                cometCount = 0;
                numberOfComets++;
            }
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