/**

 The "ButtonSatellite" class represents a clickable button object in a graphical environment
 that creates a "Satellite" object when clicked. It extends the "GameObject" superclass and
 implements the "Clickable" interface.
 @author Theodore A. Staros
 @version April 19, 2023
 */

package checkpoint4;

import java.awt.*;

public class ButtonSpaceStation extends GameObject implements Clickable
{
    // instance variables
    private Control control;
    private GameState state;

    /**
     Constructor for the ButtonSatellite class.
     @param control a reference to a Control object.
     @param state a reference to a GameState object.
     */

    public ButtonSpaceStation(Control control, GameState state)
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
        g.fillRoundRect(630, 250, 75, 100, 10, 10);
        g.setColor(Color.GRAY);
        g.fillRoundRect(632, 252, 71, 100, 10, 10);

        g.drawImage(control.getImage("kisspng-spacecraft-clip-art-spaceship-png-clipart-5a77ef1533c079.291368811517809429212.jpg"), 630, 252, null);
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
                mouseLoc.y >= 250 && mouseLoc.y <= 250+75)
        {
            state.addGameObject(new SpaceStation(control, state));
            state.adjustMoney(100);
            return true;
        }

        if (state.getMoney() <= 0)
            return false;

        return false;
    }
}
