/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package complexExample.controller;


import complexExample.view.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class InputFieldListener
        implements KeyListener
{
    private final GUI _gui;

    public InputFieldListener(GUI gui)
    {
        this._gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        this._gui.setLabelContent(this._gui.getTextFieldContent());
    }
}
