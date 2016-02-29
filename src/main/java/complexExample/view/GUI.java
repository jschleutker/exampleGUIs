/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package complexExample.view;

import complexExample.controller.AddButtonListener;
import complexExample.controller.DeleteButtonListener;
import complexExample.controller.InputFieldListener;
import complexExample.controller.MenuSaveListener;
import complexExample.model.MyListModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Collection;

/**
 * This is the class to display the GUI. The actual GUI elements are auto-generated.
 *
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */
public class GUI
        extends JFrame
{
    private static final long serialVersionUID = 1L;
    private final JList<String> contentList;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JTextField inputField;
    private final JMenuItem menuSave;
    private final JLabel textLabel;

    private final MyListModel _model;

    /**
     * Create the frame.
     *
     * @param model
     *         The model which holds the data to display.
     */
    public GUI(MyListModel model)
    {
        this._model = model;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        {
            this.contentList = new JList<>();
            this.contentList.setModel(this._model);
            this.contentList.setName("myList");
            this.contentList.setBounds(10, 69, 300, 682);
            contentPane.add(this.contentList);
        }
        {
            this.addButton = new JButton("add");
            this.addButton.setName("add");
            this.addButton.setBounds(320, 109, 254, 23);
            contentPane.add(this.addButton);
        }
        {
            this.deleteButton = new JButton("delete");
            this.deleteButton.setBounds(320, 143, 254, 23);
            contentPane.add(this.deleteButton);
        }
        {
            this.textLabel = new JLabel();
            this.textLabel.setBounds(320, 200, 254, 23);
            contentPane.add(this.textLabel);
        }
        {
            this.inputField = new JTextField();
            this.inputField.setBounds(320, 69, 254, 29);
            contentPane.add(this.inputField);
            this.inputField.setColumns(10);
        }
        {
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBounds(0, 0, 584, 21);
            contentPane.add(menuBar);
            {
                JMenu mnFile = new JMenu("File");
                mnFile.setName("file");
                menuBar.add(mnFile);
                {
                    this.menuSave = new JMenuItem("Save...");
                    this.menuSave.setName("save");
                    mnFile.add(this.menuSave);
                }
                {
                    JMenuItem menuExit = new JMenuItem("Exit");
                    mnFile.add(menuExit);
                }
            }
        }
        this.setupListeners();
    }

    /**
     * Merely a helper to set up the listener for the GUI elements which should be listened to.
     */
    private void setupListeners()
    {
        this.addButton.addActionListener(new AddButtonListener(this._model, this));
        this.deleteButton.addActionListener(new DeleteButtonListener(this._model, this));
        this.menuSave.addActionListener(new MenuSaveListener(this._model, this));
        this.inputField.addKeyListener(new InputFieldListener(this));
    }

    /**
     * @return The current input of the textfield on the GUI.
     */
    public String getTextFieldContent()
    {
        return this.inputField.getText();
    }

    public void setLabelContent(String s)
    {
        this.textLabel.setText(s);
    }

    /**
     * Clears the textfield on the GUI.
     */
    public void clearTextField()
    {
        this.inputField.setText("");
    }

    /**
     * @return The items that are currently selected in the List as a collection.
     */
    public Collection<String> getSelectedItems()
    {
        return this.contentList.getSelectedValuesList();
    }
}
