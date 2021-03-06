package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         Listener that acts upon loading a file to display its contents.
 */
public class LoadActionListener
        implements ActionListener
{

    private final PersonsModel personsModel;

    /**
     * A new listener that holds the corresponding model.
     *
     * @param personsModel
     *         The corresponding model.
     */
    public LoadActionListener(PersonsModel personsModel)
    {
        this.personsModel = personsModel;
    }

    /**
     * Loads the XML file and cares its contents are displayed.
     */
    @Override
    public void actionPerformed(ActionEvent arg0)
    {

        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("XML-Files", "xml"));
        fc.showOpenDialog(null);

        try
        {
            JAXBContext context = JAXBContext.newInstance(PersonsModel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            PersonsModel pm = (PersonsModel) unmarshaller.unmarshal(fc.getSelectedFile());
            this.personsModel.loadPersons(pm);
        } catch (JAXBException ex)
        {
            ex.printStackTrace();
        }
    }

}
