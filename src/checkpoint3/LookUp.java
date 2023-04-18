/**
 * The LookUp class is responsible for starting the GUI for the program
 * by creating a new instance of the Control class using SwingUtilities
 * and invoking it on the event dispatch thread.
 */

package checkpoint3;

import javax.swing.*;

public class LookUp
{


    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(new Control());
    }
}
