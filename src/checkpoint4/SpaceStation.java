package checkpoint4;

import java.awt.*;

public class SpaceStation extends GameObject implements Clickable
{
    // fields
    private Control control;
    private GameState state;
    private Point location;
    private boolean isMoving;

    //constructor
    public SpaceStation (Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        isMoving = true;
    }

    /**
     * Updates the state of the player object based on the given elapsed time.
     * If the player is moving, updates the location based on the mouse location.
     * Otherwise, checks if there is a target object within range, and if so,
     * creates a new photon torpedo object aimed at the target.
     *
     * @param timeElapsed the time elapsed since the last update, in seconds
     */

    @Override
    public void update(double timeElapsed)
    {

        if (isMoving) {
            // if the player is moving, update the location based on the mouse location
            location = state.getMouseLoc();
        }
        else
        {
            // if the player is not moving, check for nearby target objects
            Targetable target = state.getNearestTargetableObject(location);
            if (target != null)
            {
                // if a nearby target object is found, calculate the distance to it
                double distance = location.distance((target.getLocation().getX()), (target.getLocation().getY()));
                if (distance < 300)
                    // if the target is within range, create a new photon torpedo object aimed at it
                    state.addGameObject(new Missle(control, state, location,  target.getLocation(), (GameObject) target ));
            }

        }
        // else shoot
    }

    /**
     * if the location is not null, then we get the image from the filename and draw it at the location x, y
     * @param g the Graphics object used to draw the object.
     */

    @Override
    public void draw(Graphics g)
    {
        if (location != null)
        {
             g.drawImage(control.getImage("kisspng-spacecraft-clip-art-spaceship-png-clipart-5a77ef1533c079.291368811517809429212.jpg"), location.x, location.y, null);
        }
    }

    /**
     * if the satellite is moving, then we get the state of the mouse location.
     * if the satellite is not on the frame, then it has expired.
     * otherwise, set isMoving to false
     * keep checking if the satellite is in frame or not when clicked
     * @return true if the satellite is not moving and false if it is.
     */

    @Override
    public boolean consumeClick() {
        if (isMoving) {
            Point mouseLoc = state.getMouseLoc();
            if (mouseLoc.x < 0 || mouseLoc.y < 0 || mouseLoc.x > 600 || mouseLoc.y > 600)
                hasExpired = true;
            isMoving = false;
            location = mouseLoc;
            return true;
        }

        return false;
    }

}
