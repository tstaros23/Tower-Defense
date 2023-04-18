package checkpoint3;

import javax.swing.*;
import java.awt.Point;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class Control implements Runnable, ActionListener, MouseListener, MouseMotionListener
{
    // fields

    private View view;
    private GameState state;
    private Timer timer;
    private Path path;
    private TreeMap<String,BufferedImage> imageCache;
    public boolean mousePressed;

    /**
     * Runs the game.
     * Initializes the image cache, path, game state, view, and timer, and starts the timer.
     */

    public void run ()
    {
        imageCache = new TreeMap<String,BufferedImage>();
        mousePressed = false;

        path = loadPath("ted4.txt");

        state = new GameState();
        view = new View(this, state);
        view.addMouseListener(this);
        view.addMouseMotionListener(this);

        state.startFrame();

        MenuArea menuArea = new MenuArea(this, state);

        state.addGameObject(new Background(this, state));
        state.addGameObject(menuArea);
        state.addGameObject(new Generator(this, state));

        menuArea.setUpMenuArea();

        state.finishFrame();

        timer = new Timer(16,this);
        timer.start();
    }

    /**
     * Loads an image from the given filename.
     *
     * @param filename The filename of the image to load
     * @return The loaded image, or null if the file could not be read
     */

    private BufferedImage loadImage (String filename)
    {
        System.out.println("Loading " + filename);
        try
        {
            return javax.imageio.ImageIO.read(new File(filename));
        }
        catch (IOException e)
        {
            System.out.println("Could not read " + filename);
            return null;
        }
    }

    /**
     * Returns the image with the given filename, loading it if necessary.
     *
     * @param filename The filename of the image to return
     * @return The image with the given filename, or null if the file could not be read
     */

    public BufferedImage getImage (String filename)
    {
        if (! imageCache.containsKey(filename))
        {
            BufferedImage b = loadImage(filename);
            imageCache.put(filename, b);
        }

        return imageCache.get(filename);
    }

    /**
     * Loads the game path from the given filename.
     *
     * @param filename The filename of the path file to load
     * @return The loaded path, or null if the file could not be loaded
     */

    private Path loadPath (String filename)
    {
        try
        {
            Scanner in = new Scanner(new File(filename));
            Path p = new Path(in);
            in.close();
            return p;
        }
        catch (IOException e)
        {
            System.out.println("Could not load the path.");

            return null;
        }
    }

    /**
     * Returns the game path.
     *
     * @return The game path
     */

    public Path getPath ()
    {
        return path;
    }

    /**
     * Handles timer events by updating the game state and rendering the view.
     *
     * @param e The ActionEvent that triggered the timer
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        // Main update loop

        state.startFrame();
        // loop through all game objects, update each one

        for (Animatable a : state.getCurrentObjects())
            a.update(state.getElapsedTime());

        // if the mouse was pressed, let the objects decide what to do

        if (mousePressed)
            for (int pos = state.getCurrentObjects().size() - 1;
                 pos >= 0; pos--)
            {
                Animatable a = state.getCurrentObjects().get(pos);

                if (a instanceof Clickable) {
                    Clickable c = (Clickable) a;
                    if (c.consumeClick())
                        break;
                }
            }

        mousePressed = false;

        state.finishFrame();

        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }
    /**
     * Handles mouse clicks by setting the mouse location and flagging the mouse as pressed.
     *
     * @param e The MouseEvent that triggered the click
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
    /**
     * Handles mouse movements by setting the mouse location.
     *
     * @param e The MouseEvent that triggered the movement
     */

    @Override
    public void mouseDragged(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        state.setMouseLocation(new Point(e.getX(), e.getY()));
    }
}
