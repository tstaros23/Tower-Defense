/**
 * The LookUp class is responsible for starting the GUI for the program
 * by creating a new instance of the Control class using SwingUtilities
 * and invoking it on the event dispatch thread.
 *  @author Theodore A. Staros
 *  @version April 19, 2023
 */

package checkpoint4;

import javax.swing.*;

public class LookUp
{


    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(new Control());
    }
}
