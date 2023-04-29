/**
 * This animatable interface  provides update and draw abstract methods for animatable objects that can be drawn and updated in the game.
 * It implements the Animatable interface to define the basic behavior of a game object.
 *
 * @author Theodore A. Staros
 *  @version April 19, 2023
 */

package checkpoint4;

import java.awt.Graphics;

public interface Animatable

{

    /**
     Updates the state of the animated object based on the time elapsed since the last update.
     @param timeElapsed the time elapsed since the last update, in seconds.
     */
    public void update(double timeElapsed);
    /**
     Renders the animated object on the screen using the specified Graphics object.
     @param g the Graphics object used to draw the object.
     */
    public void draw(Graphics g);
}
