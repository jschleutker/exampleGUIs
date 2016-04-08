package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.PersonsModel;
import de.uos.se.exampleGUIs.contacts.view.Contacts;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class TableKeyListener
        extends KeyAdapter
{

    private PersonsModel personsModel;
    private Contacts view;

    public TableKeyListener(PersonsModel personsModel, Contacts contacts)
    {
        this.personsModel = personsModel;
        this.view = contacts;
    }

    @Override
    public void keyTyped(KeyEvent arg0)
    {

        //TODO: implement that a person can be altered
    }

}
