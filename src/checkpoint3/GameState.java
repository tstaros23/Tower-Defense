/**
 * This abstract class represents a game object that can be drawn and updated in the game.
 * It implements the Animatable interface to define the basic behavior of a game object.
 */

package checkpoint3;

import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

import static java.lang.Math.abs;

public class GameState
{

    // Fields

    private List<GameObject> currentFrameObjects;
    private List<GameObject> nextFrameObjects;
    private int cityCount;
    private Point mouseLocation;
    private double elapsedTime;
    private long lastFrameStartTime;

    /**
     * Constructor for the GameState class.
     * Initializes the currentFrameObjects list and sets the cityCount to 20.
     */

    public GameState ()
    {
        currentFrameObjects = new ArrayList<GameObject>();
        cityCount = 20;
        lastFrameStartTime = System.currentTimeMillis();
    }
    public double getElapsedTime ()
    {
        return elapsedTime;
    }

    /**
     * Returns the number of cities in the game.
     *
     * @return The number of cities in the game.
     */

    public int getCityCount ()
    {
        return cityCount;
    }

    /**
     * Adjusts the number of cities in the game by a specified amount.
     *
     * @param amount The amount by which to adjust the city count.
     */

    public void adjustCityCount (int amount)
    {
        cityCount += amount;
    }

    /**
     * Returns the location of the mouse.
     *
     * @return The location of the mouse.
     */

    public Point getMouseLoc()
    {
        return mouseLocation;
    }

    /**
     * Sets the location of the mouse.
     *
     * @param mouseLoc The location of the mouse.
     */

    public void setMouseLocation(Point mouseLoc)
    {
        this.mouseLocation = mouseLoc;
    }

    /**
     * Returns the list of current game objects.
     *
     * @return The list of current game objects.
     */

    public List<GameObject> getCurrentObjects ()
    {
        return currentFrameObjects;
    }

    /**
     * Starts a new frame by creating a new empty list for the next frame and
     * adding all current objects to it.
     */

    public void startFrame ()
    {
        // Calculate how much time has elapsed since the previous start frame
        long currentFrameStartTime = System.currentTimeMillis();
        elapsedTime = currentFrameStartTime - lastFrameStartTime;
        lastFrameStartTime = currentFrameStartTime;

        nextFrameObjects = new ArrayList<GameObject>();    // Creates empty list
        nextFrameObjects.addAll(currentFrameObjects);      // Add all the current ones to the new list.
    }

    /**
     * Adds a new game object to the list of objects for the next frame.
     *
     * @param a The game object to add to the list of objects for the next frame.
     */

    public void addGameObject (GameObject a)
    {
        nextFrameObjects.add(a);
    }

    /**
     * Finishes the current frame by removing any expired objects from the next
     * frame and making the next frame the current frame.
     */

    public void finishFrame ()
    {
        // Remove any current objects that are expired from the
        // next frame.

        for (GameObject go : currentFrameObjects)
            if (go.hasExpired())
                nextFrameObjects.remove(go);


        currentFrameObjects = nextFrameObjects;
        nextFrameObjects = null;  // This makes it clear there is only a current list now.
    }

    public Targetable getNearestTargetableObject(Point point)
    {
        // finds nearest targetable object in the game and return it to us.
        //satellite calls this function to find the nearest object
        // use optimization loop
        // return null if there are no targetable object

            Targetable current = null;
            Point closest = null;
            boolean first = true;
            for (GameObject go : currentFrameObjects)
            {


                     // initialize current to the first instance of Comet or Asteroid
                 if (go instanceof Targetable)

                {
                    if (first)
                    {
                        current = (Targetable) go;
                        closest = current.getLocation();
                        first = false;
                    }
                    // get absolute value of the first gameObject in the list x and y value subtracted from the satellite x and y value
                    // add the differences together and compare to the added differences of the game object in the loop
                    // assign game object in the iteration to the current object if the difference is less than the current difference
                    double currentDifference = abs(current.getLocation().getX() - point.getX()) + abs(current.getLocation().getY() - point.getY());
                    double goDifference = abs(go.getLocation().getX() - point.getX()) + abs(go.getLocation().getY() - point.getY());
                    if (goDifference < currentDifference)
                        current = (Targetable) go;
                }

            }
        return current;
    }
}
