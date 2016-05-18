package de.uos.se.exampleGUIs.contacts.model;

import javax.swing.table.AbstractTableModel;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         A model for the detail view which shows all information about a person.
 */
public class DetailViewTblModel
        extends AbstractTableModel
{

    private Person currentPerson;

    /**
     * Create a new instance with the current person to display set to null.
     */
    public DetailViewTblModel()
    {
        this.currentPerson = null;
    }

    private static final long serialVersionUID = - 8459432140350902413L;

    public void setPerson(Person p)
    {
        this.currentPerson = p;
        this.fireTableDataChanged();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getColumnCount()
    {
        return 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRowCount()
    {
        return 4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getValueAt(int row, int column)
    {

        if (column == 0)
        {
            switch (row)
            {
                case 0:
                    return "Name: ";
                case 1:
                    return "First Name: ";
                case 2:
                    return "E-Mail: ";
                case 3:
                    return "Phone: ";
                default:
                    throw new Error("cannot happen");
            }
        }

        if (this.currentPerson == null)
            return "";

        switch (row)
        {
            case 0:
                return this.currentPerson.getLastName();
            case 1:
                return this.currentPerson.getFirstName();
            case 2:
                return this.currentPerson.getEmail();
            case 3:
                return this.currentPerson.getPhone();
        }

        throw new Error("Cannot happen.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return col == 1;
    }

}
