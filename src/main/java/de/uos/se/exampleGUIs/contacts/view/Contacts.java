package de.uos.se.exampleGUIs.contacts.view;

import de.uos.se.exampleGUIs.contacts.controller.*;
import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * @author Jan-Philipp Schleutker
 */
public class Contacts
        extends JFrame
{

    /**
     *
     */
    private static final long serialVersionUID = - 1187431096814678063L;
    private final JList<Person> list;

    /**
     * Create the frame.
     */
    public Contacts()
    {

        DetailViewTblModel detailViewTblModel = new DetailViewTblModel();
        PersonsModel personsModel = new PersonsModel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.list = new JList<>();
        list.setBounds(10, 38, 240, 713);
        list.setModel(personsModel);
        list.addListSelectionListener(new SelectedListener(personsModel, detailViewTblModel));
        contentPane.add(list);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(260, 728, 89, 23);
        btnDelete.addActionListener(new DeleteButtonListener(personsModel, this));
        contentPane.add(btnDelete);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 584, 21);
        contentPane.add(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNew = new JMenuItem("New...");
        mntmNew.addActionListener(new NewActionListener(personsModel));
        mnNewMenu.add(mntmNew);

        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.addActionListener(new SaveActionListener(personsModel));

        JMenuItem mntmLoad = new JMenuItem("Load");
        mntmLoad.addActionListener(new LoadActionListener(personsModel));

        mnNewMenu.add(mntmLoad);
        mnNewMenu.add(mntmSave);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnNewMenu.add(mntmExit);

        JTable table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setBounds(274, 39, 300, 64);
        table.setModel(detailViewTblModel);
        table.setRowSorter(new TableRowSorter<>(detailViewTblModel));

        contentPane.add(table);
    }

    public Person getSelectedPerson()
    {
        return this.list.getSelectedValue();
    }
}
