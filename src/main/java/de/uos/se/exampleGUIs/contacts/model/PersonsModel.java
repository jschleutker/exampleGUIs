package de.uos.se.exampleGUIs.contacts.model;

import javax.swing.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         A class that is the model for all persons together.
 */
@SuppressWarnings ("unused")
@XmlRootElement (name = "contacts")
public class PersonsModel
        extends AbstractListModel<Person>
{
    private static final long serialVersionUID = - 6682977301079315975L;
    private List<Person> persons;

    /**
     * Creates a new instance and thereby a new list to hold the persons.
     */
    public PersonsModel()
    {
        this.persons = new LinkedList<>();
    }

    /**
     * Add a new person.
     *
     * @param p
     *         The person to be added.
     */
    public void addPerson(Person p)
    {
        this.persons.add(p);
        this.fireContentsChanged(this, this.getSize() - 2, this.getSize() - 1);
    }

    /**
     * Deletes a person.
     *
     * @param p
     *         The person to be deleted.
     */
    public void deletePerson(Person p)
    {
        this.persons.remove(p);
        this.fireContentsChanged(this, this.getSize() - 2, this.getSize() - 1);
    }

    /**
     * To be called when a person has been changed. This triggers they are display with their new properties.
     */
    public void changedAPerson()
    {
        this.fireContentsChanged(this, 0, this.getSize() - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getElementAt(int arg0)
    {
        return this.persons.get(arg0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize()
    {
        return this.persons.size();
    }

    /**
     * {@inheritDoc}
     */
    @XmlElement (name = "person")
    private List<Person> getPersons()
    {
        return this.persons;
    }

    /**
     * For JAXB ...
     *
     * @param persons
     *         The persons to be set.
     */
    @SuppressWarnings ("unused")
    private void setPersons(List<Person> persons)
    {
        this.persons = persons;
    }

    /**
     * Loads persons from a model and cares they are displayed by firing an event.
     *
     * @param pm
     *         The {@link PersonsModel} which contains the persons.
     */
    public void loadPersons(PersonsModel pm)
    {
        this.persons = pm.persons;
        this.fireContentsChanged(this, 0, this.persons.size() - 1);
    }
}
