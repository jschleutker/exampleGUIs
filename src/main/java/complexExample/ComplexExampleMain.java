/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package complexExample;

import complexExample.model.MyListModel;
import complexExample.view.GUI;

import java.awt.*;
import java.nio.file.Files;

/**
 * A complex example for a GUI. This does not mean it is extensively complex but more complex than another example and still reasonable to use for unit testing.
 *
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class ComplexExampleMain
{

    /**
     * The main method which executes the GUI thread in the event dispatch thread (EDT).
     * <b>Note:</b> The data is stored in a temporary file. If there is any need to access it by another instance, the location should be changed to a persistent location.
     *
     * @param args
     *         Application's arguments.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            try
            {
                GUI frame = new GUI(new MyListModel(Files.createTempFile("listfile", null)));
                frame.setVisible(true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}
