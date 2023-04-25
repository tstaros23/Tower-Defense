/**
 * The MenuArea class represents the game menu area that displays information
 * and allows the user to interact with the game.
 */

package checkpoint4;

import java.awt.*;

public class MenuArea extends GameObject
{
    private Control control;
    private GameState state;

    /**
     * Creates a new MenuArea object with the specified Control and GameState objects.
     *
     * @param control the Control object that handles user input
     * @param state the GameState object that stores the game state
     */

    public MenuArea(Control control, GameState state)
    {
        super();
        this.control = control;
        this.state = state;
    }
    /**
     * Sets up the menu area by adding a ButtonSatellite object to the game state.
     */
    public void setUpMenuArea()
    {
        state.addGameObject(new ButtonSatellite(control, state));
        state.addGameObject(new ButtonSpaceStation(control, state));
    }

    @Override
    public void update(double timeElapsed)
    {
        // nothing
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(600, 0, 200, 600);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Look up!", 630, 50);
        g.drawString("Cities left: " + state.getCityCount(), 630, 100);
        g.drawString("Money left: " + state.getMoney(), 600, 150);
    }
}
