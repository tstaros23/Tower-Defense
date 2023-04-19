package checkpoint3;

import java.awt.*;

public class Satellite extends GameObject implements Clickable
{
    // fields
    private Control control;
    private GameState state;
    private Point location;
    private boolean isMoving;

    //constructor
    public Satellite(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
        isMoving = true;
    }

    /**
     * if the satellite is moving, then we want to update the location
     * @param timeElapsed the time elapsed since the last update, in seconds.
     */

    @Override
    public void update(double timeElapsed)
    {

        if (isMoving) {
            location = state.getMouseLoc();
        }
        else
        {
            Targetable target = state.getNearestTargetableObject(location);
            if (target != null)
            {
                double distance = location.distance((target.getLocation().getX()), (target.getLocation().getY()));
                if (distance < 300)
                    state.addGameObject(new PhotonTorpedo(control, state, location,  target.getLocation(), (GameObject) target ));
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
            g.drawImage(control.getImage("probe.png"), location.x, location.y, null);
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
