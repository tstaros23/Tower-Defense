package checkpoint3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Asteroid extends GameObject implements Targetable
{
    // Instance variables
    private Control control;
    private GameState state;
    private double pathPercentage;
    private double age;

    /**
     Constructor for the Asteroid class.
     @param control a reference to a Control object.
     @param state a reference to a GameState object.
     */
    public Asteroid (Control control, GameState state)
    {
        this.control = control;
        this.state = state;
        pathPercentage = 0.0;
        age = 0.0;
    }

    /**
     Updates the state of the Asteroid object based on the time elapsed since the last update.
     Increments the path percentage and adds a new Asteroid object if the path percentage exceeds 1.0.
     @param timeElapsed the time elapsed since the last update, in seconds.
     */
    @Override
    public void update(double timeElapsed)
    {
        pathPercentage += (0.0016) * timeElapsed;
        age += timeElapsed;
       // System.out.println(pathPercentage);

        if (pathPercentage >= 1.00)
        {
            // Remove and add
            hasExpired = true;
            //state.addGameObject(new Asteroid(control, state));
        }
    }

    /**
     Renders the image of the Asteroid object on the screen using the specified Graphics object.
     @param g the Graphics object used to draw the object.
     */

    @Override
    public void draw(Graphics g)
    {
        BufferedImage asteroid = control.getImage("asteroid.png");
        Point loc = control.getPath().convertToCoordinates(pathPercentage);
        g.drawImage(asteroid, loc.x - asteroid.getWidth()/2, loc.y - asteroid.getHeight()/2, null);
    }

    @Override
    public Point getLocation() {
        //  asteroid coordinates: Point loc = control.getPath().convertToCoordinates(pathPercentage);
        // towers can now find the nearby targetable object
        return control.getPath().convertToCoordinates(pathPercentage);
    }
}
