/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.complexExample.controller;

import de.uos.se.exampleGUIs.complexExample.model.MyListModel;
import de.uos.se.exampleGUIs.complexExample.view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class MenuSaveListener
        implements ActionListener
{
    private final MyListModel _model;
    private final GUI _gui;

    /**
     * Create a new listener for the menu option to save.
     *
     * @param model
     *         The model which is responsible to save the data.
     * @param gui
     *         The view which displays the data.
     */
    public MenuSaveListener(MyListModel model, GUI gui)
    {
        this._model = model;
        this._gui = gui;
    }

    /**
     * This method is to signal the model to save the data. A message appears whether it could stored.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this._gui);
        if (this._model.saveData())
        {
            JOptionPane
                    .showConfirmDialog(this._gui, "The data could be stored", "Sucessful!", JOptionPane.DEFAULT_OPTION,
                                       JOptionPane.INFORMATION_MESSAGE);
        } else
        {
            JOptionPane.showConfirmDialog(this._gui, "The data could not be stored", "Error...!",
                                          JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }
}
