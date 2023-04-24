package checkpoint4;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class View extends JPanel
{

    // Fields

    private BufferedImage background;
    private Control control;
    private GameState state;

    // Constructor

    public View (Control control, GameState state)
    {
        this.control = control;
        this.state = state;

        JFrame f = new JFrame("Look Up");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of this panel.

        Dimension d = new Dimension (800, 600);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        this.setMaximumSize(d);

        // 'this' is our Runnable object, but it is also our JPanel.
        // Set the content area of the frame to be this panel.

        f.setContentPane(this);

        // Pack, or calculate the window size, center the window,
        // and make it visible.

        f.pack();
        f.setLocationRelativeTo(null);  // Centers window
        f.setVisible(true);
    }

    // Paint

    public void paint (Graphics g)
    {
        for (Animatable a : state.getCurrentObjects())
            a.draw(g);
    }
}
