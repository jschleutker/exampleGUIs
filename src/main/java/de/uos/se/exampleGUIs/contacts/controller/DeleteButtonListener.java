package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;
import de.uos.se.exampleGUIs.contacts.view.Contacts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteButtonListener
        implements ActionListener
{

    private PersonsModel personsModel;
    private Contacts view;

    public DeleteButtonListener(PersonsModel personsModel, Contacts contacts)
    {
        this.personsModel = personsModel;
        this.view = contacts;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        Person selected = this.view.getSelectedPerson();
        this.personsModel.deletePerson(selected);
    }

}