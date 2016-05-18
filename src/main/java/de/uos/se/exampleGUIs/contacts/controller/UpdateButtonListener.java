package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;
import de.uos.se.exampleGUIs.contacts.view.Contacts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens on the update button.
 */
public class UpdateButtonListener
        implements ActionListener
{
    private final PersonsModel personsModel;
    private final Contacts view;
    private final DetailViewTblModel detailModel;
    private final JList persons;

    /**
     * A new instance.
     *
     * @param detailModel
     *         The model of the table that shows the details.
     * @param personsModel
     *         The model that holds all persons.
     * @param contacts
     *         The whole view which contains the widgets.
     * @param persons
     *         The {@link JList} of all the persons.
     */
    public UpdateButtonListener(DetailViewTblModel detailModel, PersonsModel personsModel, Contacts contacts, JList persons)
    {
        this.detailModel = detailModel;
        this.personsModel = personsModel;
        this.view = contacts;
        this.persons = persons;
    }

    /**
     * When an action was performed it deletes and inserts (= update) the person and cares that this is done consistently.
     */
    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        this.personsModel.deletePerson(this.view.getSelectedPerson());
        Person p = new Person((String) this.detailModel.getValueAt(1, 1), (String) this.detailModel.getValueAt(0, 1),
                              (String) this.detailModel.getValueAt(2, 1), (String) this.detailModel.getValueAt(3, 1));
        this.personsModel.addPerson(p);
        detailModel.setPerson(null);
        this.persons.getSelectionModel().clearSelection();
    }
}
