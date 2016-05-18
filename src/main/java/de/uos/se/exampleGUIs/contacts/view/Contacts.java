package de.uos.se.exampleGUIs.contacts.view;

import de.uos.se.exampleGUIs.contacts.controller.*;
import de.uos.se.exampleGUIs.contacts.model.DetailViewTblModel;
import de.uos.se.exampleGUIs.contacts.model.Person;
import de.uos.se.exampleGUIs.contacts.model.PersonsModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         The view class for the contacts. Hold several widgets to display and manipulate data.
 */
public class Contacts
        extends JFrame
{
    private static final long serialVersionUID = - 1187431096814678063L;
    private final JList<Person> list;
    private final JButton btnUpdate;

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
        list.addListSelectionListener(new SelectedListener(personsModel, detailViewTblModel, this));
        list.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "del");
        list.getActionMap().put("del", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                final int selectedIndex = list.getSelectedIndex();
                if (selectedIndex > - 1)
                {
                    PersonsModel model = (PersonsModel) list.getModel();
                    model.deletePerson(model.getElementAt(selectedIndex));
                }
            }
        });
        contentPane.add(list);

        this.btnUpdate = new JButton("Update");
        this.btnUpdate.setName("update_button");
        this.btnUpdate.setBounds(274, 150, 89, 23);
        this.btnUpdate.addActionListener(new UpdateButtonListener(detailViewTblModel, personsModel, this, this.list));
        contentPane.add(btnUpdate);
        this.btnUpdate.setEnabled(false);

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

        contentPane.add(table);
    }

    /**
     * Returns the person currently selected in the list on the left.
     *
     * @return The currently selected person.
     */
    public Person getSelectedPerson()
    {
        return this.list.getSelectedValue();
    }

    /**
     * Get the {@link JButton} to update contact information.
     *
     * @return The button as described above.
     */
    public JButton getBtnUpdate()
    {
        return this.btnUpdate;
    }
}
