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
    private JPanel contentPane;
    private JTable table;
    private JList<Person> list;

    private PersonsModel personsModel;
    private DetailViewTblModel detailViewTblModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Contacts frame = new Contacts();
                    frame.setVisible(true);
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Contacts()
    {

        this.detailViewTblModel = new DetailViewTblModel();
        this.personsModel = new PersonsModel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        this.list = new JList<>();
        list.setBounds(10, 38, 240, 713);
        list.setModel(this.personsModel);
        list.addListSelectionListener(new SelectedListener(personsModel, detailViewTblModel));
        contentPane.add(list);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(260, 728, 89, 23);
        btnDelete.addActionListener(new DeleteButtonListener(this.personsModel, this));
        contentPane.add(btnDelete);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 584, 21);
        contentPane.add(menuBar);

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNew = new JMenuItem("New...");
        mntmNew.addActionListener(new NewActionListener(this.personsModel));
        mnNewMenu.add(mntmNew);

        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.addActionListener(new SaveActionListener(this.personsModel));

        JMenuItem mntmLoad = new JMenuItem("Load");
        mntmLoad.addActionListener(new LoadActionListener(this.personsModel));

        mnNewMenu.add(mntmLoad);
        mnNewMenu.add(mntmSave);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnNewMenu.add(mntmExit);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setBounds(274, 39, 300, 64);
        table.setModel(this.detailViewTblModel);
        table.setRowSorter(new TableRowSorter<>(this.detailViewTblModel));

        contentPane.add(table);
    }

    public Person getSelectedPerson()
    {
        return this.list.getSelectedValue();
    }
}
