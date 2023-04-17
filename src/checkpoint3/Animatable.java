package checkpoint3;

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
