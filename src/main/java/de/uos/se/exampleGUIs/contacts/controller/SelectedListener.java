package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SelectedListener
        implements ListSelectionListener
{

    private PersonsModel personsModel;
    private DetailViewTblModel detailModel;

    public SelectedListener(PersonsModel personsModel, DetailViewTblModel detailViewTableModel)
    {
        this.personsModel = personsModel;
        this.detailModel = detailViewTableModel;
    }

    @Override
    public void valueChanged(ListSelectionEvent arg0)
    {
        JList<String> source = (JList) arg0.getSource();
        int selectedIdx = source.getSelectedIndex();
        Person p = this.personsModel.getElementAt(selectedIdx);
        this.detailModel.setPerson(p);
    }

}
