package de.uos.se.exampleGUIs.contacts.model;

import com.sun.istack.internal.NotNull;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Jan-Philipp Schleutker
 *         <p>
 *         Model-class for a single person.
 */
public class Person
{

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    /**
     * Creates a new person. First and last name being mandatory.
     *
     * @param firstName
     *         The first name of the person.
     * @param lastName
     *         The last name of the person.
     * @param email
     *         The E-Mail of the person.
     * @param phone
     *         The phone number of the person.
     */
    public Person(@NotNull String firstName, @NotNull String lastName, String email, String phone)
    {
        if (firstName == null || lastName == null)
        {
            throw new IllegalArgumentException("first and last name are mandatory!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    /**
     * For JAXB purposes only.
     */
    private Person()
    {
    }

    /**
     * @return The first name of the person.
     */
    @XmlElement (name = "first_name")
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return The last name of the person.
     */
    @XmlElement (name = "last_name")
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return The E-Mail of the person.
     */
    @XmlElement (name = "email")
    public String getEmail()
    {
        return email;
    }

    /**
     * @return The phone number of the person.
     */
    @XmlElement (name = "phone")
    public String getPhone()
    {
        return phone;
    }

    /**
     * Sets the first name. Private, needed for JAXB.
     *
     * @param s
     *         The first name to set.
     */
    private void setFirstName(String s)
    {
        this.firstName = s;
    }

    /**
     * Sets the last name. Private, needed for JAXB.
     *
     * @param s
     *         The last name to set.
     */
    private void setLastName(String s)
    {
        this.lastName = s;
    }

    /**
     * Sets the e-mail. Private, needed for JAXB.
     *
     * @param s
     *         The e-mail to set.
     */
    private void setEmail(String s)
    {
        this.email = s;
    }

    /**
     * Sets the phone number. Private, needed for JAXB.
     *
     * @param s
     *         The number to set.
     */
    private void setPhone(String s)
    {
        this.phone = s;
    }

    /**
     * @return A string consisting of last and first name of the person.
     */
    @Override
    public String toString()
    {
        return this.lastName + ", " + this.firstName;
    }
}
