package de.uos.se.exampleGUIs.contacts.model;

import javax.swing.table.AbstractTableModel;

/**
 * @author Jan-Philipp Schleutker
 */
public class DetailViewTblModel
        extends AbstractTableModel
{

    private Person currentPerson;

    public DetailViewTblModel()
    {
        this.currentPerson = null;
    }

    /**
     *
     */
    private static final long serialVersionUID = - 8459432140350902413L;

    public void setPerson(Person p)
    {
        this.currentPerson = p;
        this.fireTableDataChanged();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public int getRowCount()
    {
        return 4;
    }

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

    @Override
    public boolean isCellEditable(int row, int col)
    {
        if (col == 1)
            return true;
        return false;
    }

}
