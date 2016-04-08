package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;
import de.uos.se.exampleGUIs.contacts.view.Contacts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sem on 08.04.2016.
 */
public class UpdateButtonListener
        implements ActionListener
{
    private final PersonsModel personsModel;
    private final Contacts view;
    private final DetailViewTblModel detailModel;

    public UpdateButtonListener(DetailViewTblModel detailModel, PersonsModel personsModel, Contacts contacts)
    {
        this.detailModel = detailModel;
        this.personsModel = personsModel;
        this.view = contacts;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        this.personsModel.deletePerson(this.view.getSelectedPerson());
        Person p = new Person((String) this.detailModel.getValueAt(0, 1), (String) this.detailModel.getValueAt(1, 1),
                              (String) this.detailModel.getValueAt(2, 1), (String) this.detailModel.getValueAt(3, 1));
        this.personsModel.addPerson(p);
    }
}
