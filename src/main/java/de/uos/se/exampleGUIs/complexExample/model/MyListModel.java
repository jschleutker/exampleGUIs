/*
 * Copyright (c) 2016.
 * This code is part of a project that aims to detect GUI elements on a Java Swing UI.
 * Contact: fwilke@uos.de and jschleutker@uos.de
 */

package de.uos.se.exampleGUIs.complexExample.model;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * The model class.
 *
 * @author Jan-Philipp Schleutker <jschleutker@uos.de>
 */

public class MyListModel
        implements ListModel<String>
{

    private List<String> _list;
    private final Path _filePath;
    private final List<ListDataListener> _listDataListener;

    /**
     * Creates a new instance of the model.
     *
     * @param filePath
     *         The path to the file where to read and write the list data.
     */
    public MyListModel(Path filePath)
    {
        this._list = new LinkedList<>();
        this._filePath = filePath;
        this._listDataListener = new LinkedList<>();
        this.readData();
    }

    /**
     * Reads the data from a file and stores them into a list. This list is the data type that holds the content that is
     * displayed and can be changed.
     */
    private void readData()
    {
        try
        {
            this._list = Files.readAllLines(this._filePath);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        this._list.forEach(System.out::println);
    }

    /**
     * This method stores the data the list currently contains.
     */
    public boolean saveData()
    {
        try
        {
            Files.write(this._filePath, this._list, StandardOpenOption.WRITE);
            return true;
        } catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void addListDataListener(ListDataListener l)
    {
        this._listDataListener.add(l);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public String getElementAt(int index)
    {
        if (index >= this.getSize())
            return null;
        return this._list.get(index);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public int getSize()
    {
        return this._list.size();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void removeListDataListener(ListDataListener l)
    {
        this._listDataListener.remove(l);
    }

    /**
     * This method should be called to add an element to the list. Triggers an event to notify the observers.
     *
     * @param s
     *         The string to be added to the list.
     */
    public void add(String s)
    {
        this._list.add(s);
        for (ListDataListener listDataListener : this._listDataListener)
        {
            listDataListener
                    .contentsChanged(new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, 0, this._list.size()));
        }
    }

    /**
     * This method is to remove one or more elements from the list.
     *
     * @param c
     *         A collections holding all elements that are deleted.
     */
    public void remove(Collection<String> c)
    {
        this._list.removeAll(c);
        for (ListDataListener listDataListener : this._listDataListener)
        {
            listDataListener
                    .contentsChanged(new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, 0, this._list.size()));
        }
    }

}
