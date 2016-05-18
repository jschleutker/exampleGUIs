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
 *         <p>
 *         Listener that handles saving the data into a XML file by JAXB.
 */
public class SaveActionListener
        implements ActionListener
{

    private final PersonsModel personsModel;

    /**
     * A new instance that holds the corresponding model.
     *
     * @param personsModel
     *         The corresponding model.
     */
    public SaveActionListener(PersonsModel personsModel)
    {
        this.personsModel = personsModel;
    }

    /**
     * After a action was performed the content of the model is written out by the JAXB mechanism into a XML-file.
     */
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
