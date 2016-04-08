package de.uos.se.exampleGUIs.contacts;

import de.uos.se.exampleGUIs.contacts.view.Contacts;

import java.awt.*;

/**
 * Created by sem on 08.04.2016.
 * <p>
 * Contains the main-class, the entry point.
 */
public class Main
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            try
            {
                Contacts frame = new Contacts();
                frame.setVisible(true);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}
