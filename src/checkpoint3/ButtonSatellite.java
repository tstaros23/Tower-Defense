/**

 The "ButtonSatellite" class represents a clickable button object in a graphical environment
 that creates a "Satellite" object when clicked. It extends the "GameObject" superclass and
 implements the "Clickable" interface.
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint3;

import java.awt.*;

public class ButtonSatellite extends GameObject implements Clickable
{
    // instance variables
    private Control control;
    private GameState state;

    /**
     Constructor for the ButtonSatellite class.
     @param control a reference to a Control object.
     @param state a reference to a GameState object.
     */

    public ButtonSatellite(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }

    /**
     Does not update the state of the ButtonSatellite object.
     @param timeElapsed the time elapsed since the last update, in seconds.
     */

    @Override
    public void update(double timeElapsed)
    {

    }

    /**
     Renders the button object on the screen using the specified Graphics object.
     @param g the Graphics object used to draw the object.
     */
    @Override
    public void draw(Graphics g)
    {
         g.setColor(Color.BLACK);
         g.fillRoundRect(630, 400, 75, 75, 10, 10);
         g.setColor(Color.GRAY);
         g.fillRoundRect(632, 402, 71, 71, 10, 10);

         g.drawImage(control.getImage("probe.png"), 640, 410, null);
    }

    /**
     Checks if the button is clicked and creates a new Satellite object if it is.
     @return true if the button is clicked, false otherwise.
     */

    @Override
    public boolean consumeClick()
    {
        Point mouseLoc = state.getMouseLoc();
        if (mouseLoc.x >= 630 && mouseLoc.x <= 630+75 &&
            mouseLoc.y >= 400 && mouseLoc.y <= 400+75)
        {
            state.addGameObject(new Satellite(control, state));
            return true;
        }

        return false;
    }
}
