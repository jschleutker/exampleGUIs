/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.complexExample.controller;

import de.uos.se.exampleGUIs.complexExample.model.MyListModel;
import de.uos.se.exampleGUIs.complexExample.view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class DeleteButtonListener
        implements ActionListener
{
    private final MyListModel _model;
    private final GUI _gui;

    /**
     * A new listener for the delete button.
     *
     * @param model
     *         The model which holds the data that may be changed by this class.
     * @param gui
     *         The GUI on which the data is displayed.
     */
    public DeleteButtonListener(MyListModel model, GUI gui)
    {
        this._model = model;
        this._gui = gui;
    }

    /**
     * When the delete button is clicked check whether there are items selected. If so delete them in the model.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (! this._gui.getSelectedItems().isEmpty())
        {
            this._model.remove(this._gui.getSelectedItems());
        }
    }
}
