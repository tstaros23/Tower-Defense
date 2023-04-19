/**

 The "Generator" class generates the comet and asteroid


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
        countDownToNextComet = 10.0;
        countDownToNextAsteroid = 2.0;
        asteroidCount = 0;
        cometCount = 0;
        numberOfAsteroids = 5;
        numberOfComets = 2;
    }

    /**
     * Updates the state of the game world based on the given elapsed time.
     * Decreases the countdown timers for asteroids and comets, and if they reach zero,
     * adds a new asteroid or comet object to the game world. Adjusts the countdown timers,
     * object counts, and object frequencies based on game state.
     *
     * @param timeElapsed the time elapsed since the last update, in seconds
     */

    @Override
    public void update(double timeElapsed)
    {
        // decrease the countdown timers for asteroids and comets
        countDownToNextAsteroid -= timeElapsed;
        countDownToNextComet -= timeElapsed;

        if (countDownToNextAsteroid <= 0)
        {
            // if the countdown timer for asteroids reaches zero, add a new asteroid object
            countDownToNextAsteroid = 300.0;
            state.addGameObject(new Asteroid(control, state));
            asteroidCount++;
            // if the maximum number of asteroids has been added, adjust the countdown timer and asteroid count
            if (asteroidCount == numberOfAsteroids)
            {
                countDownToNextAsteroid = countDownToNextAsteroid * 10;
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