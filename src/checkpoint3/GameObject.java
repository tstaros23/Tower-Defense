/**
 * This abstract class represents a game object that can be drawn and updated in the game.
 * It implements the Animatable interface to define the basic behavior of a game object.
 */

package checkpoint3;

abstract public class GameObject implements Animatable

    /**
     * A boolean value indicating whether the game object has expired and should be removed
     * from the game state.
     */
{
    protected boolean hasExpired;

    /**
     * Constructs a new game object with a default expired state of false.
     */

    public GameObject ()
    {
        hasExpired = false;
    }

    /**
     * Returns whether the game object has expired and should be removed from the game state.
     *
     * @return true if the game object has expired, false otherwise
     */
    public boolean hasExpired ()
    {
        return hasExpired;
    }
}
