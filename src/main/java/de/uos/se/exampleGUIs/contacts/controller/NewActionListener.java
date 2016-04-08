package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan-Philipp Schleutker
 */
public class NewActionListener
        implements ActionListener
{

    private final PersonsModel model;

    public NewActionListener(PersonsModel model)
    {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        JTextField lastName = new JTextField();
        JTextField firstName = new JTextField();
        JTextField email = new JTextField();
        JTextField phone = new JTextField();

        Object[] message = {"Last Name: ", lastName, "First Name: ", firstName, "E-Mail: ", email, "Phone: ", phone};

        int i = JOptionPane.showConfirmDialog(null, message, "Create A New User", JOptionPane.OK_CANCEL_OPTION);
        if (i == 0)
        {
            Person p = new Person(firstName.getText(), lastName.getText(), email.getText(), phone.getText());
            this.model.addPerson(p);
        }
    }

}
