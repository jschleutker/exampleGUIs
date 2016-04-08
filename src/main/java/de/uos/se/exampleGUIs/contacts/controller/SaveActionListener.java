package de.uos.se.exampleGUIs.contacts.controller;

import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan-Philipp Schleutker
 */
public class SaveActionListener
        implements ActionListener
{

    private PersonsModel personsModel;

    public SaveActionListener(PersonsModel personsModel)
    {
        this.personsModel = personsModel;
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("XML-Files", "xml"));
        fc.showSaveDialog(null);

        try
        {
            JAXBContext context = JAXBContext.newInstance(PersonsModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(this.personsModel, fc.getSelectedFile());
        } catch (JAXBException ex)
        {
            ex.printStackTrace();
        }
    }

}
