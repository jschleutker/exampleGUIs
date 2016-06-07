package de.uos.se.exampleGUIs.contacts;

import de.uos.se.exampleGUIs.contacts.view.Contacts;

import java.awt.*;

/**
 * Contains the main-class, the entry point.
 */
public class ContactsMain
{
    /**
     * Invokes everything in the EDT since Swing isn't thread-safe.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Contacts frame = new Contacts();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
