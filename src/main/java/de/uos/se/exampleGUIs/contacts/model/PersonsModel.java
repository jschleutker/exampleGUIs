package de.uos.se.exampleGUIs.contacts.model;

import javax.swing.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jan-Philipp Schleutker
 */
@SuppressWarnings ("unused")
@XmlRootElement (name = "contacts")
public class PersonsModel
        extends AbstractListModel<Person>
{
    private static final long serialVersionUID = - 6682977301079315975L;
    private List<Person> persons;

    public PersonsModel()
    {
        this.persons = new LinkedList<>();
    }

    public void addPerson(Person p)
    {
        this.persons.add(p);
        this.fireContentsChanged(this, this.getSize() - 2, this.getSize() - 1);
    }

    public void deletePerson(Person p)
    {
        this.persons.remove(p);
        this.fireContentsChanged(this, this.getSize() - 2, this.getSize() - 1);
    }

    public void changedAPerson()
    {
        this.fireContentsChanged(this, 0, this.getSize() - 1);
    }

    @Override
    public Person getElementAt(int arg0)
    {
        return this.persons.get(arg0);
    }

    @Override
    public int getSize()
    {
        return this.persons.size();
    }

    @XmlElement (name = "person")
    private List<Person> getPersons()
    {
        return this.persons;
    }

    @SuppressWarnings ("unused")
    private void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }

    public void loadPersons(PersonsModel pm)
    {
        this.persons = pm.persons;
        this.fireContentsChanged(this, 0, this.persons.size() - 1);
    }
}
