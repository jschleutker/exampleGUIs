package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;
import de.uos.se.exampleGUIs.contacts.view.Contacts;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         Listens when something on the list to display the persons changed.
 */
public class SelectedListener
        implements ListSelectionListener
{

    private final PersonsModel personsModel;
    private final DetailViewTblModel detailModel;
    private final Contacts view;

    /**
     * Creates a new instance.
     *
     * @param personsModel
     *         The corresponding model.
     * @param detailViewTableModel
     *         The table to show the details of a selected list entry.
     * @param view
     *         The view which contains all the widgets.
     */
    public SelectedListener(PersonsModel personsModel, DetailViewTblModel detailViewTableModel, Contacts view)
    {
        this.personsModel = personsModel;
        this.detailModel = detailViewTableModel;
        this.view = view;
    }

    /**
     * After a person was selected in the list, their details are shown in the detail view and enables the button that triggers changes to be made permanently.
     * When no person is selected (anymore) the button gets disabled and the detail view is empty.
     */
    @Override
    public void valueChanged(ListSelectionEvent arg0)
    {
        @SuppressWarnings ("unchecked") JList<String> source = (JList<String>) arg0.getSource();
        int selectedIdx = source.getSelectedIndex();
        if (selectedIdx > - 1)
        {
            Person p = this.personsModel.getElementAt(selectedIdx);
            this.detailModel.setPerson(p);
            this.view.getBtnUpdate().setEnabled(true);
        } else
        {
            this.detailModel.setPerson(null);
            this.view.getBtnUpdate().setEnabled(false);
        }
    }

}
