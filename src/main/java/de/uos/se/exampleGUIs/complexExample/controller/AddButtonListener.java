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
public class AddButtonListener
        implements ActionListener
{
    private final MyListModel _model;
    private final GUI _gui;

    /**
     * Create a controller instance for the add button.
     *
     * @param model
     *         The model which holds the data that may be changed by this class.
     * @param gui
     *         The GUI on which the data is displayed.
     */
    public AddButtonListener(MyListModel model, GUI gui)
    {
        this._model = model;
        this._gui = gui;
    }

    /**
     * Checks whether the content of the text field on the GUI is empty when trimmed. If not adds the content to the
     * model.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s = this._gui.getTextFieldContent();
        if (! s.trim().equals(""))
        {
            this._model.add(s);
        }

        this._gui.clearTextField();
        JOptionPane.showInputDialog(null, "blaaaaaa");
    }
}
